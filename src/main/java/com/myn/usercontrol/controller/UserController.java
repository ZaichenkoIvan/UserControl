package com.myn.usercontrol.controller;

import com.myn.usercontrol.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {
    @GetMapping("/user")
    List<User> showUsers();

    @GetMapping("/user/{id}")
    User showUser(@PathVariable("id") Long id);

    @PostMapping("/user")
    User createUser(@RequestBody User user);

    @PostMapping("/user/edit/{id}")
    User editUser(@PathVariable("id") Long id, @RequestBody User user);

    @PostMapping("/user/delete/{id}")
    void delete(@PathVariable("id") Long id);
}
