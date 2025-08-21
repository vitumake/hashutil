package tel.kontra;

/**
 * Strategy interface for hashing algorithms.
 */
public interface HashStrategy {
    /**
     * Hash the input string with the given salt.
     * @param input The string to hash
     * @param salt The salt to use
     * @return The hashed string
     */
    String hash(String input, String salt);
}
