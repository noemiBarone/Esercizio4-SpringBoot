package controller.dao;
 import service.Meal;


import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.*;

@Repository
public class MealDao {
    private List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal){
        this.meals.add(meal);
    }

    public void deleteMeal (String mealName){
        this.meals.removeIf(meal -> meal.getNameMeal().equals(mealName));
    }

    public void updateMeal(Meal meal){
        this.meals.removeIf(meal1 -> meal.getNameMeal().equals(meal.getNameMeal()));
        this.meals.add(meal);
    }

    public List<Meal> getMeals(){
        return this.meals;
    }
}
