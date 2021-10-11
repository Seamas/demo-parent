package wang.seamas.job;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ASyncTaskTest {

    @Autowired
    ASyncTask asyncTask;

    @Test
    public void test() throws InterruptedException {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();

        Thread.currentThread().join();
    }
}