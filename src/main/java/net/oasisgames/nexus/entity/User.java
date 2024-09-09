package net.oasisgames.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nexus_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

}
