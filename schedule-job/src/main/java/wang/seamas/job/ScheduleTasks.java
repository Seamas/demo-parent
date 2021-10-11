package wang.seamas.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class ScheduleTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        log.info("Schedule: {}", dateFormat.format(new Date()));
    }
}
