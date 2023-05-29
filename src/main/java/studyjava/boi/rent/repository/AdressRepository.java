package studyjava.boi.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyjava.boi.rent.entity.Adress;
import studyjava.boi.rent.entity.Street;


public interface AdressRepository extends JpaRepository<Adress, Long> {
    Adress findAdressByStreetAndBuildingNumber(Street street, String buildingNumber);
}
