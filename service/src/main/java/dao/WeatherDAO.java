package dao;

import hu.weathernow.app.exceptions.AlreadyExistingException;
import hu.weathernow.app.exceptions.NotFoundException;
import hu.weathernow.app.exceptions.StorageException;
import hu.weathernow.app.exceptions.StorageNotAvaibleException;
import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;

public interface WeatherDAO {
    public Weather createWeather(User user, Collection<Category> categories, Town town, double temperature) throws StorageNotAvaibleException, NotFoundException, StorageException, AlreadyExistingException;

    public Collection<Weather> getByUser(User user);

    public boolean updateWeather(Weather weather) throws StorageNotAvaibleException, AlreadyExistingException, StorageException;

    public boolean deleteWeather(int i) throws StorageNotAvaibleException, StorageException;
    public boolean deleteWeather(Weather weather) throws StorageNotAvaibleException, StorageException;
}
