package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.util.*;


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
/*        User guest = new User();
        guest.setUsername("user");
        guest.setPassword("user");
        guest.setRoles(new HashSet<>(List.of(new Role(1L, "ROLE_USER"))));
        userService.save(guest);

        User administrator = new User();
        administrator.setUsername("admin");
        administrator.setPassword("admin");
        administrator.setRoles(new HashSet<>(Arrays.asList(new Role(1L, "ROLE_USER"), new Role(2L, "ROLE_ADMIN"))));
        userService.save(administrator);*/
    }
}
