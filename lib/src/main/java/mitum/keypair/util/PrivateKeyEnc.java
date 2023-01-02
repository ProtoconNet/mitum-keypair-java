package mitum.keypair.util;

import org.bitcoinj.core.Sha256Hash;

public class PrivateKeyEnc {
    private PrivateKeyEnc() {
    }

    public static byte[] encode(String k) {
        byte[] bp = HexString.from("80" + k + "01").toBytes();
        byte[] hs = Sha256Hash.hashTwice(bp);

        byte[] checksum = new byte[4];
        System.arraycopy(hs, 0, checksum, 0, 4);

        byte[] pk = new byte[bp.length + 4];
        System.arraycopy(bp, 0, pk, 0, bp.length);
        System.arraycopy(checksum, 0, pk, bp.length, 4);

        return pk;
    }
}
