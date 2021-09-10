package com.example.Plant.Repository;

import com.example.Plant.Entities.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Integer> {
}
