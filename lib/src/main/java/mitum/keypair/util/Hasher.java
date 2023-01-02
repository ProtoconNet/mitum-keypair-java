package mitum.keypair.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import mitum.keypair.exception.UnhashableException;

public class Hasher {
    private Hasher() {
    }

    public static byte[] sha256(byte[] msg) throws UnhashableException {
        try {
            MessageDigest hasher = MessageDigest.getInstance("SHA-256");
            return hasher.digest(msg);
        } catch (NoSuchAlgorithmException e) {
            throw new UnhashableException("cannot get hash value; sha-256", e);
        }
    }

    public static byte[] sha256(String msg) throws UnhashableException {
        return Hasher.sha256(msg.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] sha3(byte[] msg) throws UnhashableException {
        try {
            MessageDigest hasher = MessageDigest.getInstance("SHA3-256");
            return hasher.digest(msg);
        } catch (NoSuchAlgorithmException e) {
            throw new UnhashableException("cannot get hash value; sha3-256", e);
        }
    }

    public static byte[] sha3(String msg) throws UnhashableException {
        return Hasher.sha3(msg.getBytes(StandardCharsets.UTF_8));
    }
}
