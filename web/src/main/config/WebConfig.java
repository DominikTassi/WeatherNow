package config;

import controller.WeatherController;
import hu.app.service.impl.UserServiceImpl;
import hu.app.service.impl.WeatherServiceImpl;
import json.UserDAOJSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import controller.UserController;
import dao.UserDAO;
import service.UserService;
import service.WeatherService;

@Configuration
public class WebConfig {

    @Bean
    public UserController userController(){
        return new UserController(userService());
    }

    UserService userService() {
        return new UserServiceImpl(userDAO());
    }

    UserDAO userDAO(){
        return new UserDAOJSON("users.json");
    }

}

