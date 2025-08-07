package com.example.backend.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.example.entity.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{
    
}
