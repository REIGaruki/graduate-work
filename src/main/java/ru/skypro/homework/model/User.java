package ru.skypro.homework.model;

import lombok.Data;
import ru.skypro.homework.dto.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String phone;

    private Role role;

    private String image;

}
