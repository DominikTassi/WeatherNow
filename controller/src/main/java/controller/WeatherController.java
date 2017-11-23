package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.WeatherService;


@Controller
@RequestMapping("/weather")
public class WeatherController {


    @Autowired
    WeatherService weatherService;

    public WeatherController(WeatherService weatherService){ this.weatherService=weatherService;}

    @RequestMapping(value = "/getWeather")
    public ModelAndView getWeather(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("weathears", weatherService.getAllWeather());
        System.out.println(weatherService.getAllWeather());
        return mav;
    }

    @RequestMapping(value = "/createWeather")
    public ModelAndView createWeather(){
        ModelAndView mav = new ModelAndView();
        return mav;
    }
}
