import dao.WeatherDAO;
import hu.weathernow.app.exceptions.*;
import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.util.Collection;

public class WeatherServiceImpl implements WeatherDAO {
    private WeatherDAO weatherDAO = null;


    public void createWeather(Weather weather)throws WeatherIDIsOccupiedException {

    }

    public Collection<Weather> getAllWeather(){
        return null;
    }

    public boolean updateWeather(Weather weather){
        return false;
    }

    public boolean deleteWeather(int i){
        return false;
    }

    public boolean deleteWeather(Weather weather){
        return false;
    }
}
