package studyjava.boi.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyjava.boi.rent.entity.Street;

public interface StreetRepository extends JpaRepository<Street, Long> {

}
