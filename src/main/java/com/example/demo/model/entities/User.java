package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String password;
    private String avatar;
}
