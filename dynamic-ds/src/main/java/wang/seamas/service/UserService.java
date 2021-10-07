package wang.seamas.service;

import wang.seamas.model.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> selectAll();
}
