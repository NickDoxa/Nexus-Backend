package net.oasisgames.nexus.dto;

import lombok.Getter;
import lombok.Setter;
import net.oasisgames.nexus.entity.PlayerCard;

@Getter
@Setter
public class UserDto {

    private String authId;
    private String username;
    private String email;
    private String picture;
    private boolean useFilePicture;
    private PlayerCard card;

}
