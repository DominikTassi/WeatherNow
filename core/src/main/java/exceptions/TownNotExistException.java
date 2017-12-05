package exceptions;

public class TownNotExistException extends Exception{
    public TownNotExistException() {
    }

    public TownNotExistException(String s) {
        super(s);
    }

    public TownNotExistException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TownNotExistException(Throwable throwable) {
        super(throwable);
    }

    public TownNotExistException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
