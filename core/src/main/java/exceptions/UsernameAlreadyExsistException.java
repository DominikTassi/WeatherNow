package exceptions;

public class UsernameAlreadyExsistException extends Exception {
    public UsernameAlreadyExsistException() {
    }

    public UsernameAlreadyExsistException(String s) {
        super(s);
    }

    public UsernameAlreadyExsistException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UsernameAlreadyExsistException(Throwable throwable) {
        super(throwable);
    }

    public UsernameAlreadyExsistException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
