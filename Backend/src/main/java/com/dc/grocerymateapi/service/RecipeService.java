package com.dc.grocerymateapi.service;


import com.dc.grocerymateapi.entity.Recipe;
import com.dc.grocerymateapi.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> searchRecipes(String query) {
        return recipeRepository.findByNameContainingIgnoreCase(query);
    }

}
