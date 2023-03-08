package com.example.dinnerknight.repositories;

import com.example.dinnerknight.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findFoodById(long id);
    Food findFoodByName(String name);
    Food findFoodByIngredients(String ingredients);
    Food findFoodByInstructions(String instructions);
}
