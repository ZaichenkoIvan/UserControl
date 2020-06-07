package com.myn.usercontrol.service.impl;

import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.exception.UserIdNegativeRuntimeException;
import com.myn.usercontrol.exception.UserNotExistRuntimeException;
import com.myn.usercontrol.repository.UserRepository;
import com.myn.usercontrol.service.InitializationDataForTest;
import com.myn.usercontrol.service.mapper.UserMapper;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserServiceImpl.class})
public class UserServiceImplTest {
    private static final UserEntity USER_ENTITY = InitializationDataForTest.getUserEntity();
    private static final User USER = InitializationDataForTest.getUser();
    private static final List<UserEntity> USER_ENTITIES = Arrays.asList(USER_ENTITY, USER_ENTITY);
    private static final List<User> USERS = Arrays.asList(USER, USER);
    private static final String encodePassword = "encodePassword";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userService;

    @After
    public void resetMock() {
        reset(userRepository, userMapper, passwordEncoder);
    }

    @Test
    public void findByIdShouldThrowUserNotExistRuntimeExceptionWithNoUser() {
        exception.expect(UserNotExistRuntimeException.class);
        exception.expectMessage("User by this id not exist");
        when(userRepository.findById(anyLong())).thenThrow(new UserNotExistRuntimeException("User by this id not exist"));

        userService.findById(2L);
    }

    @Test
    public void findByIdShouldReturnUser() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(USER_ENTITY));
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(USER);
        User actual = userService.findById(1L);

        assertThat(actual, is(USER));
    }

    @Test
    public void findByIdShouldThrowUserIdNegativeRuntimeExceptionWithNegativeId() {
        exception.expect(UserIdNegativeRuntimeException.class);
        exception.expectMessage("Id must be positive");

        userService.findById(-1L);
    }

    @Test
    public void findAllShouldReturnListOfUser() {
        when(userRepository.findAll()).thenReturn(USER_ENTITIES);
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(USER);

        List<User> actual = userService.findAll();
        verify(userMapper, times(2)).userEntityToUser(any(UserEntity.class));

        assertThat(actual, is(USERS));
    }

    @Test
    public void editShouldThrowUserNotExistRuntimeExceptionWithNoExistedUser() {
        exception.expect(UserNotExistRuntimeException.class);
        when(userRepository.existsById(anyLong())).thenReturn(false);
        when(passwordEncoder.encode(anyString())).thenReturn(encodePassword);

        userService.edit(1L, USER);
    }

    @Test
    public void editShouldThrowUserIdNegativeRuntimeExceptionWithNegativeId() {
        exception.expect(UserIdNegativeRuntimeException.class);
        exception.expectMessage("Id must be positive");
        when(passwordEncoder.encode(anyString())).thenReturn(encodePassword);

        userService.edit(-1L, USER);
    }


    @Test
    public void editShouldReturnEditUserById() {
        when(userRepository.existsById(anyLong())).thenReturn(true);
        when(userMapper.userToUserEntity(any(User.class))).thenReturn(USER_ENTITY);
        when(userRepository.save(any(UserEntity.class))).thenReturn(USER_ENTITY);
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(USER);
        when(passwordEncoder.encode(anyString())).thenReturn(encodePassword);

        User actual = userService.edit(1L, USER);
        assertThat(actual, is(USER));
    }

    @Test
    public void deleteByIdShouldThrowUserNotExistRuntimeExceptionWithNegativeId() {
        exception.expect(UserNotExistRuntimeException.class);
        when(userRepository.existsById(anyLong())).thenReturn(false);

        userService.deleteById(1L);
    }

    @Test
    public void deleteByIdShouldThrowUserIdNegativeRuntimeExceptionWithNegativeId() {
        exception.expect(UserIdNegativeRuntimeException.class);
        exception.expectMessage("Id must be positive");
        when(passwordEncoder.encode(anyString())).thenReturn(encodePassword);

        userService.edit(-1L, USER);
    }

    @Test
    public void deleteByIdShouldDeleteUserById() {
        when(userRepository.existsById(anyLong())).thenReturn(true);
        userService.deleteById(1L);
        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void saveShouldSaveUser() {
        when(userMapper.userToUserEntity(any(User.class))).thenReturn(USER_ENTITY);
        when(userRepository.save(any(UserEntity.class))).thenReturn(USER_ENTITY);
        when(userMapper.userEntityToUser(any(UserEntity.class))).thenReturn(USER);
        when(passwordEncoder.encode(anyString())).thenReturn(encodePassword);

        User actual = userService.save(USER);
        assertThat(actual, is(USER));
    }
}
