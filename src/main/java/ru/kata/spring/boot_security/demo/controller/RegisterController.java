package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public ModelAndView welcomePage (ModelAndView model) {
        model.setViewName("index");
        model.addObject("welcome", "Привет");
        return model;
    }

/*    @GetMapping("/user-create")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String addUser(@ModelAttribute("userForm") User userForm*//*, Model model*//*) {
*//*        if (!userService.save(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
        }*//*
        System.out.println("asdf");
        userService.save(userForm);
        return "user-create";
    }*/
}
