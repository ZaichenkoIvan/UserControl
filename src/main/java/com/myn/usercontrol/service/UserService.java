package com.myn.usercontrol.service;


import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.exception.UserNotExistRuntimeException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    /**
     * This method is used to save user in database
     *
     * @param user - user for save
     * @return saved user in database
     * @see User
     * @see UserEntity
     */
    User save(User user);

    /**
     * This method is used to find user by id in database
     *
     * @param id - the user id for finding
     * @return user in database by id
     * @throws UserNotExistRuntimeException if user not exist
     * @see User
     * @see UserEntity
     */
    User findById(Long id);

    /**
     * This method is used to find all user in database
     *
     * @return the list of user
     * @see User
     * @see UserEntity
     */
    List<User> findAll();

    /**
     * This method is used to get user for pagination
     *
     * @param currentPage - current page in view
     * @param pageSize    - max row in user table
     * @return user for pagination
     * @see User
     * @see UserEntity
     */
    Page<User> getPageUsers(int currentPage, int pageSize);

    /**
     * This method is used to edit user by id in database
     *
     * @param id   - the user id for update
     * @param user - the user for update
     * @return update user
     * @throws UserNotExistRuntimeException if user not exist
     * @see User
     */
    User edit(Long id, User user);

    /**
     * This method is used to delete user by id in database
     *
     * @param id - the user id for delete
     * @throws UserNotExistRuntimeException if user not exist
     */
    void deleteById(Long id);
}
