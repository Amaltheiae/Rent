package studyjava.boi.rent.service;

import org.springframework.stereotype.Service;
import studyjava.boi.rent.entity.Apartment;
import studyjava.boi.rent.repository.ApartmentRepository;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService{
    private ApartmentRepository  apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        super();
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public List<Apartment> getAllApartment() {
        return apartmentRepository.findAll();
    }
}
