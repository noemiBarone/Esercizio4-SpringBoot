package service;

public class Meal {
    private String nameMeal;
    private String description;
    private double price;

    public Meal(String nameMeal, String description, double price) {
        this.nameMeal = nameMeal;
        this.description = description;
        this.price = price;
    }

    public String getNameMeal() {
        return nameMeal;
    }

    public void setNameMeal(String nameMeal) {
        this.nameMeal = nameMeal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
