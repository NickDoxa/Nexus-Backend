package net.oasisgames.nexus.services;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.mapper.UserMapper;
import net.oasisgames.nexus.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectoryService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<UserDto> getUsers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<UserDto> pageDto = userRepository.findAll(pageRequest)
                .stream()
                .map(userMapper::getUserDtoFromUser)
                .toList();
        return new PageImpl<>(pageDto, pageRequest, pageDto.size());
    }

}
