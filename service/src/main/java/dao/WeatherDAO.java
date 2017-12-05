package dao;

import exceptions.TownNotExistException;
import exceptions.UserNotExistException;
import exceptions.WeatherIDIsOccupiedException;
import model.Weather;

import java.util.Collection;

public interface WeatherDAO {
    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException, TownNotExistException, UserNotExistException;

    public Collection<Weather> getAllWeather();

    public boolean updateWeather(Weather weather) throws WeatherIDIsOccupiedException;

    public boolean deleteWeather(int i) throws WeatherIDIsOccupiedException;
    public boolean deleteWeather(Weather weather) throws WeatherIDIsOccupiedException;
}
