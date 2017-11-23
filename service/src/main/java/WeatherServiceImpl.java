import dao.WeatherDAO;
import exceptions.WeatherIDIsOccupiedException;
import model.Weather;


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
