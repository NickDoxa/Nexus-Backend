package net.oasisgames.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nexus_users")
public class User {

    @Id
    private String authId;

    private String username;

    private String email;

    private String picture;

    @Override
    public String toString() {
        return "USER: " + username + "\nEMAIL: " + email + "\nPICTURE: " + picture + "\nAUTH ID: " + authId;
    }

}
