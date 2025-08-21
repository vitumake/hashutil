package tel.kontra;

/**
 * Factory for creating HashUtil instances with different configurations.
 */
public class HashUtilFactory {
    /**
     * Create a HashUtil with the given salt and algorithm using the Strategy pattern.
     * @param appSalt Application salt
     * @param algorithm Hash algorithm
     * @return HashUtil instance
     */
    public static HashUtil create(String appSalt, HashAlgorithm algorithm) {
        return new HashUtil(appSalt, new DefaultHashStrategy(algorithm));
    }

    /**
     * Create a HashUtil with the given salt and default algorithm (SHA-256).
     * @param appSalt Application salt
     * @return HashUtil instance
     */
    public static HashUtil create(String appSalt) {
        return new HashUtil(appSalt, new DefaultHashStrategy(HashAlgorithm.SHA_256));
    }

    /**
     * Create a HashUtil with a custom HashStrategy.
     * @param appSalt Application salt
     * @param strategy Custom HashStrategy
     * @return HashUtil instance
     */
    public static HashUtil create(String appSalt, HashStrategy strategy) {
        return new HashUtil(appSalt, strategy);
    }
}
