package com.dc.grocerymateapi.repository;

import com.dc.grocerymateapi.entity.Ingredient;
import com.dc.grocerymateapi.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameContainingIgnoreCase(String name);
}
