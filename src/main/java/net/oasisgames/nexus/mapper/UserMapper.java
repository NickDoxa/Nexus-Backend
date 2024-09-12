package net.oasisgames.nexus.mapper;

import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User getUserFromUserDto(UserDto userDto);
    UserDto getUserDtoFromUser(User user);

}
