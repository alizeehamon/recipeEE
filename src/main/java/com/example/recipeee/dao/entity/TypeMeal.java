package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "type_meal", schema = "recipeee", catalog = "")
public class TypeMeal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
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

        if (id != typeMeal.id) return false;
        if (name != null ? !name.equals(typeMeal.name) : typeMeal.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Recipe> getRecipesById() {
        return recipesById;
    }

    public void setRecipesById(Collection<Recipe> recipesById) {
        this.recipesById = recipesById;
    }
}
