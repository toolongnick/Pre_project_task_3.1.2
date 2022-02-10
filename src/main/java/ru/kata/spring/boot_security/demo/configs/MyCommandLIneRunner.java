package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


@Component
public class MyCommandLIneRunner implements CommandLineRunner {

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Override
    @Transactional
    public void run(String... args) {
/*        User user = new User();
        user.setName("user");
        user.setPassword("user");
        user.setEmail("user@mail.com");
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userService.save(user);

        User administrator = new User();
        administrator.setName("admin");
        administrator.setPassword("admin");
        administrator.setEmail("admin@mail.com");
        administrator.setRoles(new HashSet<>(Arrays.asList(new Role(1L, "ROLE_USER"), new Role(2L, "ROLE_ADMIN"))));
        userService.save(administrator);*/
    }
}
