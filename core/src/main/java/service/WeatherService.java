package service;


import exceptions.TownNotExistException;
import exceptions.UserNotExistException;
import exceptions.WeatherIDIsOccupiedException;
import model.Weather;

import java.util.Collection;


public interface WeatherService {
    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException, UserNotExistException, TownNotExistException;

    public Collection<Weather> getAllWeather();

    public boolean updateWeather(Weather weather) throws WeatherIDIsOccupiedException;

    public void deleteWeather(int i) throws WeatherIDIsOccupiedException;
    public void deleteWeather(Weather weather) throws WeatherIDIsOccupiedException;

    public int getMaxWeatherId();
}
