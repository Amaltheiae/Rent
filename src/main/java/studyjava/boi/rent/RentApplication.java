package studyjava.boi.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import studyjava.boi.rent.entity.Adress;
import studyjava.boi.rent.entity.Apartment;
import studyjava.boi.rent.entity.CityRegion;
import studyjava.boi.rent.entity.Street;
import studyjava.boi.rent.repository.AdressRepository;
import studyjava.boi.rent.repository.ApartmentRepository;
import studyjava.boi.rent.repository.CityRegionRepository;
import studyjava.boi.rent.repository.StreetRepository;
import studyjava.boi.rent.service.*;

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
    @Autowired
    StreetService streetService;
    @Autowired
    StreetRepository streetRepository;
    @Autowired
    AdressService adressService;
    @Autowired
    AdressRepository adressRepository;
    @Autowired
    ApartmentService apartmentService;
    @Autowired
    ApartmentRepository apartmentRepository;


    @Bean
    public CommandLineRunner CommandLineRunnerBean() {

        return (args) -> {
//            System.out.println("In CommandLineRunnerImpl ");
//            System.out.println("Test Employee Spring ");
//            try {
////                cityRegionService = new CityRegionServiceImpl(cityRegionRepository);
////                List<CityRegion> cityRegions = cityRegionService.getAllCityRegion();
////                Thread.sleep(500);
////                System.out.println("\nCurrent state of City Region");
////                cityRegions.stream().forEach(System.out::println);
////                //Streets
////                streetService = new StreetServiceImpl(streetRepository);
////                List<Street> streets = streetService.getAllStreet();
////                Thread.sleep(500);
////                System.out.println("\nCurrent state of Street");
////                streets.stream().forEach(System.out::println);
//                //Adress
//                adressService = new AdressServiceImpl(adressRepository);
//                List<Adress> adresses = adressService.getAllAdress();
//                Thread.sleep(500);
//                System.out.println("\nCurrent state of Adress");
//                adresses.stream().forEach(System.out::println);
//                //Apartment
//                apartmentService = new ApartmentServiceImpl(apartmentRepository);
//                List<Apartment> apartments = apartmentService.getAllApartment();
//                Thread.sleep(500);
//                System.out.println("\nCurrent state of Apartment");
//                apartments.stream().forEach(System.out::println);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("END SHOW City Region and streets and adresses WITH Spring");
//
        };
   }
}