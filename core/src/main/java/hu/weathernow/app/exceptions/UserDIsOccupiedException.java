package hu.weathernow.app.exceptions;

public class UserDIsOccupiedException extends Exception {

    public UserDIsOccupiedException(String s) {
        super("The following ID is occupied: "+s);
    }
}
