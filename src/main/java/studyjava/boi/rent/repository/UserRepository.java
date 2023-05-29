package studyjava.boi.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyjava.boi.rent.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
