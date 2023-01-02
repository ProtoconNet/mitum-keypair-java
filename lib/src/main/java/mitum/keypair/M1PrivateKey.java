package mitum.keypair;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.params.MainNetParams;

import mitum.keypair.exception.InvalidLengthArgumentException;
import mitum.keypair.util.HexString;

public class M1PrivateKey extends PrivateKey {
    static final int MAX_LEN = 55;
    private ECKey kp;

    private M1PrivateKey(String s) {
        super(s);
        if (s.length() != MAX_LEN) {
            throw new InvalidLengthArgumentException("invalid length of m1 - private key");
        }

        this.kp = DumpedPrivateKey.fromBase58(MainNetParams.get(), this.getKey()).getKey();
        this.publicKey = PublicKey.from(Base58.encode(HexString.from(this.kp.getPublicKeyAsHex()).toBytes()) + "mpu");
    }

    public static M1PrivateKey from(String s) {
        return new M1PrivateKey(s);
    }

    @Override
    public byte[] sign(byte[] msg) {
        return this.kp.sign(Sha256Hash.twiceOf(msg)).encodeToDER();
    }
}
