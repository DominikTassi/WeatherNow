import dao.WeatherDAO;
import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;

public class WeatherServiceImpl implements WeatherDAO {
    private WeatherDAO weatherDAO = null;
    public WeatherServiceImpl(WeatherDAO weatherDAO){ this.weatherDAO = weatherDAO; }

    public Weather createWeather(Collection<Category> categories, Town town, double temperature) {
        return weatherDAO.createWeather(categories, town, temperature);
    }

    public Collection<Weather> getByUser(User user) {
        return weatherDAO.getByUser(user);
    }

    public boolean updateWeather(Weather weather) {
        return weatherDAO.updateWeather(weather);
    }

    public boolean deleteWeather(int i) {
        return weatherDAO.deleteWeather(i);
    }

    public boolean deleteWeather(Weather weather) {
        return weatherDAO.deleteWeather(weather);
    }
}
