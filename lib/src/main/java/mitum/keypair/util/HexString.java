package mitum.keypair.util;

public class HexString {
    private byte[] b;

    private HexString(byte[] b) {
        this.b = b;
    }

    public static HexString fromBytes(byte[] b) {
        return new HexString(b);
    }

    public static HexString from(String s) {
        int len = s.length();
        byte[] v = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            v[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return new HexString(v);
    }

    public byte[] toBytes() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte v : this.b) {
            stringBuilder.append(String.format("%02X", v & 0xff));
        }
        return stringBuilder.toString();
    }
}
