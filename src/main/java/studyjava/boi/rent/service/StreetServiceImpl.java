package studyjava.boi.rent.service;

import org.springframework.stereotype.Service;
import studyjava.boi.rent.entity.Street;
import studyjava.boi.rent.repository.StreetRepository;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService{

    private StreetRepository  streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        super();
        this.streetRepository = streetRepository;
    }

    @Override
    public List<Street> getAllStreet() {
        return streetRepository.findAll();
    }
}
