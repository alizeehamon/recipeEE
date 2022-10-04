package com.example.recipeee.dao.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Step {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "stepByIdStep")
    private Collection<Recipe> recipesById;

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

        if (id != step.id) return false;
        if (description != null ? !description.equals(step.description) : step.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<Recipe> getRecipesById() {
        return recipesById;
    }

    public void setRecipesById(Collection<Recipe> recipesById) {
        this.recipesById = recipesById;
    }
}
