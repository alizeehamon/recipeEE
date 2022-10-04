package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "type_meal", schema = "recipeee")
public class TypeMeal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @OneToMany(mappedBy = "typeMealByIdTypeMeal")
    private Collection<Recipe> recipesById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeMeal typeMeal = (TypeMeal) o;
        return id == typeMeal.id && Objects.equals(name, typeMeal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<Recipe> getRecipesById() {
        return recipesById;
    }

    public void setRecipesById(Collection<Recipe> recipesById) {
        this.recipesById = recipesById;
    }
}
