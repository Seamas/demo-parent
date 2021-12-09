package wang.seamas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cust")
@Data
public class Cust {

    private String userName;
    private String age;
}
