package wang.seamas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "config")
@Data
public class Config {

    private List<Map> testList;
    private Map<String, String> testMap;
}
