package exception;

public class nOTicketFound extends RuntimeException{
    public nOTicketFound() {
    }

    public nOTicketFound(String message) {
        super(message);
    }

    public nOTicketFound(String message, Throwable cause) {
        super(message, cause);
    }

    public nOTicketFound(Throwable cause) {
        super(cause);
    }

    public nOTicketFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
