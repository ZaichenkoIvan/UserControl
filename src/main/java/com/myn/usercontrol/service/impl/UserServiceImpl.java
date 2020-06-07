package com.myn.usercontrol.service.impl;

import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.exception.UserIdNegativeRuntimeException;
import com.myn.usercontrol.exception.UserNotExistRuntimeException;
import com.myn.usercontrol.repository.UserRepository;
import com.myn.usercontrol.service.UserService;
import com.myn.usercontrol.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final String USER_BY_THIS_ID_NOT_EXIST = "User by this id not exist";
    private static final String ID_MUST_BE_POSITIVE = "Id must be positive";
    private static final int THE_SMALLEST_POSSIBLE_ID = 0;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = userMapper.userToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return userMapper.userEntityToUser(userEntity);
    }

    @Override
    public User findById(Long id) {
        checkCorrectIdUser(id);

        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotExistRuntimeException(USER_BY_THIS_ID_NOT_EXIST));
        return userMapper.userEntityToUser(userEntity);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities
                .stream()
                .map(userMapper::userEntityToUser)
                .collect(Collectors.toList());
    }

    @Override
    public Page<User> getPageUsers(int currentPage, int pageSize) {
        PageRequest sortedByFirstName = PageRequest.of(currentPage - 1, pageSize, Sort.by("firstName"));
        Page<UserEntity> userEntities = userRepository.findAll(sortedByFirstName);
        List<User> result = userEntities
                .stream()
                .map(userMapper::userEntityToUser)
                .collect(Collectors.toList());
        return new PageImpl<>(result, sortedByFirstName, countUsers());
    }

    private long countUsers() {
        return userRepository.count();
    }

    @Override
    public User edit(Long id, User user) {
        checkUserExist(id);

        user.setId(id);
        return save(user);
    }

    @Override
    public void deleteById(Long id) {
        checkUserExist(id);

        userRepository.deleteById(id);
    }

    private void checkUserExist(Long id) {
        if (userNotExistsById(id)) {
            throw new UserNotExistRuntimeException();
        }
    }

    private void checkCorrectIdUser(Long id) {
        if (id < THE_SMALLEST_POSSIBLE_ID) {
            throw new UserIdNegativeRuntimeException(ID_MUST_BE_POSITIVE);
        }
    }

    private boolean userNotExistsById(Long id) {
        checkCorrectIdUser(id);

        return !userRepository.existsById(id);
    }
}
