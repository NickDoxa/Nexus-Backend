package net.oasisgames.nexus.mapper;

import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "useFilePicture")
    User getUserFromUserDto(UserDto userDto);
    @Mapping(target = "useFilePicture")
    UserDto getUserDtoFromUser(User user);

}
