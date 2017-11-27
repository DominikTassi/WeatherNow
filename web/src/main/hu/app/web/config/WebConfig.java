package hu.app.web.config;

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
    @Bean(value = "userDAO")
    public UserDAO initUserDAO(){
        return new UserDAOJSON("/home/dominik/IntelliJProjects/WeatherNow/users.json");
    }

    @Bean(value = "userService")
    public UserService initUserService() {
        return new UserServiceImpl(initUserDAO());
    }

    @Bean(value = "userController")
    public UserController initUserController(){
        return new UserController(initUserService());
    }


    @Bean(value = "weatherDAO")
    public WeatherDAO initWeatherDAO(){
        return new WeatherDAOJSON("/home/dominik/IntelliJProjects/WeatherNow/weathers.json");
    }

    @Bean(value = "weatherService")
    public WeatherService initWeatherService(){
        return new WeatherServiceImpl(initWeatherDAO());
    }

    @Bean(value = "weatherController")
    public WeatherController initWeatherController(){
        return new WeatherController(initWeatherService());
    }



    @Bean(value = "townDAO")
    public TownDAO initTownDAO(){
        return new TownDAOJSON("/home/dominik/IntelliJProjects/WeatherNow/towns.json");
    }

    @Bean(value = "townService")
    public TownService initTownService(){
        return new TownServiceImpl(initTownDAO());
    }

    @Bean(value = "townController")
    public TownController initTownController(){
        return new TownController(initTownService());
    }
}