package studyjava.boi.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyjava.boi.rent.entity.Apartment;


public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}

