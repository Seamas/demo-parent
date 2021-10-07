package wang.seamas.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    @TableId
    private String name;
    private Integer age;
}
