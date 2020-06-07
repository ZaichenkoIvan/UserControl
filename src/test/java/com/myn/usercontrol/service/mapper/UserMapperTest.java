package com.myn.usercontrol.service.mapper;

import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.service.InitializationDataForTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserMapperTest {
    private static final UserEntity USER_ENTITY = InitializationDataForTest.getUserEntity();
    private static final User USER = InitializationDataForTest.getUser();

    private final UserMapper userMapper = new UserMapper();

    @Test
    public void shouldMapUserEntityToUser() {
        User actual = userMapper.userEntityToUser(USER_ENTITY);
        Assertions.assertAll(
                () -> assertEquals(actual.getId(), USER.getId()),
                () -> assertEquals(actual.getFirstName(), USER.getFirstName()),
                () -> assertEquals(actual.getLastName(), USER.getLastName()),
                () -> assertEquals(actual.getBirthDay(), USER.getBirthDay()),
                () -> assertEquals(actual.getLogin(), USER.getLogin()),
                () -> assertEquals(actual.getPassword(), USER.getPassword()),
                () -> assertEquals(actual.getAddress(), USER.getAddress())
        );
    }

    @Test
    public void shouldMapUserToUserEntity() {
        UserEntity actual = userMapper.userToUserEntity(USER);
        Assertions.assertAll(
                () -> assertEquals(actual.getId(), USER_ENTITY.getId()),
                () -> assertEquals(actual.getFirstName(), USER_ENTITY.getFirstName()),
                () -> assertEquals(actual.getLastName(), USER_ENTITY.getLastName()),
                () -> assertEquals(actual.getBirthDay(), USER_ENTITY.getBirthDay()),
                () -> assertEquals(actual.getLogin(), USER_ENTITY.getLogin()),
                () -> assertEquals(actual.getPassword(), USER_ENTITY.getPassword()),
                () -> assertEquals(actual.getAddress(), USER_ENTITY.getAddress())

        );
    }

    @Test
    public void mapUserToUserEntityShouldReturnNull() {
        UserEntity actual = userMapper.userToUserEntity(null);
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void mapUserEntityToUserShouldReturnNull() {
        User actual = userMapper.userEntityToUser(null);
        assertThat(actual, is(nullValue()));
    }
}
