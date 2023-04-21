package studyjava.boi.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyjava.boi.rent.entity.Adress;


public interface AdressRepository extends JpaRepository<Adress, Long> {

}
