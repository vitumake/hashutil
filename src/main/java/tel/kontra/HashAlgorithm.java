package tel.kontra;

/**
 * Enum for hash algorithms
 * 
 * @version 1.0
 */
public enum HashAlgorithm {
    

    /** SHA-1 algorithm (not recommended for security) */
    SHA_1("SHA-1"),
    /** SHA-224 algorithm */
    SHA_224("SHA-224"),
    /** SHA-256 algorithm (recommended default) */
    SHA_256("SHA-256"),
    /** SHA-384 algorithm */
    SHA_384("SHA-384"),
    /** SHA-512 algorithm */
    SHA_512("SHA-512"),
    /** SHA-512/224 algorithm */
    SHA_512_224("SHA-512/224"),
    /** SHA-512/256 algorithm */
    SHA_512_256("SHA-512/256"),

    /** SHA3-224 algorithm */
    SHA3_224("SHA3-224"),
    /** SHA3-256 algorithm */
    SHA3_256("SHA3-256"),
    /** SHA3-384 algorithm */
    SHA3_384("SHA3-384"),
    /** SHA3-512 algorithm */
    SHA3_512("SHA3-512"),

    /** MD2 algorithm (not secure, legacy only) */
    MD2("MD2"),
    /** MD5 algorithm (not secure, legacy only) */
    MD5("MD5");

    // Stupid SHA_ breaks the hashing function

    private final String algorithm;

    /**
     * Constructor
     * 
     * @param algorithm hash algorithm
     */
    private HashAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
    
    /**
     * Get algorithm
     * 
     * @return String
     */
    public String getAlgorithm() {
        return algorithm;
    }
}
