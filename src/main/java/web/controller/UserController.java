package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView listUsers() {
        List<User> users = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public String addPage() {
        return "add";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") long id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getById(id);
        userService.deleteUser(user);
        return "redirect:/";
    }
}
