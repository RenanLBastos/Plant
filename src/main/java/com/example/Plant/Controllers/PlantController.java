package com.example.Plant.Controllers;

import com.example.Plant.Entities.Plant;
import com.example.Plant.Repository.PlantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PlantController {

    private final PlantRepository plantRepository;

    public PlantController(final PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping("/plants")
    public Iterable<Plant> getAllPlants() {
        return this.plantRepository.findAll();
    }

    @GetMapping("/plants/{id}")
    public Optional<Plant> getPlantById(@PathVariable("id") Integer id) {
        return this.plantRepository.findById(id);
    }

    @PostMapping("/plants")
    public Plant createNewPlant(@RequestBody Plant plant) {
        Plant plant1 = new Plant();
        Iterable<Plant> plantList =  getAllPlants();
        for ( Plant plantObj : plantList) {
            if (plant.getName().equals(plantObj.getName())) {
                plant1.setName("Planta ja cadastrada");
                return plant1;
            }
        }
        return this.plantRepository.save(plant);
    }

    @PutMapping("/plants/{id}")
    public Plant updatePlant(
            @PathVariable("id") Integer id,
            @RequestBody Plant p
    ) {
        Optional<Plant> plantToUpdateOptional = this.plantRepository.findById(id);
        if (!plantToUpdateOptional.isPresent()) {
            return null;
        }
        Plant plantToUpdate = plantToUpdateOptional.get();
        if (p.getHasFruit() != null) {
            plantToUpdate.setHasFruit(p.getHasFruit());
        }
        if (p.getQuantity() != null) {
            plantToUpdate.setQuantity(p.getQuantity());
        }
        if (p.getName() != null) {
            plantToUpdate.setName(p.getName());
        }
        if (p.getWateringFrequency() != null) {
            plantToUpdate.setWateringFrequency(p.getWateringFrequency());
        }
        Plant updatedPlant = this.plantRepository.save(plantToUpdate);
        return updatedPlant;
    }

    @DeleteMapping("/plants/{id}")
    public Plant deletePlant(@PathVariable("id") Integer id) {
        Optional<Plant> plantToDeleteOptional = this.plantRepository.findById(id);
        if (!plantToDeleteOptional.isPresent()) {
            return null;
        }
        Plant plantToDelete = plantToDeleteOptional.get();
        this.plantRepository.delete(plantToDelete);
        return plantToDelete;
    }
}
