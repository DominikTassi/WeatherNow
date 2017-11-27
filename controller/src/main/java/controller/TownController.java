package controller;

import exceptions.TownNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.TownService;

@Controller
@RequestMapping("/town")
public class TownController {
    TownService townService;

    public TownController(TownService townService) {
        this.townService = townService;
    }

    @RequestMapping(value = "/getTown/{id}")
    public ModelAndView getUser(@PathVariable(value = "id") int id) throws TownNotFoundException {
        ModelAndView mav = new ModelAndView("towndata");
        mav.addObject("town", townService.getTown(id));
        return mav;
    }

}
