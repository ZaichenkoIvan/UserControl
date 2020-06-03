package com.myn.usercontrol.service;


import com.myn.usercontrol.dto.User;

import java.util.Optional;

public interface UserService {
    boolean existsById(Long id);

    Optional<User> findById(Long id);

    Iterable<User> findAll();

    User save(User user);

    void deleteById(Long id);

    void delete(User user);
}
