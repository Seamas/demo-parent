package wang.seamas.config;

import lombok.var;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import wang.seamas.model.vo.response.OperateResult;

import java.util.stream.Collectors;

@ControllerAdvice
public class ValidatorHandlerAdvice extends ResponseEntityExceptionHandler {


    /**
     * Valid 绑定异常处理
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(item -> item.getDefaultMessage())
                .collect(Collectors.toList());

        return new ResponseEntity(new OperateResult("500", "数据格式验证错误", errors), HttpStatus.OK);
    }
}
