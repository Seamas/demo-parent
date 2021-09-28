package wang.seamas.model.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {

    @NotBlank(message = "姓名不能为空")
    private String userName;
    private Integer age;
}
