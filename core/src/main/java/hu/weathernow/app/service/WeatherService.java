package hu.weathernow.app.service;

import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;


public interface WeatherService {
    public Weather createWeather(User user, Collection<Category> categories, Town town, double temperature);

    public Collection<Weather> getByUser(User user);

    public boolean updateWeather(Weather weather);

    public void deleteWeather(int i);
    public void deleteWeather(Weather weather);
}
