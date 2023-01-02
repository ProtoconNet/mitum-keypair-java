package mitum.keypair;

public abstract class PrivateKey extends Key {
    protected PublicKey publicKey;

    protected PrivateKey(String s) {
        super(s);
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public abstract byte[] sign(byte[] msg);
}