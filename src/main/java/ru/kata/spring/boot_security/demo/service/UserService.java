package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.expression.Sets;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService  {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService (UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional(readOnly = true)
    public User findUserByName (String username) {
        return userRepository.findUsersByName(username);
    }

    @Transactional
    public void save(User user) {
/*        User userFromDB = userRepository.findById(user.getId()).orElse(new User());
        if (userFromDB != null){
            return false;
        }
        User user1 = new User();
        user1.setUserName("safdsf");
        user1.setPassword(bCryptPasswordEncoder.encode("asdfasdfasdf"));
        user1.setActive(true);*/
//        user1.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    public void edit(User user) {
        User storedUser = userRepository.findById(user.getId()).orElseThrow();
        storedUser.setName(user.getName());
        storedUser.setSurname(user.getSurname());
        userRepository.save(storedUser);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<User> listOfUsers() {
        return userRepository.findAll() ;
    }
}
