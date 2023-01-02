package mitum.keypair;

import java.nio.charset.StandardCharsets;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.ECKey;

import mitum.keypair.exception.InvalidLengthArgumentException;
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
        return fromSeed(new String(seed, StandardCharsets.UTF_8));
    }

    public static M1KeyPair fromSeed(String seed) {
        if (seed.length() < MIN_SEED_LEN) {
            throw new InvalidLengthArgumentException("invalid length of seed");
        }

        byte[] pk = PrivateKeyEnc.encode(hexKeyFromSeed(seed.getBytes(StandardCharsets.UTF_8)));
        return new M1KeyPair(M1PrivateKey.from(Base58.encode(pk) + "mpr"));
    }
}
