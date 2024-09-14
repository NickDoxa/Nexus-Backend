package net.oasisgames.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nexus_games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String game;

    private String username;

    @Column(columnDefinition = "boolean default false")
    private Boolean shown;

    @Override
    public String toString() {
        return "ID: " + id + "\n GAME: " + game + "\n USERNAME: " + username + "\n SHOWN: " + shown;
    }

}
