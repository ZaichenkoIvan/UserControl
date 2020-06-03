package com.myn.usercontrol.service.impl;

import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.repository.UserRepository;
import com.myn.usercontrol.service.UserService;
import com.myn.usercontrol.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse();
    }

    @Override
    public Iterable<User> findAll() {
//        return userRepository.findAll();
        return null;

    }

    @Override
    public User save(User user) {
//        return userRepository.save(user);
        return null;

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
//        userRepository.delete(user);

    }
}
