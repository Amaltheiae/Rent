package studyjava.boi.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import studyjava.boi.rent.entity.Apartment;
import studyjava.boi.rent.entity.CityRegion;
import studyjava.boi.rent.service.ApartmentService;
import studyjava.boi.rent.service.CityRegionService;

import java.util.List;

@Controller
public class ApartmentController {

    private ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/apartments")
    public String listApartments(Model model) {
        List<Apartment> list = apartmentService.getAllApartment();
        System.out.println(list);
        model.addAttribute("apartments", list);
        return "apartment";
    }

    @GetMapping("/apartments/new")
    public String createNewApartment(Model model) {
        Apartment apartment = new Apartment();
        apartment.setFloorNumber(1);
        System.out.println(apartment);
        model.addAttribute("apartment", apartment);
        return "createapartment";
    }
    @PostMapping ("/apartments")
    public String saveApartment (@ModelAttribute ("apartment") Apartment apartment){
        // ЗБЕРЕГТИ
        return "redirect:/apartments";
    }


}
