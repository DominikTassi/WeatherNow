package config;

import controller.TownController;
import controller.WeatherController;
import dao.TownDAO;
import dao.WeatherDAO;
import hu.app.service.impl.TownServiceImpl;
import hu.app.service.impl.UserServiceImpl;
import hu.app.service.impl.WeatherServiceImpl;
import json.TownDAOJSON;
import json.UserDAOJSON;
import json.WeatherDAOJSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import controller.UserController;
import dao.UserDAO;
import service.TownService;
import service.UserService;
import service.WeatherService;

@Configuration
public class WebConfig {

    public UserDAO userDAO(){
        return new UserDAOJSON("users.json");
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userDAO());
    }

    public UserController userController(){
        return new UserController(userService());
    }

    public WeatherDAO weatherDAO(){
        return new WeatherDAOJSON("weather.json");
    }

    @Bean
    public WeatherService weatherService(){
        return new WeatherServiceImpl(weatherDAO());
    }

    public WeatherController weatherController(){
        return new WeatherController(weatherService());
    }

    public TownDAO townDAO(){
        return new TownDAOJSON("town.json");
    }

    @Bean
    public TownService townService(){
        return new TownServiceImpl(townDAO());
    }

    public TownController townController(){
        return new TownController(townService());
    }

}

