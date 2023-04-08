package studyjava.boi.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import studyjava.boi.rent.entity.CityRegion;
import studyjava.boi.rent.repository.CityRegionRepository;
import studyjava.boi.rent.service.CityRegionService;
import studyjava.boi.rent.service.CityRegionServiceImpl;

import java.util.List;

@SpringBootApplication
public class RentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentApplication.class, args);
    }

    @Autowired
    CityRegionService cityRegionService;
    @Autowired
    CityRegionRepository cityRegionRepository;

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {

        return (args) -> {
            System.out.println("In CommandLineRunnerImpl ");
            System.out.println("Test Employee Spring ");
            try {
                cityRegionService = new CityRegionServiceImpl(cityRegionRepository);
                List<CityRegion> cityRegions = cityRegionService.getAllCityRegion();
                Thread.sleep(500);
                System.out.println("\nCurrent state of City Region");
                cityRegions.stream().forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("END SHOW City Region WITH Spring");

        };

    }
}