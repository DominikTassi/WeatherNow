package dao;

import exceptions.TownNotExistException;
import exceptions.UserNotExistException;
import exceptions.WeatherIDIsOccupiedException;
import model.Weather;

import java.util.Collection;
import java.util.List;

public interface WeatherDAO {
    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException, TownNotExistException, UserNotExistException;

    public List<Weather> getAllWeather();

    public boolean updateWeather(Weather weather) throws WeatherIDIsOccupiedException;

    public boolean deleteWeather(int i) throws WeatherIDIsOccupiedException;
    public boolean deleteWeather(Weather weather) throws WeatherIDIsOccupiedException;

    public int getMaxWeatherId();
}
