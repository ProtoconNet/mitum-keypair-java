package mitum.keypair;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.params.MainNetParams;

import mitum.keypair.exception.InvalidLengthArgumentException;
import mitum.keypair.util.HexString;
import mitum.keypair.util.PrivateKeyEnc;

public class M2PrivateKey extends PrivateKey {
    static final int MAX_LEN = 48;
    private ECKey kp;

    private M2PrivateKey(String s) {
        super(s);

        if (s.length() < MIN_LEN || s.length() > MAX_LEN) {
            throw new InvalidLengthArgumentException("invalid length of m2 - private key");
        }

        byte[] pk = PrivateKeyEnc.encode(HexString.fromBytes(Base58.decode(this.getKey())).toString());
        this.kp = DumpedPrivateKey.fromBase58(MainNetParams.get(), Base58.encode(pk)).getKey();

        this.publicKey = PublicKey.from(Base58.encode(HexString.from(this.kp.getPublicKeyAsHex()).toBytes()) + "mpu");
    }

    public static M2PrivateKey from(String s) {
        return new M2PrivateKey(s);
    }

    @Override
    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override
    public byte[] sign(byte[] msg) {
        return this.kp.sign(Sha256Hash.twiceOf(msg)).encodeToDER();
    }
}
