package hu.weathernow.app.exceptions;

public class AlreadyExistingException extends Exception {
    public AlreadyExistingException() {
    }

    public AlreadyExistingException(String s) {
        super(s);
    }
}
