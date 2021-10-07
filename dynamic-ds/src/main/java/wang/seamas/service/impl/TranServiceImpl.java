package wang.seamas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.seamas.mapper.UserMapper;
import wang.seamas.model.User;
import wang.seamas.service.TranService;

@Service
public class TranServiceImpl implements TranService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int executeWithoutTransaction() {
        userMapper.insert(new User("world", 20));

        executeWithTransaction();
        return 1;
    }

    @Override
    @Transactional
    public int executeWithTransaction() {
        userMapper.insert(new User("hello", 10));
        userMapper.insert(new User("hello", 10));
        return 2;
    }
}
