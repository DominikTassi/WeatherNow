package exceptions;

public class UserIDIsOccupiedException extends Exception {

    public UserIDIsOccupiedException(String s) {
        super("The following ID is occupied: "+s);
    }
}
