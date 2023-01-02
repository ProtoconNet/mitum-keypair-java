package mitum.keypair.exception;

public class UnhashableException extends RuntimeException {
    public UnhashableException() {
        super();
    }

    public UnhashableException(String msg) {
        super(msg);
    }

    public UnhashableException(String msg, Throwable e) {
        super(msg, e);
    }
}
