package studyjava.boi.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import studyjava.boi.rent.entity.CityRegion;
import studyjava.boi.rent.service.CityRegionService;

import java.util.List;

@Controller
public class CityRegionController {

    private CityRegionService cityRegionService;

    public CityRegionController(CityRegionService cityRegionService) {
        this.cityRegionService = cityRegionService;
    }

    @GetMapping("/regions")
    public String listRegions(Model model){
        List<CityRegion> list = cityRegionService.getAllCityRegion();
        System.out.println(list);
        model.addAttribute("regions", list);
        return "regions";
    }

}
