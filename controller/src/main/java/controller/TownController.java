package controller;

import exceptions.TownNotFoundException;
import model.Town;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.TownService;

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

}
