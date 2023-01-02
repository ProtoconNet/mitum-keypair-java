package mitum.keypair;

import java.nio.charset.StandardCharsets;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.ECKey;

import mitum.keypair.exception.InvalidLengthArgumentException;
import mitum.keypair.util.HexString;

public class M2KeyPair extends KeyPair {
    private M2KeyPair(PrivateKey priv) {
        super(priv);
    }

    public static M2KeyPair random() {
        ECKey keypair = new ECKey();
        M2PrivateKey privateKey = M2PrivateKey
                .from(Base58.encode(HexString.from(keypair.getPrivateKeyAsHex()).toBytes()) + "mpr");
        return new M2KeyPair(privateKey);
    }

    public static M2KeyPair from(String priv) {
        return new M2KeyPair(M2PrivateKey.from(priv));
    }

    public static M2KeyPair from(PrivateKey priv) {
        return new M2KeyPair(priv);
    }

    public static M2KeyPair fromSeed(byte[] seed) {
        return fromSeed(new String(seed, StandardCharsets.UTF_8));
    }

    public static M2KeyPair fromSeed(String seed) {
        if (seed.length() < MIN_SEED_LEN) {
            throw new InvalidLengthArgumentException("invalid length of seed");
        }

        byte[] pk = HexString.from(hexKeyFromSeed(seed.getBytes(StandardCharsets.UTF_8))).toBytes();
        return new M2KeyPair(M2PrivateKey.from(Base58.encode(pk) + "mpr"));
    }
}
