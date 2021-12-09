package wang.seamas.job;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ASyncTaskTest {

    @Autowired
    ASyncTask asyncTask;

    @Test
    public void test() throws InterruptedException {
        Integer taskOne = asyncTask.doTaskOne();
        Integer taskTwo = asyncTask.doTaskTwo();
        Integer taskThree = asyncTask.doTaskThree();

        log.info("result: {}, {}, {}" , taskOne, taskTwo, taskThree);
        Thread.currentThread().join();
    }
}