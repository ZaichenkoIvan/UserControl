package com.myn.usercontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDay;

    private String login;

    private String password;

    private String description;

    private String address;
}
