package mjdk.mexception;

// 用于自定义异常的根异常
public class MBaseException extends RuntimeException {

    public MBaseException() {
        super();
    }

    public MBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public MBaseException(String message) {
        super(message);
    }

    public MBaseException(Throwable cause) {
        super(cause);
    }
}
