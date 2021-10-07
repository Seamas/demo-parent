package wang.seamas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "wang.seamas.mapper")
public class MultiDsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDsApplication.class, args);
    }
}
