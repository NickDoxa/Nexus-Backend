package net.oasisgames.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nexus_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String password;

    private Boolean admin;

    @Override
    public String toString() {
        return "USER: " + username + ", PASSWORD: " + password + ", ADMIN: " + admin + ", ID: " + id;
    }

}
