package exceptions;

public class UserNotExistException extends Exception {

    public UserNotExistException() {
    }

    public UserNotExistException(String s) {
        super(s);
    }

    public UserNotExistException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserNotExistException(Throwable throwable) {
        super(throwable);
    }

    public UserNotExistException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
