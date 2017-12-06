package controller;

import com.example.myschema.WeatherRequest;
import exceptions.*;
import model.Category;
import model.Town;
import model.User;
import model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.WeatherService;

import java.time.LocalDateTime;
import java.util.Collection;


@Controller
public class WeatherController {


    @Autowired
    WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/getAllWeather", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Collection<Weather> getAllWeather(){
        return weatherService.getAllWeather();
    }

    @RequestMapping(value = {"/addWeather"}, method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addWeather(@RequestBody WeatherRequest weatherRequest) throws NoUserException, EmptyCategoryException, NoCategoryException, NoTownException, WeatherIDIsOccupiedException, UserNotExistException, TownNotExistException {
        Weather weather = null;
        weather = new Weather(weatherRequest.getWid(), new User(weatherRequest.getUid(), weatherRequest.getUsername()),
                new Town(weatherRequest.getTid(), weatherRequest.getTown()), Enum.valueOf(Category.class, weatherRequest.getCategory()), weatherRequest.getTemperature());
        weatherService.createWeather(weather);
    }

    @RequestMapping(value = "/getNextWeatherId", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int getMaxWeatherId(){
        return weatherService.getMaxWeatherId()+1;
    }
}