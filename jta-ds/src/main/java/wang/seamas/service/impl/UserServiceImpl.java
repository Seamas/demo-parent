package wang.seamas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate master;

    @Autowired
    @Qualifier("slaveJdbcTemplate")
    JdbcTemplate slave;

    @Override
    @Transactional
    public int addAll() {
        User user = new User();
        user.setName("hello");
        user.setAge(10);
        master.update("insert into demo_user(name, age) values(?, ?)", user.getName(), user.getAge());
        slave.update("insert into demo_user(name, age) values(?, ?)", user.getName(), user.getAge());
        return 2;
    }
}
