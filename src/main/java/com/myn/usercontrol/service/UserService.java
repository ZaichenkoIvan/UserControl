package com.myn.usercontrol.service;


import com.myn.usercontrol.dto.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findById(Long id);

    List<User> findAll();

    User edit(User user);

    void deleteById(Long id);
}
