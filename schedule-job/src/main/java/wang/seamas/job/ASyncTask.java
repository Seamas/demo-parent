package wang.seamas.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ASyncTask {

    @Async
    public Integer doTaskOne() throws InterruptedException {
        log.info("task 1 start....");
        Thread.sleep(10000);
        log.info("task 1 finish....");
        return 1;
    }

    @Async
    public Integer doTaskTwo() throws InterruptedException {
        log.info("task 2 start....");
        Thread.sleep(10000);
        log.info("task 2 finish....");
        return 2;
    }

    @Async
    public Integer doTaskThree() throws InterruptedException {
        log.info("task 3 start....");
        Thread.sleep(10000);
        log.info("task 3 finish....");
        return 3;
    }
}
