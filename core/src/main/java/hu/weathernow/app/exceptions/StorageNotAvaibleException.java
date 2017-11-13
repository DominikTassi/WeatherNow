package hu.weathernow.app.exceptions;

public class StorageNotAvaibleException extends Exception {
    public StorageNotAvaibleException() {
    }

    public StorageNotAvaibleException(String message) {
        super(message);
    }
}
