package net.oasisgames.nexus.resources;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.UserCountDto;
import net.oasisgames.nexus.services.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home")
public class HomeResource {

    private final HomeService homeService;

    @CrossOrigin
    @GetMapping("/user-count")
    public ResponseEntity<UserCountDto> getUserCount() {
        return ResponseEntity.ok().body(homeService.getUserCount());
    }

}
