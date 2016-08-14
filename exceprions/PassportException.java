package immigrants.exceprions;

/**
 * Created by Magi on 14.8.2016 г..
 */
public class PassportException extends Exception {

    public PassportException() {
    }

    public PassportException(String message) {
        super(message);
    }

    public PassportException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassportException(Throwable cause) {
        super(cause);
    }

    public PassportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
