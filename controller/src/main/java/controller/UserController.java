package controller;

import hu.weathernow.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import hu.weathernow.app.service.WeatherService;
import hu.weathernow.app.exceptions.*;

public class UserController {
    UserService userService;

    @RequestMapping(value = "/getUser/{id}")
    public ModelAndView getUserById(@PathVariable(value = "i") int i)
            throws NoUserException{
        ModelAndView mav = new ModelAndView("userdata");
        mav.addObject("user",userService.getUser(i));
        return mav;
    }


    @RequestMapping(value = "/getUser/{id}")
    public ModelAndView getUserByName(@PathVariable(value = "name") String name)
            throws NoUserException{
        ModelAndView mav = new ModelAndView("userdata");
        mav.addObject("user",userService.getUser(name));
        return mav;
    }


}
