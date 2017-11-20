package hu.weathernow.app.exceptions;

public class WeatherIDIsOccupiedException extends Exception {

    public WeatherIDIsOccupiedException(String s) {
        super("The following ID is occupied: "+s);
    }
}
