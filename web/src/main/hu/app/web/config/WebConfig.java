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
    public UserDAO userDAO(){
        return new UserDAOJSON("users.json");
    }

    @Bean(value = "userService")
    public UserService userService() {
        return new UserServiceImpl(userDAO());
    }
  //  @Bean(value = "userController")
 //   public UserController userController(){
  //      return new UserController(userService());
   // }
    @Bean(value = "weatherDAO")
    public WeatherDAO weatherDAO(){
        return new WeatherDAOJSON("weather.json");
    }

    @Bean(value = "weatherService")
    public WeatherService weatherService(){
        return new WeatherServiceImpl(weatherDAO());
    }
    //@Bean(value = "weatherController")
   // public WeatherController weatherController(){
    //    return new WeatherController(weatherService());
   // }
    @Bean(value = "townDAO")
    public TownDAO townDAO(){
        return new TownDAOJSON("town.json");
    }

    @Bean(value = "townsService")
    public TownService townService(){
        return new TownServiceImpl(townDAO());
    }
//    @Bean(value = "townController")
//    public TownController townController(){
//        return new TownController(townService());
 //   }

}

