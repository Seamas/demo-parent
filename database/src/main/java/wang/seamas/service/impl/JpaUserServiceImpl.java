package wang.seamas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.seamas.model.User;
import wang.seamas.repository.UserRepository;
import wang.seamas.service.UserService;

@Service
public class JpaUserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public int create(User user) {

        userRepository.save(user);
        return 1;
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        return userRepository.deleteByName(name);
    }

    @Override
    public Long countAllUsers() {
        return userRepository.count();
    }

    @Override
    public int deleteAllUsers() {
        userRepository.deleteAll();
        return 1;
    }
}
