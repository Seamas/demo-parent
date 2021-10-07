package wang.seamas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.seamas.mapper.primary.PrimaryUserMapper;
import wang.seamas.mapper.secondary.SecondaryUserMapper;
import wang.seamas.model.User;
import wang.seamas.service.PrimaryUserService;
import wang.seamas.service.SecondaryUserService;

import java.util.List;

@Service("slaveUserService")
public class SecondaryUserServiceImpl implements SecondaryUserService {

    @Autowired
    private SecondaryUserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    // 如果有多个事务管理器，如果当前不是主要的事务管理器，应该声明
    @Override
    @Transactional("transactionManagerSecondary")
    public int addAll() {
        userMapper.insert(new User("hello", 10));
        userMapper.insert(new User("hello", 10));
        return 2;
    }
}
