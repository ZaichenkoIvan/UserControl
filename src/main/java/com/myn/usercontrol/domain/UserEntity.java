package com.myn.usercontrol.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "userr")
public class UserEntity {
    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDay;

    private String login;

    private String password;

    private String description;

    private String address;
}
