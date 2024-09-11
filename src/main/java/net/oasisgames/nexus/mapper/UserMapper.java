package net.oasisgames.nexus.mapper;

import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Mapping(target = "admin", ignore = true)
    @Mapping(target = "username")
    @Mapping(target = "password")
    @Mapping(target = "id")
    User getUserFromUserDto(UserDto userDto);
    @Mapping(target = "admin", ignore = true)
    @Mapping(target = "username")
    @Mapping(target = "password")
    @Mapping(target = "id")
    UserDto getUserDtoFromUser(User user);

    default User getEncryptedUser(UserDto userDto) {
        User user = getUserFromUserDto(userDto);
        System.out.println(user.toString());
        user.setPassword(encoder.encode(user.getPassword()));
        return user;
    }

}
