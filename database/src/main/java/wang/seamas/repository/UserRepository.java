package wang.seamas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.seamas.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByName(String name);

    int deleteByName(String name);
}
