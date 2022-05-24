package org.example.cities;

import org.example.cities.domain.City;
import org.example.cities.repos.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController{
    @Autowired
    private CityRepo cityRepo;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
        Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping()
    public String main(Model model) {
        Iterable<City> cities = cityRepo.findAll();
        model.addAttribute("cities", cities);
        return "main";
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

  }
