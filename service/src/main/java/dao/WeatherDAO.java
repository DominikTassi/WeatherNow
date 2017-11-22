package dao;

import hu.weathernow.app.exceptions.*;
import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;

public interface WeatherDAO {
    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException;

    public Collection<Weather> getAllWeather();

    public boolean updateWeather(Weather weather);

    public boolean deleteWeather(int i);
    public boolean deleteWeather(Weather weather);
}
