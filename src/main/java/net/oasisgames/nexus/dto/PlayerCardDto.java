package net.oasisgames.nexus.dto;

import lombok.Getter;
import lombok.Setter;
import net.oasisgames.nexus.entity.Game;

import java.util.Set;

@Getter
@Setter
public class PlayerCardDto {

    private String bio;
    private Set<Game> games;
    private String backgroundColorHex;
    private String textColorHex;
    private String platform;
    private String favoriteGame;

}
