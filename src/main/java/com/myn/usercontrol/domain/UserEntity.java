package com.myn.usercontrol.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "userr")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDay", columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDay;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;
}
