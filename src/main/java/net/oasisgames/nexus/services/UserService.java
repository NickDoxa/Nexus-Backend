package net.oasisgames.nexus.services;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.entity.User;
import net.oasisgames.nexus.mapper.UserMapper;
import net.oasisgames.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto createNewUser(UserDto userDto) {
        User user = userMapper.getUserFromUserDto(userDto);
        return userMapper.getUserDtoFromUser(userRepository.saveAndFlush(user));
    }

    public UserDto userExists(String id) {
        User user = userRepository.findById(id).orElse(new User());
        return userMapper.getUserDtoFromUser(user);
    }

    public UserDto getUserById(String id) {
        return userMapper.getUserDtoFromUser(userRepository.findById(id).orElse(null));
    }



}
