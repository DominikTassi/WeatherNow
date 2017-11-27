package controller;

import com.example.myschema.WeatherRequest;
import exceptions.EmptyCategoryException;
import exceptions.NoCategoryException;
import exceptions.NoTownException;
import exceptions.NoUserException;
import model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.WeatherService;


@Controller
@RequestMapping("/weather")
public class WeatherController {


    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/getWeather")
    public ModelAndView getWeather(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("weathears", weatherService.getAllWeather());
        System.out.println(weatherService.getAllWeather());
        return mav;
    }

    @RequestMapping(value = {"/createWeather"}, method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addWeather(@RequestBody WeatherRequest weatherRequest) throws NoUserException, EmptyCategoryException, NoCategoryException, NoTownException {
        Weather weather = null;
        weather = new Weather(weather.getId(), weather.getUser(), weather.getTown(), weather.getCategory(), weather.getTemperature());
        weatherService.createWeather(weather);
    }
}
