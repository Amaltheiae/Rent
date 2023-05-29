package studyjava.boi.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyjava.boi.rent.entity.Apartment;

import java.util.Optional;


public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

   Optional<Apartment> findById(Long idApartment);

   void deleteById(Long idApartment);
}

