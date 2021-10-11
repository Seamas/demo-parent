package wang.seamas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduleJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleJobApplication.class, args);
    }
}
