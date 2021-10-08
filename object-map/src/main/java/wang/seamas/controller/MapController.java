package wang.seamas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.mapstruct.UserMapper;
import wang.seamas.model.entity.UserEntity;
import wang.seamas.model.vo.UserVo;

import java.util.Date;

@RestController
public class MapController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserMapper userMapper;

    @GetMapping("modelmapper")
    public Object modelMapper() {
        UserEntity userEntity = createUserEntity();

        return mapper.map(userEntity, UserVo.class);
    }

    private UserEntity createUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("hello");
        userEntity.setBirthday(new Date());
        return userEntity;
    }

    @GetMapping("mapstruct")
    public Object mapstruct() {
        UserEntity userEntity = createUserEntity();
        return userMapper.from(userEntity);
    }
}
