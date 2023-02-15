package mitum.keypair;

import java.nio.charset.StandardCharsets;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.ECKey;

import mitum.keypair.util.PrivateKeyEnc;

public class M1KeyPair extends KeyPair {
    private M1KeyPair(PrivateKey priv) {
        super(priv);
    }

    public static M1KeyPair random() {
        ECKey keypair = new ECKey();
        byte[] pk = PrivateKeyEnc.encode(keypair.getPrivateKeyAsHex());

        return new M1KeyPair(M1PrivateKey.from(Base58.encode(pk) + "mpr"));
    }

    public static M1KeyPair from(String priv) {
        return new M1KeyPair(M1PrivateKey.from(priv));
    }

    public static M1KeyPair from(PrivateKey priv) {
        return new M1KeyPair(priv);
    }

    public static M1KeyPair fromSeed(byte[] seed) {
        byte[] pk = PrivateKeyEnc.encode(hexKeyFromSeed(seed));
        return new M1KeyPair(M1PrivateKey.from(Base58.encode(pk) + "mpr"));
    }

    public static M1KeyPair fromSeed(String seed) {
        if (seed.length() < MIN_SEED_LEN) {
            throw new IndexOutOfBoundsException("invalid length of seed");
        }

        return fromSeed(seed.getBytes(StandardCharsets.UTF_8));
    }
}
