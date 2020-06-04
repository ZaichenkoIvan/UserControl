package com.myn.usercontrol.controller;

import com.myn.usercontrol.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {
    @GetMapping("/user")
    List<User> showUsers();

    @GetMapping("/user/{id}")
    User showUser(@RequestParam("id") Long id);

    @PostMapping("/user")
    User createUser(@RequestBody User user);

    @PostMapping("/user/edit/{id}")
    User editUser(@RequestBody User user);

    @PostMapping("/user/delete")
    void delete(Long id);
}
