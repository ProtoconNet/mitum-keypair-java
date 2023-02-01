package mitum.keypair;

public class PublicKey extends Key {
    static final int MAX_LEN = 48;

    private PublicKey(String s) {
        super(s);

        if (s.length() < MIN_LEN || s.length() > MAX_LEN) {
            throw new IndexOutOfBoundsException("invalid length of public key");
        }
    }

    public static PublicKey from(String s) {
        return new PublicKey(s);
    }
}