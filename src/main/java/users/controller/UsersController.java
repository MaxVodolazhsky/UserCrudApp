package users.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import users.service.UsersService;
import users.service.UsersServiceImpl;


@Controller
@RequestMapping(value = "/controller")
public class UsersController {
    UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", usersService.getPassAndName(id));
        return "/user";
    }


}
