package wang.seamas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "seamas")
public class SeamasProperties {

    private String username;
    private String password;
}
