package com.myn.usercontrol.controller;

import com.myn.usercontrol.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {
    @GetMapping("/")
    List<User> showUsers();

    @GetMapping("/{id}")
    User showUser(@PathVariable("id") Long id);

    @PostMapping("/")
    User createUser(@RequestBody User user);

    @PostMapping("/edit/{id}")
    User editUser(@PathVariable("id") Long id, @RequestBody User user);

    @PostMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id);
}
