package dao;

import hu.weathernow.app.exceptions.*;
import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;

public interface WeatherDAO {
    public void createWeather(Weather weather) throws StorageNotAvaibleException, NotFoundException, StorageException, AlreadyExistingException, WeatherIDIsOccupiedException;

    public Collection<Weather> getAllWeather() throws StorageNotAvaibleException, StorageException;

    public boolean updateWeather(Weather weather) throws StorageNotAvaibleException, AlreadyExistingException, StorageException;

    public boolean deleteWeather(int i) throws StorageNotAvaibleException, StorageException;
    public boolean deleteWeather(Weather weather) throws StorageNotAvaibleException, StorageException;
}
