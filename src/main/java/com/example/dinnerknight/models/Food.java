package com.example.dinnerknight.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private List<String> ingredients;
    @Column(nullable = false)
    private String instructions;

    public Food(){

    }

    public Food(Food copy) {
        this.id = copy.id;
        this.name = copy.name;
        this.ingredients = copy.ingredients;
        this.instructions = copy.instructions;

    }

    public Food(Long id, String name, List<String> ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}


