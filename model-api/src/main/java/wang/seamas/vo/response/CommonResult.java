package wang.seamas.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResult<T> {

    private String code;
    private String message;
    private T data;

    public CommonResult(T data) {
        this("", "", data);
    }
}
