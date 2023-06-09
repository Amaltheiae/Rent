package studyjava.boi.rent.service;

import studyjava.boi.rent.entity.Apartment;

import java.util.List;

public interface ApartmentService  {

    List<Apartment> getAllApartment();

    Apartment saveApartment(Apartment apartment);

    Apartment getApartmentById(Long idApartment);

    void deleteById(Long idApartment);
}
