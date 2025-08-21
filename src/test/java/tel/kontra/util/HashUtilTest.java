package tel.kontra.util;

import org.junit.jupiter.api.Test;

import tel.kontra.HashAlgorithm;
import tel.kontra.HashStrategy;
import tel.kontra.HashUtil;
import tel.kontra.HashUtilFactory;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilTest {
    private static final String SALT = "testSalt";
    private static final String INPUT = "password123";
    private static final String DIFFERENT_INPUT = "password124";

    @Test
    void testHashAndVerifyWithDefaultStrategy() {
        HashUtil util = HashUtilFactory.create(SALT, HashAlgorithm.SHA_256);
        String hash = util.hash(INPUT);
        assertNotNull(hash);
        assertTrue(util.verifyHash(INPUT, hash));
        assertFalse(util.verifyHash(DIFFERENT_INPUT, hash));
    }

    @Test
    void testHashTruncation() {
        HashUtil util = HashUtilFactory.create(SALT, HashAlgorithm.SHA_256);
        String hash = util.hash(INPUT, 8);
        assertEquals(8, hash.length());
    }

    @Test
    void testEncodeAndMatches() {
        HashUtil util = HashUtilFactory.create(SALT, HashAlgorithm.SHA_256);
        String encoded = util.encode(INPUT);
        assertTrue(util.matches(INPUT, encoded));
        assertFalse(util.matches(DIFFERENT_INPUT, encoded));
    }

    @Test
    void testGetAppSalt() {
        HashUtil util = HashUtilFactory.create(SALT, HashAlgorithm.SHA_256);
        assertEquals(SALT, util.getAppSalt());
    }

    @Test
    void testCustomStrategy() {
        HashStrategy reverseStrategy = (input, salt) -> new StringBuilder(input + salt).reverse().toString();
        HashUtil util = HashUtilFactory.create(SALT, reverseStrategy);
        String hash = util.hash(INPUT);
        assertEquals(new StringBuilder(INPUT + SALT).reverse().toString(), hash);
    }
}
