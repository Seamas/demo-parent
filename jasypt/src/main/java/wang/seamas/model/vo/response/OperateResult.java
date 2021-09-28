package wang.seamas.model.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperateResult<T> {

    private String code;
    private String message;
    private T data;

    public OperateResult(T data) {
        this("200", "", data);
    }
}
