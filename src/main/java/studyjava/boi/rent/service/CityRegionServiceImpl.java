package studyjava.boi.rent.service;

import org.springframework.stereotype.Service;
import studyjava.boi.rent.entity.CityRegion;
import studyjava.boi.rent.repository.CityRegionRepository;

import java.util.List;
@Service
public class CityRegionServiceImpl implements CityRegionService {

    private CityRegionRepository cityRegionRepository;

    public CityRegionServiceImpl(CityRegionRepository cityRegionRepository) {
        this.cityRegionRepository = cityRegionRepository;
    }

    @Override
    public List<CityRegion> getAllCityRegion() {
        return cityRegionRepository.findAll();
    }
}
