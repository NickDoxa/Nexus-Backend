package net.oasisgames.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "nexus_cards")
public class PlayerCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Game> games;

    private String backgroundColorHex;

    private String textColorHex;

    private String platform;

    private String favoriteGame;

    @Override
    public String toString() {
        return "ID: " + id + "\nBIO: " + bio + "\nBACKGROUND COLOR: " + backgroundColorHex
                + "\nTEXT COLOR: " + textColorHex + "\nPLATFORM: " + platform
                + "\nFAVORITE GAME: " + favoriteGame + "\nGAMES: " + games.toString();
    }

    public PlayerCard update(PlayerCard card) {
        this.bio = card.getBio() == null ? this.bio : card.getBio();
        this.games = card.getGames() == null ? this.games : card.getGames();
        this.backgroundColorHex = card.getBackgroundColorHex() == null ?
                this.backgroundColorHex : card.getBackgroundColorHex();
        this.textColorHex = card.getTextColorHex() == null ?
                this.textColorHex : card.getTextColorHex();
        this.platform = card.getPlatform() == null ? this.platform : card.getPlatform();
        this.favoriteGame = card.getFavoriteGame() == null ? this.favoriteGame : card.getFavoriteGame();
        return this;
    }

}
