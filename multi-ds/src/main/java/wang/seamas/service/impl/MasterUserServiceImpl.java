package wang.seamas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.seamas.mapper.primary.PrimaryUserMapper;
import wang.seamas.model.User;
import wang.seamas.service.PrimaryUserService;

import java.util.List;

@Service
public class MasterUserServiceImpl implements PrimaryUserService {

    @Autowired
    private PrimaryUserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    @Override
    @Transactional
    public int addAll() {
        userMapper.insert(new User("hello", 10));
        userMapper.insert(new User("hello", 10));
        return 2;
    }
}
