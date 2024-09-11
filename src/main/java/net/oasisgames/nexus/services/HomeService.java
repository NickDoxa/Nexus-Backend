package net.oasisgames.nexus.services;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.UserCountDto;
import net.oasisgames.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final UserRepository userRepository;

    public UserCountDto getUserCount() {
        int count = userRepository.getUserCount();
        return new UserCountDto(count + 1000);
    }

}
