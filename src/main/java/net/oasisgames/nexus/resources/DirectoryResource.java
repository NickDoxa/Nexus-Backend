package net.oasisgames.nexus.resources;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.UserDto;
import net.oasisgames.nexus.services.DirectoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directory")
@CrossOrigin(origins = "*")
public class DirectoryResource {

    private final DirectoryService directoryService;

    @GetMapping("/cards")
    public ResponseEntity<Page<UserDto>> getDirectory(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok().body(directoryService.getUsers(page, size));
    }

}
