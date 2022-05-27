package org.example.cities;

import org.example.cities.domain.City;
import org.example.cities.repos.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityRepo cityRepo;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
        Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/city")
    public String main(Model model) {
        Iterable<City> cities = cityRepo.findAll();
        model.addAttribute("cities", cities);
        return "city";
    }
    @PostMapping
    public String add(@RequestParam String name, @RequestParam Float latitude,
                      @RequestParam Float longitude, Model model) {
        City city = new City(name, latitude, longitude);
        cityRepo.save(city);
        Iterable<City> cities = cityRepo.findAll();
        model.addAttribute("cities", cities);
        return "main";
    }

    @PostMapping("/calc")
    public String calc(@RequestParam(value = "fromCity", required = false) String fromCity,
                       @RequestParam(value = "toCity", required = false) String toCity, Model model) {
        List<City> city1 = cityRepo.findByName(fromCity);
        Iterable<City> city2 = cityRepo.findByName(toCity);
        String str = city1.toString();
        String[] arr = str.split(" ");
        System.out.println(city1.toString());

        System.out.println(Float.parseFloat(arr[1]));
        model.addAttribute("city", city1);
        //model.addAttribute("city", city2);
        return "calc";
    }

  }
