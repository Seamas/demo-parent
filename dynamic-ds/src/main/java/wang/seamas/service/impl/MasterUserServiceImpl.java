package wang.seamas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.seamas.mapper.UserMapper;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

import java.util.List;

@Service
public class MasterUserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectList(new QueryWrapper<>());
    }
}
