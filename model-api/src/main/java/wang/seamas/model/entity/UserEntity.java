package wang.seamas.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {

    private String name;
    private Date birthday;
}
