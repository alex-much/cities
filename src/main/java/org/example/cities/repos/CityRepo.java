package org.example.cities.repos;

import org.example.cities.domain.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City, Long> {
}
