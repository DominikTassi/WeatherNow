package controller;

import com.example.myschema.UserRequest;
import exceptions.NoUserException;
import exceptions.UserIDIsOccupiedException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUser/{uid}")
    public ModelAndView getUserById(@PathVariable(value = "uid") int id)
            throws NoUserException, UserIDIsOccupiedException {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("user",userService.getUser(id));
        return mav;
    }


    @RequestMapping(value = "/getUser/{username}")
    public ModelAndView getUserByName(@PathVariable(value = "username") String username)
            throws NoUserException, UserIDIsOccupiedException {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("user",userService.getUser(username));
        return mav;
    }


    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Collection<User> getAllUser(){
        return userService.getAllUser();
    }


    @RequestMapping(value = {"/addUser"}, method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addUser(@RequestBody UserRequest userRequest) throws UserIDIsOccupiedException {
        User user = null;
        user = new User(userRequest.getUid(), userRequest.getUsername());
        userService.createUser(user);
    }

}
