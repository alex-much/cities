package org.example.cities.repos;

import org.example.cities.domain.City;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//@Repository
@EnableAutoConfiguration
public interface CityRepo extends CrudRepository<City, Long> {
    List<City> findByName (String name);
}
