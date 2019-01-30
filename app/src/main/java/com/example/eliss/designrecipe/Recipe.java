package com.example.eliss.designrecipe;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by eliss on 3/2/2018.
 */

public class Recipe {
    private String recipeTitle;
    private double version;
    private Cookbook cookbook;
    private ArrayList<Ingredient> ingredients;
    private Hashtable<Integer, String> method;

    public Recipe(String recipeTitle, double version, Cookbook cookbook,
                  ArrayList<Ingredient> ingredients, Hashtable<Integer, String> method) {
        this.recipeTitle = recipeTitle;
        if(version > 0) this.version = version;
        else this.version = -1;
        this.cookbook = cookbook;
        this.ingredients = ingredients;
        this.method = method;
    }

    public String getRecipeTitle() { return recipeTitle; }
    public void setRecipeTitle(String recipeTitle) { this.recipeTitle = recipeTitle; }

    public double getVersion() { return version; }
    public void setVersion(double version) { this.version = version; }

    public Cookbook getCookbook() { return cookbook; }
    public void setCookbook(Cookbook cookbook) { this.cookbook = cookbook; }

    /*
        returns an Ingredient object that corresponds to the body (String representation) of an ingredient
     */
    public Ingredient getIngredient(String ingr) {
        Ingredient temp = null;
        for(Ingredient i : ingredients){
            if((i.getIngredient()).equals(ingr)) temp = i;
        }
        return temp;
    }

    /*
        takes the old amount/ingredient pair and replaces them with a new amount/ingredient pair
     */
    public void setIngredient(double oldAmt, String oldIngr, double newAmt, String newIngr) {
        Ingredient replacement = new Ingredient(newAmt, newIngr);
        int index = ingredients.indexOf(new Ingredient(oldAmt, oldIngr));
        if(index!=-1) ingredients.set(index, replacement);
    }

    /*
        returns separate ArrayList of double objects representing ingredient amounts
     */
    public ArrayList<Double> getAllIngredientAmts(){
        ArrayList<Double> allAmts = new ArrayList<Double>();
        for(Ingredient i : ingredients) allAmts.add(Double.valueOf(i.getAmount()));
        return allAmts;
    }

    /*
        returns separate ArrayList of Strings representing ingredient bodies
     */
    public ArrayList<String> getAllIngredients() {
        ArrayList<String> allIngr = new ArrayList<String>();
        for(Ingredient i : ingredients) allIngr.add(i.getIngredient());
        return allIngr;
    }

    /*
        returns the step in the method that corresponds to the Integer (i.e. the step's order in the method)
     */
    public String getStep(Integer step) {
        String returnedStep = "";
        if(method.containsKey(step)) returnedStep = method.get(step);
        return returnedStep;
    }

    /*
        updates the body of the given step
     */
    public void setStep(Integer step, String newStep) {
        if(method.containsKey(step)) method.put(step, newStep);
    }

    /*
        returns an ArrayList of Strings representing all steps in the method (without their corresponding numbers)
     */
    public ArrayList<String> getAllSteps(){
        ArrayList<String> allSteps = new ArrayList<String>();
        for(Map.Entry<Integer, String> step : method.entrySet()) allSteps.add(step.getValue());
        return allSteps;
    }

    public String toString(){
        String str = "";
        str += this.recipeTitle + ": Version " + this.version + " in " + this.cookbook + "\n\tIngredients:\n";
        for(Ingredient i : this.ingredients){
            double amt = i.getAmount();
            String ing = i.getIngredient();
            str += amt + " " + ing + "\n";
        }
        str += "\tMethod:\n";
        for(Map.Entry<Integer, String> step : method.entrySet()){
            int stepNum = (step.getKey()).intValue();
            str += stepNum + ") " + step.getValue() + "\n";
        }

        return str;
    }
}
