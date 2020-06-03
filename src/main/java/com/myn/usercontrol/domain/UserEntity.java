package com.myn.usercontrol.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private Long id;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDay;

    private String login;

    private String password;

    private String description;

    private String address;
}
