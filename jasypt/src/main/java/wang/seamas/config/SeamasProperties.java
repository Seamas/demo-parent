package wang.seamas.config;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "seamas")
@JacksonXmlRootElement(localName = "User")
public class SeamasProperties {

    @JacksonXmlProperty(localName = "name")
    private String username;
    @JacksonXmlProperty(localName = "pwd")
    private String password;
}
