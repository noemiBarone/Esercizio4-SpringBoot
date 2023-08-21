package service;

import controller.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;

    @Autowired
    public MealService (MealDao mealDao){
        this.mealDao = mealDao;
    }
    public String getMeal(){
        return "Meal";
    }

    public void addMeal(Meal meal){
        if(meal != null) throw  new IllegalArgumentException("Meal cannot be null!");
        if(meal.getNameMeal()== null || meal.getNameMeal().isEmpty()) throw  new IllegalArgumentException("Meal name cannot be null");
        if(meal.getDescription()== null || meal.getDescription().isEmpty()) throw  new IllegalArgumentException("Meal description cannot be null");
        if(meal.getPrice() <= 0) throw  new IllegalArgumentException("Meal price cannot be less than or equal to 0!");
        if(meal.getPrice() > 100) throw  new IllegalArgumentException("Meal price cannot be more than 100");
        mealDao.addMeal(meal);
    }

    public void deleteMeal (String mealName){
        mealDao.deleteMeal(mealName);
    }


    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeals(){
        return mealDao.getMeals();
    }
}
