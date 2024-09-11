package net.oasisgames.nexus.resources;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
@CrossOrigin(origins = "*")
public class SecurityResource {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto user) {
        return ResponseEntity.ok().body(userService.login(user.getUsername(), user.getPassword()));
    }

}
