package wang.seamas.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ASyncTask {

    @Async
    public void doTaskOne() throws InterruptedException {
        log.info("task 1 start....");
        Thread.sleep(10000);
        log.info("task 1 finish....");
    }

    @Async
    public void doTaskTwo() throws InterruptedException {
        log.info("task 2 start....");
        Thread.sleep(10000);
        log.info("task 2 finish....");
    }

    @Async
    public void doTaskThree() throws InterruptedException {
        log.info("task 3 start....");
        Thread.sleep(10000);
        log.info("task 3 finish....");
    }
}
