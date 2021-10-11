package wang.seamas.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class MySimpleJob implements SimpleJob {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void execute(ShardingContext shardingContext) {
        int item = shardingContext.getShardingItem();
        switch (item) {
            case 0:
            case 1:
            case 2:
                log.info("分片{}:执行任务, {}", item, dateFormat.format(new Date()));
                break;
            default:
                log.info("默认分片执行，正常情况下不应该打印");
                break;
        }
    }
}
