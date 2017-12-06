package hu.app.service.impl;

import dao.WeatherDAO;
import exceptions.TownNotExistException;
import exceptions.UserNotExistException;
import exceptions.WeatherIDIsOccupiedException;
import model.Category;
import model.Weather;
import service.WeatherService;


import java.util.Collection;

public class WeatherServiceImpl implements WeatherService {
    private WeatherDAO weatherDAO = null;

    public WeatherServiceImpl(WeatherDAO weatherDAO) {
        this.weatherDAO = weatherDAO;
    }

    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException, UserNotExistException, TownNotExistException {
        weatherDAO.createWeather(weather);
    }

    public Collection<Weather> getAllWeather() {
      return  weatherDAO.getAllWeather();
    }

    public boolean updateWeather(Weather weather) throws WeatherIDIsOccupiedException {
        return weatherDAO.updateWeather(weather);
    }

    public void deleteWeather(int i) throws WeatherIDIsOccupiedException {
        weatherDAO.deleteWeather(i);
    }

    public void deleteWeather(Weather weather) throws WeatherIDIsOccupiedException {
        weatherDAO.deleteWeather(weather);
    }

    @Override
    public int getMaxWeatherId() {
        return weatherDAO.getMaxWeatherId()+1;
    }
}
