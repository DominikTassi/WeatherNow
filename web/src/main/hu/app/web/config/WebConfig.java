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
        return new UserDAOJSON("asd.json");
    }

    @Bean(value = "userService")
    public UserService initUserService() {
        return new UserServiceImpl(initUserDAO());
    }

    @Bean(value = "userController")
    public UserController initUserController(){
        return new UserController(initUserService());
    }
}