package com.example.backend.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.example.entity.Food;
import com.example.backend.example.repository.FoodRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodRepository repository;

    public FoodController(FoodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public Food createFood(@Valid @RequestBody Food food) {
        return repository.save(food);
    }

    @GetMapping("/{id}")
    public Food getFoodbyId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Food not found"));
    }

    @PutMapping("/update/{id}")
    public Food updateFood(@PathVariable Long id, @Valid @RequestBody Food updatedFood) {
        return repository.findById(id)
                .map(food -> {
                    food.setName(updatedFood.getName());
                    food.setHealthy(updatedFood.isHealthy());
                    return repository.save(food);
                })
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFood(@PathVariable Long id){
        repository.deleteById(id);
    }

}