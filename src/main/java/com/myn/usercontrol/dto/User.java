package com.myn.usercontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDay;

    private String login;

    private String password;

    private String description;

    private String address;
}
