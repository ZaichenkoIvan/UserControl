package com.myn.usercontrol.service.mapper;

import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper {
    public User userEntityToUser(UserEntity userEntity) {
        if (Objects.isNull(userEntity)) {
            return null;
        }

        return User.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .birthDay(userEntity.getBirthDay())
                .login(userEntity.getLogin())
                .password(userEntity.getPassword())
                .description(userEntity.getDescription())
                .address(userEntity.getAddress())
                .build();
    }

    public UserEntity userToUserEntity(User user) {
        if (Objects.isNull(user)) {
            return null;
        }

        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDay(user.getBirthDay())
                .login(user.getLogin())
                .password(user.getPassword())
                .description(user.getDescription())
                .address(user.getAddress())
                .build();
    }
}
