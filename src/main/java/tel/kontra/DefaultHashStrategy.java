package tel.kontra;

import java.security.MessageDigest;

/**
 * Default implementation of HashStrategy using MessageDigest and HashAlgorithm enum.
 */
public class DefaultHashStrategy implements HashStrategy {
    private final HashAlgorithm algorithm;

    public DefaultHashStrategy(HashAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String hash(String input, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm.getAlgorithm());
            md.update(salt.getBytes());
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Hashing failed", e);
        }
    }
}
