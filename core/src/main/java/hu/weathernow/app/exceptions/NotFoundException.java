package hu.weathernow.app.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException() {
    }

    public NotFoundException(String s) {
        super(s);
    }
}
