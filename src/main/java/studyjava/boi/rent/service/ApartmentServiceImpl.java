package studyjava.boi.rent.service;

import org.springframework.stereotype.Service;
import studyjava.boi.rent.entity.Apartment;
import studyjava.boi.rent.repository.ApartmentRepository;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        super();
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public List<Apartment> getAllApartment() {
        return apartmentRepository.findAll();
    }

    @Override
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public Apartment getApartmentById(Long idApartment) {
        return apartmentRepository.findById(idApartment).get();
    }

    @Override
    public void deleteById(Long idApartment) {
        Apartment apartment = getApartmentById(idApartment);
        apartment.setAdress(null);
        apartmentRepository.deleteById(idApartment);
    }


}

