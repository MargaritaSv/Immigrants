package immigrants.exceprions;

/**
 * Created by Magi on 14.8.2016 г..
 */
public class ImmigrantsException extends Exception {
    public ImmigrantsException() {
    }

    public ImmigrantsException(String message) {
        super(message);
    }

    public ImmigrantsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImmigrantsException(Throwable cause) {
        super(cause);
    }

    public ImmigrantsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
