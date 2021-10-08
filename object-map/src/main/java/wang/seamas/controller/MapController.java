package wang.seamas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.model.entity.UserEntity;
import wang.seamas.model.vo.UserVo;

import java.util.Date;

@RestController
public class MapController {

    @Autowired
    ModelMapper mapper;

    @GetMapping("modelmapper")
    public Object modelMapper() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("hello");
        userEntity.setBirthday(new Date());

        return mapper.map(userEntity, UserVo.class);
    }
}
