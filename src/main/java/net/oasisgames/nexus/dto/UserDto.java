package net.oasisgames.nexus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String authId;
    private String username;
    private String email;
    private String picture;

}
