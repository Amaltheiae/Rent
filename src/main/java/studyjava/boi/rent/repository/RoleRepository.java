package studyjava.boi.rent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import studyjava.boi.rent.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
