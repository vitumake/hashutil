package tel.kontra;

/**
 * Utility class for hashing strings including a password encoder.
 * 
 * Written originally for Expense Tracker schoolproject application
 * in 2024, then modified for further use.
 * 
 * @see HashAlgorithm
 * 
 * @version 2.0
 * @author Markus Vallin - Metropolia UAE
 */
public class HashUtil {
    private final String appSalt;
    private final HashStrategy hashStrategy;

    /**
     * Constructor with custom HashStrategy
     * @param appSalt Application salt
     * @param hashStrategy Hashing strategy
     */
    public HashUtil(String appSalt, HashStrategy hashStrategy) {
        this.appSalt = appSalt;
        this.hashStrategy = hashStrategy;
    }

    /**
     * Hash a string using the configured strategy.
     * @param stringToHash The string to hash
     * @return The hashed string
     */
    public String hash(String stringToHash) {
        return hashStrategy.hash(stringToHash, appSalt);
    }

    /**
     * Hash a string and truncate the result to a specified length.
     * @param stringToHash The string to hash
     * @param truncationLength The length to truncate the hash to
     * @return The hashed string truncated to the specified length
     */
    public String hash(String stringToHash, int truncationLength) {
        String hash = hash(stringToHash);
        if (hash.length() > truncationLength) {
            return hash.substring(0, truncationLength);
        }
        return hash;
    }

    /**
     * Verify hash
     * @param stringToVerify The string to verify
     * @param hash The expected hash
     * @return true if the hash matches, false otherwise
     */
    public boolean verifyHash(String stringToVerify, String hash) {
        return hash(stringToVerify).equals(hash);
    }

    /**
     * Get application salt
     * @return salt
     */
    public String getAppSalt() {
        return appSalt;
    }

    /**
     * Encode a password (for compatibility with password encoders)
     * @param rawCharSeq The raw password
     * @return The hashed password
     */
    public String encode(CharSequence rawCharSeq) {
        return hash(rawCharSeq.toString());
    }

    /**
     * Verify password
     * @param rawCharSeq The raw password
     * @param encodedCharSeq The encoded password
     * @return true if matches, false otherwise
     */
    public boolean matches(CharSequence rawCharSeq, String encodedCharSeq) {
        return verifyHash(rawCharSeq.toString(), encodedCharSeq);
    }
}