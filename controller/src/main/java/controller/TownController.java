package controller;

import exceptions.TownNotFoundException;
import model.Town;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.TownService;

import java.util.Collection;

@Controller
public class TownController {
    TownService townService;

    public TownController(TownService townService) {
        this.townService = townService;
    }

    @RequestMapping(value = "/getTown/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Town getTownById(@PathVariable(value = "id") int id )throws TownNotFoundException {
        return townService.getTown(id);
    }

    @RequestMapping(value = "/getTownIdByName/{name}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int getTownIdByName(@PathVariable(value = "name") String name )throws TownNotFoundException {
        return townService.getTown(name).getId();
    }

    @RequestMapping(value = "/getAllTown", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Collection<Town> getAllTown()throws TownNotFoundException {
        return townService.getAllTown();
    }
}
