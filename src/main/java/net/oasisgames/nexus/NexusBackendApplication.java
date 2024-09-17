package net.oasisgames.nexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class NexusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusBackendApplication.class, args);
    }

}
