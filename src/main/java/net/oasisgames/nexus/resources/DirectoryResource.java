package net.oasisgames.nexus.resources;

import lombok.RequiredArgsConstructor;
import net.oasisgames.nexus.dto.DirectoryEntryDto;
import net.oasisgames.nexus.services.DirectoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directory")
@CrossOrigin(origins = "*")
public class DirectoryResource {

    private final DirectoryService directoryService;

    public ResponseEntity<DirectoryEntryDto> getDirectory() {
        return null;
    }

}
