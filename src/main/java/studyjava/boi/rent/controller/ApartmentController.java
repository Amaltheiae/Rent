package studyjava.boi.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import studyjava.boi.rent.entity.Adress;
import studyjava.boi.rent.entity.Apartment;
import studyjava.boi.rent.entity.Street;
import studyjava.boi.rent.entity.TypeApartments;
import studyjava.boi.rent.repository.AdressRepository;
import studyjava.boi.rent.repository.ApartmentRepository;
import studyjava.boi.rent.service.AdressService;
import studyjava.boi.rent.service.ApartmentService;
import studyjava.boi.rent.service.StreetService;

import java.util.List;

@Controller
public class ApartmentController {

    private ApartmentService apartmentService;
    private StreetService streetService;
    private AdressService adressService;
    private final AdressRepository adressRepository;
    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentService apartmentService, StreetService streetService, AdressService adressService,
                               AdressRepository adressRepository,
                               ApartmentRepository apartmentRepository) {
        this.apartmentService = apartmentService;
        this.streetService = streetService;
        this.adressService = adressService;
        this.adressRepository = adressRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping("/apartments")
    public String listApartments(Model model) {
        List<Apartment> list = apartmentService.getAllApartment();
        // System.out.println(list);
        model.addAttribute("apartments", list);
        return "apartments";
    }

    //Для початкового виклику
    @GetMapping("/apartments/new")
    public String createNewApartment(Model model) {
        Apartment apartment = new Apartment();
        apartment.setId(0L);
        List<Adress> adresses = adressService.getAllAdress();
        Street chooseStreet = new Street(0l,"Choose street",null);
        Adress emptyAdress = new Adress(0l, chooseStreet, "", 0);
        apartment.setAdress(emptyAdress);
        adresses.add(0, emptyAdress);
        model.addAttribute("adresses", adresses);
        List<String> adresses_names = adresses.stream().map(a -> a.toString()).toList();
        System.out.println(adresses_names);
        model.addAttribute("adresses_names", adresses_names);
        apartment.setComment("Comment about flat!");
        //System.out.println(apartment);
        model.addAttribute("apartment", apartment);
        //Array of enum TypeApartments will sent to create_apartments page
        TypeApartments[] typeApartmentsNames = TypeApartments.values();
        model.addAttribute("apartmentstypes", typeApartmentsNames);
        return "create_apartments";
    }

    //Для виклику після додавання адреси
    @GetMapping("/apartments/new/{id_adress}")
    public String createNewApartment(@PathVariable("id_adress") Long idAdress, Model model) {
        //Створюється пустий apartment
        Apartment apartment = new Apartment();
        apartment.setId(0L); //Встановлюється 0, тому що по замовчуванню null
        // На вхід подається адрес, его устанавливаем адресом апартаментов
        Adress adress = adressRepository.findById(idAdress).get();
        apartment.setAdress(adress);
        apartment.setComment("Comment about flat!");
        //System.out.println(apartment);
        model.addAttribute("apartment", apartment);
        //Получаем список адресов
        List<Adress> adresses = adressService.getAllAdress();
        model.addAttribute("adresses", adresses);
        //Формується перелік адресов для відображення у спадаючому списку
        List<String> adresses_names = adresses.stream().map(a -> a.toString()).toList();
        model.addAttribute("adresses_names", adresses_names);
        //Array of enum TypeApartments will sent to create_apartments page
        TypeApartments[] typeApartmentsNames = TypeApartments.values();
        model.addAttribute("apartmentstypes", typeApartmentsNames);
        return "create_apartments";
    }

    //Для виклику оновлення ціни
    @GetMapping("/apartments/edit/{id}")
    public String updatePriceApartment(@PathVariable("id") Long id_apartment, Model model) {
        Apartment apartment = apartmentService.getApartmentById(id_apartment);
        model.addAttribute("apartment", apartment);
        System.out.println(apartment);
        List<Adress> adresses = adressService.getAllAdress();
        model.addAttribute("adresses", adresses);
        List<String> adresses_names = adresses.stream().map(a -> a.toString()).toList();
        model.addAttribute("adresses_names", adresses_names);
        model.addAttribute("apartment", apartment);
        //Array of enum TypeApartments will sent to create_apartments page
        TypeApartments[] typeApartmentsNames = TypeApartments.values();
        model.addAttribute("apartmentstypes", typeApartmentsNames);
        return "update_price";
    }

    @PostMapping("/apartments")
    public String saveApartment(@ModelAttribute("apartment") Apartment apartment) {
        // ЗБЕРЕГТИ
        System.out.println(apartment);
        apartmentService.saveApartment(apartment);
        return "redirect:/apartments";
    }

    @GetMapping("/add_adress")
    public String addAdress(Model model) {
        Adress adress = new Adress(0L, null, "", 1);
        List<Street> streets = streetService.getAllStreet();
        model.addAttribute("streets", streets);
        model.addAttribute("adress", adress);
        return "createadress";
    }

    @PostMapping("/save_adress")
    public String saveAdress(@ModelAttribute("adress") Adress adress, Model model) {
        Adress adressInDB = adressService.findAdress(adress);
        if (adressInDB == null) {
            adressService.saveAdress(adress);
            adressInDB = adressService.findAdress(adress);
        }
        return "redirect:/apartments/new/" + adressInDB.getId();
    }
    @GetMapping("/apartments/{id}")
    public String deleteById(@PathVariable("id") Long id_apartment, Model model){
        apartmentService.deleteById(id_apartment);
        return "redirect:/apartments";
    }

}
