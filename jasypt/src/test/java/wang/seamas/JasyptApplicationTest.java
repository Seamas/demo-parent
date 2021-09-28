package wang.seamas;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wang.seamas.config.SeamasProperties;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class JasyptApplicationTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Autowired
    SeamasProperties seamasProperties;



    @Test
    public void test() {
        var username = stringEncryptor.encrypt(seamasProperties.getUsername());
        var password = stringEncryptor.encrypt(seamasProperties.getPassword());

        log.info("username: {} , password: {}", username, password);

    }
}