package wang.seamas.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

@Service
public class JdbcUserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    JdbcUserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(User user) {
        return jdbcTemplate.update("insert into demo_user(name, age) values(?, ?)", user.getName(), user.getAge());
    }

    @Override
    public User getByName(String name) {
        return jdbcTemplate.queryForObject("select name, age from demo_user where name = ?", ((resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }), name);
    }

    @Override
    public int deleteByName(String name) {
        return jdbcTemplate.update("delete from demo_user where name = ?", name);
    }

    @Override
    public Long countAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from demo_user", Long.class);
    }

    @Override
    public int deleteAllUsers() {
        return jdbcTemplate.update("delete from demo_user");
    }
}
