package mysql;

import dao.WeatherDAO;
import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;

public class WeatherDAOmysql implements WeatherDAO {
    @Override
    public Weather createWeather(Collection<Category> categories, Town town, double temperature) {
        return null;
    }

    @Override
    public Collection<Weather> getByUser(User user) {
        return null;
    }

    @Override
    public boolean updateWeather(Weather weather) {
        return false;
    }

    @Override
    public boolean deleteWeather(int i) {
        return false;
    }

    @Override
    public boolean deleteWeather(Weather weather) {
        return false;
    }
}
