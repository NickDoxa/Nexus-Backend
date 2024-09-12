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
public class AccountResource {

    private final UserService userService;

    @GetMapping("/{id}/exists")
    public ResponseEntity<UserDto> checkEntityExists(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.userExists(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }

}
