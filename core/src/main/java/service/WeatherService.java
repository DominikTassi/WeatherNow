package service;


import exceptions.WeatherIDIsOccupiedException;
import model.Weather;

import java.util.Collection;


public interface WeatherService {
    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException;

    public Collection<Weather> getAllWeather();

    public boolean updateWeather(Weather weather);

    public void deleteWeather(int i);
    public void deleteWeather(Weather weather);
}
