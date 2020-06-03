package com.myn.usercontrol.service;


import com.myn.usercontrol.dto.User;

import java.util.List;

public interface UserService {
    boolean existsById(Long id);

    User findById(Long id);

    List<User> findAll();

    User save(User user);

    void deleteById(Long id);
}
