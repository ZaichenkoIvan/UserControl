package com.myn.usercontrol.controller;

import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public List<User> showUsers() {
        return userService.findAll();
    }

    @Override
    public User showUser(Long id) {
        return userService.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userService.save(user);
    }

    @Override
    public User editUser(Long id,User user) {
        return userService.edit(id, user);
    }

    @Override
    public void delete(Long id) {
        userService.deleteById(id);
    }
}
