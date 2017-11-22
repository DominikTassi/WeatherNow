package controller;

import com.example.myschema.UserRequest;
import hu.weathernow.app.model.User;
import hu.weathernow.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import hu.weathernow.app.service.WeatherService;
import hu.weathernow.app.exceptions.*;
import com.example.myschema.*;


@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService){ this.userService = userService;}


    @RequestMapping(value = "/getUser/{uid}")
    public ModelAndView getUserById(@PathVariable(value = "id") int id)
            throws NoUserException{
        ModelAndView mav = new ModelAndView("userdata");
        mav.addObject("user",userService.getUser(id));
        return mav;
    }


    @RequestMapping(value = "/getUser/{username}")
    public ModelAndView getUserByName(@PathVariable(value = "username") String username)
            throws NoUserException{
        ModelAndView mav = new ModelAndView("userdata");
        mav.addObject("user",userService.getUser(username));
        return mav;
    }


    @RequestMapping(value = {"/addUser"}, method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addUser(@RequestBody UserRequest userRequest) throws UserDIsOccupiedException {
        User user = null;
        user = new User(userRequest.getUid(), userRequest.getUsername());
        userService.createUser(user);
    }

}
