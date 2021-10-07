package wang.seamas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.seamas.mapper.UserMapper;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

@Service
public class MybatisUserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int create(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getByName(String name) {
        return userMapper.selectById(name);
    }

    @Override
    public int deleteByName(String name) {
        return userMapper.deleteById(name);
    }

    @Override
    public Long countAllUsers() {
        return userMapper.selectCount(new QueryWrapper<User>());
    }

    @Override
    public int deleteAllUsers() {
        return userMapper.delete(new QueryWrapper<>());
    }
}
