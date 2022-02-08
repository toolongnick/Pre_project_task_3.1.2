/*
package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    @Value("Welcome")
    private String welcome;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public ModelAndView welcomePage (ModelAndView model) {
        model.setViewName("welcome_page");
        model.addObject("welcome", welcome);
        return model;
    }

    @GetMapping(value = "/users")
    public ModelAndView listOfUsers(ModelAndView model) {
        List<User> list = userService.listOfUsers();
        model.setViewName("user-list");
        model.addObject("ListOfUsers", list);
        return model;
    }

*/
/*    @GetMapping(value = "/user-create")
    public ModelAndView createUserForm(User user, ModelAndView model) {
        model.setViewName("user-create");
        model.addObject("user", user);
        return model;
    }

    @PostMapping(value = "/user-create")
    public String createUser(@ModelAttribute User user) {
        userService.save (user);
        return "redirect:/users";
    }*//*


    @GetMapping(value = "/user-edit/{id}")
    public ModelAndView editPage (@PathVariable ("id") Integer id, ModelAndView modelAndView) {
        User user = userService.getUserById(id);
        modelAndView.setViewName("user-edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/user-edit/{id}")
    public ModelAndView editFilm(@ModelAttribute User user, @PathVariable("id") Integer id, ModelAndView modelAndView) {
        user.setId(id);
        modelAndView.setViewName("redirect:/users");
        userService.edit(user);
        return modelAndView;
    }

    @GetMapping(value = "/user-delete/{id}")
    public ModelAndView deleteUser(@PathVariable ("id") Integer id, ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/users");
        userService.remove(id);
        return modelAndView;
    }

}*/
