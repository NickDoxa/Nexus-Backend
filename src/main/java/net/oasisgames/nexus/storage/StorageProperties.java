package net.oasisgames.nexus.storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
@Getter
@Setter
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "user-images";

}