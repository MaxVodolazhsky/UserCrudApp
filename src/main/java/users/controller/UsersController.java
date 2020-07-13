package users.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import users.model.User;
import users.service.UsersService;


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
        model.addAttribute("user", usersService.getPassAndLog(id));
        return "/user";
    }
    @RequestMapping(value = "/userlogin", method = RequestMethod.GET)
    public String getLogin(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", usersService.getLogin(id));
        return "/user";
    }
    @RequestMapping(value = "/useradd", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userServer") User user) {
        usersService.add(user);
        return "edituser";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userServer", new User());
        modelAndView.setViewName("adduser");
        return modelAndView;
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        User user = usersService.getById(id);
        usersService.remove(user);
        return "edituser";
    }

}
