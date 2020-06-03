package com.myn.usercontrol.service.impl;

import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.exception.UserIdNegativeRuntimeException;
import com.myn.usercontrol.exception.UserNotExistRuntimeException;
import com.myn.usercontrol.repository.UserRepository;
import com.myn.usercontrol.service.UserService;
import com.myn.usercontrol.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final String USER_BY_THIS_ID_NOT_EXIST = "User by this id not exist";
    private static final String ID_MUST_BE_POSITIVE = "Id must be positive";
    private static final int THE_SMALLEST_POSSIBLE_ID = 0;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean existsById(Long id) {
        checkCorrectIdUser(id);

        return userRepository.existsById(id);
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
//        return userRepository.findAll();
        return null;

    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.userToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return userMapper.userEntityToUser(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        checkCorrectIdUser(id);

        userRepository.deleteById(id);
    }

    private void checkCorrectIdUser(Long id) {
        if(id < THE_SMALLEST_POSSIBLE_ID){
            throw new UserIdNegativeRuntimeException(ID_MUST_BE_POSITIVE);
        }
    }
}
