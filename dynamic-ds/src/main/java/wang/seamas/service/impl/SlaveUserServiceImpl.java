package wang.seamas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.seamas.config.DataSourceManager;
import wang.seamas.config.DataTypes;
import wang.seamas.mapper.UserMapper;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

import java.util.List;

@Service
public class SlaveUserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        // 由于设置了ThreadLocal的值，需要及时清除，否则会导致线程间不可预料的问题
//        DataSourceManager.set(DataTypes.SLAVE);
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectList(new QueryWrapper<>());
    }
}
