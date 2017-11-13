package dao;

import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;

public interface WeatherDAO {
    public Weather createWeather(Collection<Category> categories, Town town, double temperature);

    public Collection<Weather> getByUser(User user);

    public boolean updateWeather(Weather weather);

    public boolean deleteWeather(int i);
    public boolean deleteWeather(Weather weather);
}
