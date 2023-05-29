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

    @Override
    public Adress saveAdress(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public Adress findAdress(Adress adress) {
        return adressRepository.findAdressByStreetAndBuildingNumber(adress.getStreet(),
                adress.getBuildingNumber());
    }

}
