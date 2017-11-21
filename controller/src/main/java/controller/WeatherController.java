package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import hu.weathernow.app.service.WeatherService;


@Controller
@RequestMapping("/weather")
public class WeatherController {


    @Autowired
    WeatherService weatherService;

    public WeatherController(WeatherService weatherService){ this.weatherService=weatherService;}
    
    @RequestMapping(value = "/getWeather", method={RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
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
