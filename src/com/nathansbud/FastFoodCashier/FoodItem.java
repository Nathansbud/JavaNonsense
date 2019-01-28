package com.nathansbud.FastFoodCashier;

public class FoodItem {
    private static float FOOD_TAX = 1.15f;
    private static float DRINK_TAX = 1.2f;

    private String name;
    private boolean isFood;
    private float price;
//    private int quantity = 1;


    public FoodItem(String _name, boolean _isFood, float _price) {
        name = _name;
        isFood = _isFood;
        price = _price;
    }

    public float getPrice() {
        return price;
    }

    public float getCost() {
        return price * (isFood ? FOOD_TAX : DRINK_TAX);
    }

    public String getName() {
        return name;
    }
    public static float getDrinkTax() {
        return DRINK_TAX;
    }

    public static float getFoodTax() {
        return FOOD_TAX;
    }

    public boolean isFood() {
        return isFood;
    }

    public boolean isDrink() {
        return !isFood;
    }
}
