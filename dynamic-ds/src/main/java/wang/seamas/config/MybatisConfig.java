package wang.seamas.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("wang.seamas.mapper")
public class MybatisConfig {
}
