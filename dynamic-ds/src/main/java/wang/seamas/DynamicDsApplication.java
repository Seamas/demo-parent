package wang.seamas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DynamicDsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDsApplication.class, args);
    }
}
