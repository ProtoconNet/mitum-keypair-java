package mitum.keypair;

import java.math.BigInteger;
import java.util.Arrays;

import org.bitcoinj.core.Base58;

import mitum.keypair.exception.UnhashableException;
import mitum.keypair.util.Hasher;
import mitum.keypair.util.HexString;

class KeyPair {
    static final BigInteger CURVE = new BigInteger(
            "115792089237316195423570985008687907852837564279074904382605163141518161494336");
    static final int MIN_SEED_LEN = 36;
    private PrivateKey privateKey;

    protected KeyPair(PrivateKey priv) {
        this.privateKey = priv;
    }

    protected static String hexKeyFromSeed(byte[] seed) {
        byte[] sh;
        try {
            sh = Hasher.sha3(seed);
        } catch (UnhashableException e) {
            throw new UnhashableException("cannot hash the msg", e);
        }

        byte[] shb = Base58.encode(sh).getBytes();

        if (shb.length < 44) {
            shb = Arrays.copyOfRange(shb, 0, shb.length - 3);
        } else {
            shb = Arrays.copyOfRange(shb, 0, shb.length - 4);
        }

        BigInteger k = new BigInteger(shb);
        k = k.mod(CURVE);
        k = k.add(BigInteger.valueOf(1));

        return HexString.fromBytes(k.toByteArray()).toString();
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.privateKey.getPublicKey();
    }

    public byte[] sign(byte[] msg) {
        return this.privateKey.sign(msg);
    }

    public byte[] sign(String msg) {
        return this.sign(msg.getBytes());
    }
}
