package exception;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials() {
    }

    public InvalidCredentials(String message) {
        super(message);
    }

    public InvalidCredentials(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCredentials(Throwable cause) {
        super(cause);
    }

    public InvalidCredentials(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
