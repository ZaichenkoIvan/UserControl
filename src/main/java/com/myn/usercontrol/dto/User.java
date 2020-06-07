package com.myn.usercontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Min(1)
    @Max(10000000)
    private Long id;

    @NotEmpty(message = "Please enter name")
    private String firstName;

    @NotEmpty
    private String lastName;

    private LocalDate birthDay;

    @Email
    private String login;

    private String password;

    @NotEmpty
    private String description;

    @NotEmpty
    private String address;
}
