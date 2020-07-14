package users.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import users.model.User;
import users.service.UsersService;

import java.util.List;


@Controller
@RequestMapping(value = "/controller")
public class UsersController {
    UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String allUsers(@ModelAttribute("userServer") User user, Model model) {
        List<User> listUsers = usersService.allUsers();
        model.addAttribute("listUsers", listUsers);
        return "/users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", usersService.getPassAndLog(id));
        return "/user";
    }
    @RequestMapping(value = "/userlogin", method = RequestMethod.GET)
    public String getLogin(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", usersService.getLogin(id));
        return "/user";
    }
    @RequestMapping(value = "/useradd", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute("userServer") User user) {
        usersService.add(user);
        return new RedirectView("/controller/users");
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userServer", new User());
        modelAndView.setViewName("edituser");
        return modelAndView;
    }
    @GetMapping("/delete")
    public RedirectView deleteUser(@RequestParam("id") int id) {
        User user = usersService.getById(id);
        usersService.remove(user);
        return new RedirectView("/controller/users");
    }

}
