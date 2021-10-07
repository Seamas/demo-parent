package wang.seamas.service;


import wang.seamas.model.User;

public interface UserService {

    int create(User user);

    User getByName(String name);

    int deleteByName(String name);

    Long countAllUsers();

    int deleteAllUsers();
}
