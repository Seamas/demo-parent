package wang.seamas.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@TableName("demo_user")
@Table(name = "demo_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @TableId
    private String name;
    private Integer age;
}
