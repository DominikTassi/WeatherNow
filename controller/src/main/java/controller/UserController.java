package controller;

import com.example.myschema.UserRequest;
import exceptions.UserIDIsOccupiedException;
import exceptions.UserNotExistException;
import exceptions.UsernameAlreadyExsistException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") int id) throws UserIDIsOccupiedException {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/getUserByUsername/{username}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUserByUsername(@PathVariable(value = "username") String username) throws UserIDIsOccupiedException {
        return userService.getUser(username);
    }


    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Collection<User> getAllUser(){
        return userService.getAllUser();
    }


    @RequestMapping(value = {"/addUser"}, method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addUser(@RequestBody UserRequest userRequest) throws UserIDIsOccupiedException, UsernameAlreadyExsistException {
        User user = null;
        user = new User(userRequest.getUid(), userRequest.getUsername());
        userService.createUser(user);
    }

    @RequestMapping(value = "/getUserIdByName/{username}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int getUserIdByName(@PathVariable(value = "username") String username) throws UserNotExistException, UserIDIsOccupiedException {
        return userService.getUser(username).getId();
    }


    @RequestMapping(value = "/getNextUserId", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int getMaxId(){
        return userService.getMaxId()+1;
    }

}
