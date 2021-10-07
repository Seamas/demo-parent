package wang.seamas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.seamas.config.DataSourceManager;
import wang.seamas.config.DataTypes;
import wang.seamas.mapper.UserMapper;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

@Service
public class SlaveUserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        DataSourceManager.set(DataTypes.SLAVE);
        return userMapper.insert(user);
    }
}
