package wang.seamas.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wang.seamas.model.entity.UserEntity;
import wang.seamas.model.vo.UserVo;

@Mapper(componentModel = "spring"
        , uses = DateMapper.class
)
public interface UserMapper {

    UserVo from(UserEntity entity);
}
