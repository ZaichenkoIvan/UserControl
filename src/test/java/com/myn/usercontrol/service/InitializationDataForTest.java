package com.myn.usercontrol.service;

import com.myn.usercontrol.domain.UserEntity;
import com.myn.usercontrol.dto.User;

import java.time.LocalDate;

public class InitializationDataForTest {

    public static UserEntity getUserEntity() {
        return new UserEntity(1L, "Ivan", "Zaichenko", LocalDate.of(1999, 1, 13),
                "ivan@gmail.com", "12345", "I am student", "Yangelya");
    }

    public static User getUser() {
        return User.builder()
                .id(1L)
                .firstName("Ivan")
                .lastName("Zaichenko")
                .birthDay(LocalDate.of(1999, 1, 13))
                .login("ivan@gmail.com")
                .password("12345")
                .description("I am student")
                .address("Yangelya")
                .build();
    }
}
