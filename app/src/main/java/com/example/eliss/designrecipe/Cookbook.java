package com.example.eliss.designrecipe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by eliss on 3/6/2018.
 */

public class Cookbook {
    private String cookbookTitle = "";
    private String dateCreated = "";
    private ArrayList<Recipe> recipeList;

    private Date currentDate = new Date();
    private int month = Calendar.MONTH;
    private int day = Calendar.DAY_OF_MONTH;
    private int year = Calendar.YEAR;
    private int hour = Calendar.HOUR_OF_DAY;
    private int minute = Calendar.MINUTE;
    private int timeOfDay = Calendar.AM_PM;
    private int timezone = Calendar.ZONE_OFFSET;

    public Cookbook(String title){
        cookbookTitle = title;
        //dateCreated = hour + ":" + minute + " " + timezone + " on " + month + "/" + day + "/" + year;
        dateCreated = currentDate.toString();
        recipeList = new ArrayList<Recipe>();
    }

    public String getCookbookTitle() { return cookbookTitle; }
    public void setCookbookTitle(String cookbookTitle) { this.cookbookTitle = cookbookTitle; }
    public String getDateCreated() { return dateCreated; }
    public void setDateCreated(String dateCreated) { this.dateCreated = dateCreated; }
    public ArrayList<Recipe> getRecipeList() { return recipeList; }

    // implemented so that recipeList can stay private
    public void addNewRecipe(Recipe r){ recipeList.add(r); }

    public String toString(){
        return this.cookbookTitle;
    }

}
