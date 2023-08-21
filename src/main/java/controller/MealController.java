package controller;

import service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Meal;
import service.MealService;

import java.util.*;

@RestController
public class MealController {
    private MealService mealService;
    @Autowired
    public MealController (MealService mealService){
        this.mealService = mealService;
    }
    private List<Meal> meals = new ArrayList<>();

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping (value = "/put/meals")
    public ResponseEntity<String> putMeal (@RequestBody Meal meal){
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal addes!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping (value = "/delete/meal/{mealName}")
    public ResponseEntity<String> deleteMeal (@PathVariable String mealName){
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted!");
    }

    @PostMapping(value = "/post/replace-meal")
    public ResponseEntity<String> postMeal (@RequestBody Meal meal){
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Meal updated!");
    }

}
