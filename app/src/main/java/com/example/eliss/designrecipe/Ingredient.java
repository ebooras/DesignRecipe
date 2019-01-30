package com.example.eliss.designrecipe;

/**
 * Created by eliss on 3/7/2018.
 */

public class Ingredient {
    private double amount;
    private String ingredient = "";

    public Ingredient(double amt, String ing){
        amount = amt;
        ingredient = ing;
    }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getIngredient() { return ingredient; }
    public void setIngredient(String ingredient) { this.ingredient = ingredient; }

}
