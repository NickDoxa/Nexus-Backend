package net.oasisgames.nexus.services;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.entity.User;
import net.oasisgames.nexus.mapper.UserMapper;
import net.oasisgames.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto createNewUser(UserDto userDto) {
        User user = userMapper.getEncryptedUser(userDto);
        return userMapper.getUserDtoFromUser(userRepository.save(user));
    }

    public UserDto login(String username, String password) {
        return null; //TODO
    }

}
