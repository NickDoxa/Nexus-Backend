package net.oasisgames.nexus.resources;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.ImageDto;
import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PatchMapping("/edit")
    public ResponseEntity<UserDto> edit(@RequestBody UserDto user) {
        return ResponseEntity.ok().body(userService.editExistingUser(user));
    }

    @PostMapping(value = "/{id}/set-profile-picture")
    public ResponseEntity<UserDto> setProfilePicture(@PathVariable String id,
                                                     @RequestParam("file") MultipartFile file) {
        userService.saveProfilePicture(id, file);
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping("/{id}/get-profile-picture")
    public ResponseEntity<ImageDto> getProfilePicture(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.getProfilePicture(id));
    }

}
