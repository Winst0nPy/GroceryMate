package com.dc.grocerymateapi.controller;

import com.dc.grocerymateapi.dto.response.RecipeDTOres;
import com.dc.grocerymateapi.entity.Recipe;
import com.dc.grocerymateapi.repository.RecipeRepository;
import com.dc.grocerymateapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeDTOres> createRecipe(@RequestBody Recipe recipe) {
        RecipeDTOres createdRecipe = recipeService.createRecipe(recipe);
        return ResponseEntity.created(URI.create("/api/recipes/" + createdRecipe.getId())).body(createdRecipe);
    }


}

