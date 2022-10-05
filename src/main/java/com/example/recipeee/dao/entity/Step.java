package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Step {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_recipe", referencedColumnName = "id", nullable = false)
    private Recipe recipeByIdRecipe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return id == step.id && Objects.equals(description, step.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public Recipe getRecipeByIdRecipe() {
        return recipeByIdRecipe;
    }

    public void setRecipeByIdRecipe(Recipe recipeByIdRecipe) {
        this.recipeByIdRecipe = recipeByIdRecipe;
    }
}
