package wang.seamas.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PagedResultVo<T> {

    private Long current;
    private Long size;
    private Long total;
    private List<T> list;
}
