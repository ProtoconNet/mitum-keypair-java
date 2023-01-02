package mitum.keypair.exception;

public class InvalidLengthArgumentException extends RuntimeException {
    public InvalidLengthArgumentException() {
        super();
    }

    public InvalidLengthArgumentException(String msg) {
        super(msg);
    }

    public InvalidLengthArgumentException(String msg, Throwable e) {
        super(msg, e);
    }
}
