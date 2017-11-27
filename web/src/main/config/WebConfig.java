package config;

import json.UserDAOJSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import controller.UserController;
import dao.UserDAO;
import service.UserService;

@Configuration
public class WebConfig {

    @Bean
    public UserController userController(){
        return new UserController(userService());
    }

    UserService userService() {
        return (UserService) new UserServiceImpl(userDAO());
    }

    UserDAO userDAO(){
        return new UserDAOJSON("users.json");
    }

}

