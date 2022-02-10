package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public ModelAndView welcomePage (ModelAndView model) {
        model.setViewName("index");
        model.addObject("welcome", "Welcome on board");
        return model;
    }

    @GetMapping(value = "/user/show")
    public ModelAndView showUser (ModelAndView modelAndView) {
        modelAndView.setViewName("user-show");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("current_user", userService.findUserByName(auth.getName()));
        return modelAndView;
    }

    @GetMapping(value = "/admin/listedUsers")
    public ModelAndView listOfUsers (ModelAndView modelAndView) {
        modelAndView.setViewName("user-list");
        modelAndView.addObject("listOfUsers", userService.listOfUsers());
        return modelAndView;
    }

    @GetMapping(value = "/admin/user-create")
    public ModelAndView createUserForm(User user, ModelAndView model) {
        model.setViewName("user-create");
        model.addObject("userForm", user);
        return model;
    }

    @PostMapping(value = "/admin/user-create")
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/listedUsers";
    }


    @GetMapping(value = "/admin/user-edit/{id}")
    public ModelAndView editPage (@PathVariable ("id") Long id, ModelAndView modelAndView) {
        User user = userService.getUserById(id);
        modelAndView.setViewName("user-edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/admin/user-edit/{id}")
    public ModelAndView editFilm(@ModelAttribute User user, @PathVariable("id") Long id, ModelAndView modelAndView) {
        user.setId(id);
        modelAndView.setViewName("redirect:/admin/listedUsers");
        userService.edit(user);
        return modelAndView;
    }

    @GetMapping(value = "/admin/user-delete/{id}")
    public ModelAndView deleteUser(@PathVariable ("id") Long id, ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/admin/listedUsers");
        userService.remove(id);
        return modelAndView;
    }

}
