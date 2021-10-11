package wang.seamas.job;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SyncTaskTest {

    @Autowired
    SyncTask syncTask;

    @Test
    public void test() throws InterruptedException {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}