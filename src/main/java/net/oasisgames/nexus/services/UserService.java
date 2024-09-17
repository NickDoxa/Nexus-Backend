package net.oasisgames.nexus.services;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.PlayerCardDto;
import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.entity.User;
import net.oasisgames.nexus.mapper.PlayerCardMapper;
import net.oasisgames.nexus.mapper.UserMapper;
import net.oasisgames.nexus.repository.PlayerCardRepository;
import net.oasisgames.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PlayerCardMapper playerCardMapper;
    private final PlayerCardRepository playerCardRepository;

    public UserDto createNewUser(UserDto userDto) {
        User user = userMapper.getUserFromUserDto(userDto);
        playerCardRepository.saveAndFlush(user.getCard());
        return userMapper.getUserDtoFromUser(userRepository.saveAndFlush(user));
    }

    public UserDto editExistingUser(UserDto userDto) {
        assert !doesUserExist(userDto.getAuthId());
        User user = userRepository.findById(userDto.getAuthId()).orElse(null);
        assert user != null;
        User updated = userRepository.save(user.update(userMapper.getUserFromUserDto(userDto)));
        return userMapper.getUserDtoFromUser(updated);
    }

    public UserDto userExists(String id) {
        User user = userRepository.findById(id).orElse(new User());
        return userMapper.getUserDtoFromUser(user);
    }

    private boolean doesUserExist(String id) {
        return userRepository.findById(id).isPresent();
    }

    public UserDto getUserById(String id) {
        return userMapper.getUserDtoFromUser(userRepository.findById(id).orElse(null));
    }

    public PlayerCardDto getPlayerCardById(String id) {
        UserDto user = getUserById(id);
        return playerCardMapper.getPlayerCardDtoFromPlayerCard(user.getCard());
    }

}
