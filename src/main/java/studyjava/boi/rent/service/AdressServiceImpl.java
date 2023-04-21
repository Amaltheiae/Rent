package studyjava.boi.rent.service;

import org.springframework.stereotype.Service;
import studyjava.boi.rent.entity.Adress;
import studyjava.boi.rent.repository.AdressRepository;

import java.util.List;

@Service
public class AdressServiceImpl implements AdressService {
    private AdressRepository adressRepository;

    public AdressServiceImpl(AdressRepository adressRepository) {
        super();
        this.adressRepository = adressRepository;
    }

    @Override
    public List<Adress> getAllAdress() {
        return adressRepository.findAll();
    }
}
