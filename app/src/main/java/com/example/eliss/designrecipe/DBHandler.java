package com.example.eliss.designrecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Pattern;

/**
 * Created by eliss on 3/2/2018.
 */

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 14;
    private static final String DATABASE_NAME = "designRecipeDB.db";

    private static final String TABLE_RECIPES = "Recipes";
    private static final String COLUMN_RECIPE_ID = "ID";
    private static final String COLUMN_RECIPETITLE = "recipe_title";
    private static final String COLUMN_CURRENT_VERSION = "current_version";
    private static final String COLUMN_VERSION_HISTORY = "version_history";
    private static final String COLUMN_COOKBOOK = "cookbook";
    private static final String COLUMN_INGREDIENT_AMOUNTS = "ingredient_amounts";
    private static final String COLUMN_INGREDIENTS = "ingredients";
    private static final String COLUMN_STEPS = "method";

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_RECIPE_TABLE = "CREATE TABLE " +
                TABLE_RECIPES + " (" +
                COLUMN_RECIPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_RECIPETITLE + " TEXT, " +
                COLUMN_CURRENT_VERSION + " FLOAT, " +
                COLUMN_VERSION_HISTORY + " TEXT, " +
                COLUMN_COOKBOOK + " TEXT, " +
                COLUMN_INGREDIENT_AMOUNTS + " TEXT, " +
                COLUMN_INGREDIENTS + " TEXT, " +
                COLUMN_STEPS + " TEXT)";

        // execute SQL command, no return value
        db.execSQL(CREATE_RECIPE_TABLE);

        // prepopulate database
        /*
            "INSERT INTO " + TABLE_RECIPES + " ("
                + COLUMN_RECIPETITLE + ", "
                + COLUMN_CURRENT_VERSION + ", "
                + COLUMN_VERSION_HISTORY + ", "
                + COLUMN_COOKBOOK + ", "
                + COLUMN_INGREDIENT_AMOUNTS + ", "
                + COLUMN_INGREDIENTS + ", "
                + COLUMN_STEPS
                + ") VALUES ('recipeTitle', 'currentVersion', 'version|history|', 'cookbook', " +
                "'ingredient|amounts|', 'ingre|dients|', 'method|steps|')";
         */
        String ENTRY_1 = "INSERT INTO " + TABLE_RECIPES + " ("
                + COLUMN_RECIPETITLE + ", "
                + COLUMN_CURRENT_VERSION + ", "
                + COLUMN_VERSION_HISTORY + ", "
                + COLUMN_COOKBOOK + ", "
                + COLUMN_INGREDIENT_AMOUNTS + ", "
                + COLUMN_INGREDIENTS + ", "
                + COLUMN_STEPS
                + ") VALUES ('test 5', '0.1', 'null', 'tests', " +
                "'5|4.5|3.5|1.5|4|', 'first|second|third|fourth|fifth|', 'one step|two steps|')";
        db.execSQL(ENTRY_1);

        String entry2 = "INSERT INTO " + TABLE_RECIPES + " ("
                + COLUMN_RECIPETITLE + ", "
                + COLUMN_CURRENT_VERSION + ", "
                + COLUMN_VERSION_HISTORY + ", "
                + COLUMN_COOKBOOK + ", "
                + COLUMN_INGREDIENT_AMOUNTS + ", "
                + COLUMN_INGREDIENTS + ", "
                + COLUMN_STEPS
                + ") VALUES ('Garlicky Chickpeas', '0.1', 'null', 'Sides', " +
                "'15|3|1|2|', 'oz can chickpeas, drained|cloves garlic, minced|lemon, juiced|T parsley|', "
                + "'Heat 1 T olive oil in a medium pan over medium heat|Add garlic and cook until fragrant, about 30 seconds|"
                + "Add chickpeas and saute until warmed through, about 5-7 minutes|Turn off the heat and add lemon juice and parsley|')";
        db.execSQL(entry2);

        String entry3 = "INSERT INTO " + TABLE_RECIPES + " ("
                + COLUMN_RECIPETITLE + ", "
                + COLUMN_CURRENT_VERSION + ", "
                + COLUMN_VERSION_HISTORY + ", "
                + COLUMN_COOKBOOK + ", "
                + COLUMN_INGREDIENT_AMOUNTS + ", "
                + COLUMN_INGREDIENTS + ", "
                + COLUMN_STEPS
                + ") VALUES ('Garlicky Chickpeas', '0.2', '0.1|', 'Sides', " +
                "'15|3|1|2|1.5|', 'oz can chickpeas, drained|cloves garlic, minced|lemon, juiced|T parsley|cup vegetable broth|', "
                + "'Heat 1 T olive oil in a medium pan over medium heat|Add garlic and cook until fragrant, about 30 seconds|"
                + "Add chickpeas and broth, saute until warmed through, about 5-7 minutes|Turn off the heat and add lemon juice and parsley|')";
        db.execSQL(entry3);

        String entry4 = "INSERT INTO " + TABLE_RECIPES + " ("
                + COLUMN_RECIPETITLE + ", "
                + COLUMN_CURRENT_VERSION + ", "
                + COLUMN_VERSION_HISTORY + ", "
                + COLUMN_COOKBOOK + ", "
                + COLUMN_INGREDIENT_AMOUNTS + ", "
                + COLUMN_INGREDIENTS + ", "
                + COLUMN_STEPS
                + ") VALUES ('Tofu Stir Fry', '0.1', 'null', 'Entrees', " +
                "'15|1|1|2.5|1.5|0.25|1|', 'oz block extra-firm tofu|medium head broccoli, chopped into bite-size bits|white or yellow onion, sliced thin|"
                + "T Stir Fry Sauce|T sambal (chili garlic paste)|cup water|T fresh cilantro, chopped (optional)|', "
                + "'Heat 1 T neutral oil in a medium pan over medium-high heat|Add onion and cook for about 4-5 minutes until softened|"
                + "Add broccoli and tofu, saute until warmed through, about 5-7 minutes|Take off heat, add stir fry sauce, water, and sambal|"
                + "Put back on heat and cook until broccoli is softened and sauce has thickened, about 10 minutes|Turn off heat, add cilantro, and serve|')";
        db.execSQL(entry4);

        String entry5 = "INSERT INTO " + TABLE_RECIPES + " ("
                + COLUMN_RECIPETITLE + ", "
                + COLUMN_CURRENT_VERSION + ", "
                + COLUMN_VERSION_HISTORY + ", "
                + COLUMN_COOKBOOK + ", "
                + COLUMN_INGREDIENT_AMOUNTS + ", "
                + COLUMN_INGREDIENTS + ", "
                + COLUMN_STEPS
                + ") VALUES ('Tofu Stir Fry', '0.2', '0.1|', 'Entrees', " +
                "'15|1|1|2.5|1.5|0.25|', 'oz block extra-firm tofu|medium head broccoli, chopped into bite-size bits|white or yellow onion, sliced thin|"
                + "T Stir Fry Sauce|T sambal (chili garlic paste)|cup water|', "
                + "'Heat 1 T neutral oil in a medium pan over medium-high heat|Add onion and cook for about 4-5 minutes until softened|"
                + "Add broccoli and tofu, saute until warmed through, about 5-7 minutes|Take off heat, add stir fry sauce, water, and sambal|"
                + "Put back on heat and cook until broccoli is softened and sauce has thickened, about 10 minutes|')";
        db.execSQL(entry5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
        onCreate(db);
    }

    /*
        Adds data from a newly-created (first version) Recipe into the database
     */
    public void addRecipe(Recipe r){
        // prepare values for new entry to a Cookbook
        ContentValues entryValues = new ContentValues();
        entryValues.put(COLUMN_RECIPETITLE, r.getRecipeTitle());
        entryValues.put(COLUMN_CURRENT_VERSION, r.getVersion());
        String vHist = "null";
        entryValues.put(COLUMN_VERSION_HISTORY, vHist);
        entryValues.put(COLUMN_COOKBOOK, (r.getCookbook()).getCookbookTitle());

        // store ingredient amounts as String representation in database
        // ex. "1.5|2.0|0.5|"
        String allAmts = "";
        ArrayList<Double> rAmts = r.getAllIngredientAmts();
        for(Double f : rAmts) allAmts += (f.doubleValue() + "|");
        entryValues.put(COLUMN_INGREDIENT_AMOUNTS, allAmts);

        // store ingredients as String representation in database
        // ex. "T butter|cups flour|t paprika|"
        String allIngrs = "";
        ArrayList<String> rIngr = r.getAllIngredients();
        for(String s : rIngr) allIngrs += (s + "|");
        entryValues.put(COLUMN_INGREDIENTS, allIngrs);

        // store steps as String representation in database
        // ex. "Preheat oven to 450 degrees F|Mix wet ingredients into dry ingredients|"
        String allSteps = "";
        ArrayList<String> rSteps = r.getAllSteps();
        for(String step : rSteps) allSteps += (step + "|");
        entryValues.put(COLUMN_STEPS, allSteps);

        SQLiteDatabase db = this.getWritableDatabase();  // opens DB
        db.insert(TABLE_RECIPES, null, entryValues);
        db.close();
    }

    /*
        When a new version of a Recipe is created, this will add it to the version history of that Recipe
        and create a new entry in the database
     */
    public boolean updateRecipe(Recipe r){
        // we will need the most recent version of this Recipe in the database
        // so that we can update the version history
        Recipe toUpdate = this.findRecipe(r.getRecipeTitle());

        boolean updated = false;

        // prepare values for new entry into database
        ContentValues updatedValues = new ContentValues();
        updatedValues.put(COLUMN_RECIPETITLE, r.getRecipeTitle());

        double previousVersion = toUpdate.getVersion();
        String query =  "SELECT * FROM " + TABLE_RECIPES + " WHERE "
                + COLUMN_RECIPETITLE + " = \"" + r.getRecipeTitle() + "\" AND ID = (SELECT MAX(ID) FROM " + TABLE_RECIPES + ")";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            // get the version history for this recipe and add current version
            // before updating to newest version
            String vHist = cursor.getString(3);
            // DEBUGGING
            System.out.println("VERSION HISTORY BEFORE UPDATE: " + vHist);
            if(vHist.equals("null")) vHist = previousVersion + "|";
            else vHist += (previousVersion + "|");
            // DEBUGGING
            System.out.println("UPDATED VERSION HISTORY: " + vHist);
            updatedValues.put(COLUMN_VERSION_HISTORY, vHist);
            updated = true;
        }

        updatedValues.put(COLUMN_CURRENT_VERSION, r.getVersion());
        updatedValues.put(COLUMN_COOKBOOK, (r.getCookbook()).getCookbookTitle());

        // store ingredient amounts as String representation in database
        // ex. "1.5|2.0|0.5|"
        String allAmts = "";
        ArrayList<Double> rAmts = r.getAllIngredientAmts();
        for(Double f : rAmts) allAmts += (f.doubleValue() + "|");
        updatedValues.put(COLUMN_INGREDIENT_AMOUNTS, allAmts);

        // store ingredients as String representation in database
        // ex. "T butter|cups flour|t paprika|"
        String allIngrs = "";
        ArrayList<String> rIngr = r.getAllIngredients();
        for(String s : rIngr) allIngrs += (s + "|");
        updatedValues.put(COLUMN_INGREDIENTS, allIngrs);

        // store steps as String representation in database
        // ex. "Preheat oven to 450 degrees F|Mix wet ingredients into dry ingredients|"
        String allSteps = "";
        ArrayList<String> rSteps = r.getAllSteps();
        for(String step : rSteps) allSteps += (step + "|");
        updatedValues.put(COLUMN_STEPS, allSteps);

        db.insert(TABLE_RECIPES, null, updatedValues);
        db.close();

        return updated;
    }

    /*
        Given a Recipe title, finds and returns Recipe if it exists in the database
     */
    public Recipe findRecipe(String recipeTitle){
        String query =  "SELECT * FROM " + TABLE_RECIPES + " WHERE "
                + COLUMN_RECIPETITLE + " = \"" + recipeTitle + "\" AND ID = (SELECT MAX(ID) FROM " + TABLE_RECIPES + ")";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Recipe recipe = null;

        // if at least one row is returned, point to the first entry and extract data
        if(cursor.moveToFirst()){
            // recipe ID is in column 0
            String tempRT = cursor.getString(1);
            double tempV = cursor.getDouble(2);
            String tempVH = cursor.getString(3);  // will likely not use version history
            String tempC = cursor.getString(4);
            String tempIA = cursor.getString(5);
            String tempII = cursor.getString(6);
            String tempM = cursor.getString(7);

            // declare new Cookbook object to return in Recipe
            Cookbook c = new Cookbook(tempC);

            // convert tempIA/tempII (String representations of ingredients + amounts in database) to ArrayList<Ingredient>
            ArrayList<Ingredient> tempIngrs = new ArrayList<Ingredient>();

            // grab amounts from database, put in easier-to-work-with form
            String[] amtArray = tempIA.split(Pattern.quote("|"));
            ArrayList<Double> amtArrayList = new ArrayList<Double>();
            for(int i = 0; i < amtArray.length; i++){
                if(!amtArray[i].equals("")) amtArrayList.add(Double.parseDouble((amtArray[i]).trim()));
            }

            // grab ingredients from database, put in easier-to-work-with form
            String[] ingArray = tempII.split(Pattern.quote("|"));
            ArrayList<String> ingArrayList = new ArrayList<String>();
            for(int i = 0; i < ingArray.length; i++){
                if(!ingArray[i].equals("")) ingArrayList.add(ingArray[i]);
            }

            // create new ArrayList of Ingredients to add to new Recipe
            for(int i = 0; i < amtArrayList.size(); i++){
                Ingredient ingredient = new Ingredient(amtArrayList.get(i),ingArrayList.get(i));
                tempIngrs.add(ingredient);
            }

            // convert tempM (String representation of method steps) to Hashtable<Integer, String>
            Hashtable<Integer, String> tempMethod = new Hashtable<Integer, String>();

            // grab method steps from database, put in easier-to-work-with form
            String[] stepArray = tempM.split(Pattern.quote("|"));
            ArrayList<String> stepArrayList = new ArrayList<String>();
            for(int i = 0; i < stepArray.length; i++) {
                if(!stepArray[i].equals("")) stepArrayList.add(stepArray[i]);
            }

            // add method steps to Hashtable to add to new Recipe
            int stepNum = 1;
            for(String s : stepArrayList) tempMethod.put(Integer.valueOf(stepNum++), s);

            cursor.close();
            recipe = new Recipe(tempRT, tempV, c, tempIngrs, tempMethod);
        }

        db.close();
        return recipe;
    }

    /*
        Given a Recipe title, finds and deletes Recipe from database.
        Returns boolean indicating whether Recipe was successfully deleted or not
     */
    public boolean deleteRecipe(String recipeTitle){
        boolean result = false;

        String query = "SELECT * FROM " + TABLE_RECIPES + " WHERE " +
                COLUMN_RECIPETITLE + " = \"" + recipeTitle + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // if at least one row is returned, get recipe title of first one and delete it
        if(cursor.moveToFirst()){
            String tempRT = cursor.getString(1);
            db.delete(TABLE_RECIPES, COLUMN_RECIPETITLE + "= ?", new String[]{tempRT});
            cursor.close();
            result = true;
        }

        db.close();
        return result;
    }

    /*
        Returns the most recently edited Recipe in the database
     */
    public Recipe getMostRecent(){
        Recipe toReturn = null;

        String query = "SELECT * FROM " + TABLE_RECIPES +
                " WHERE ID = (SELECT MAX(ID) FROM " + TABLE_RECIPES + ")";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            String title = cursor.getString(1);
            toReturn = this.findRecipe(title);
        }

        return toReturn;
    }

    /*
        Used for context menu in Search
        Populates context menu with previous versions of the selected Recipe
     */
    public Recipe getRecipeVersion(String recipeTitle, int pos){
        String recVersion = "-1";
        Recipe recipe = null;

        String query =  "SELECT * FROM " + TABLE_RECIPES + " WHERE "
                + COLUMN_RECIPETITLE + " = \"" + recipeTitle + "\" AND ID = (SELECT MAX(ID) FROM " + TABLE_RECIPES + ")";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            String vh = cursor.getString(3);
            String[] versionHistory = vh.split(Pattern.quote("|"));

            if (pos < versionHistory.length && versionHistory[pos] != null){
                recVersion = versionHistory[pos];
                String query2 = "SELECT * FROM " + TABLE_RECIPES + " WHERE "
                        + COLUMN_RECIPETITLE + " = \"" + recipeTitle + "\" AND "
                        + COLUMN_CURRENT_VERSION + " = \"" + recVersion + "\"";  // current_version stored as String
                Cursor cursor2 = db.rawQuery(query2, null);
                if(cursor2.moveToFirst()){
                    // recipe ID is in column 0
                    String tempRT = cursor.getString(1);
                    double tempV = cursor.getDouble(2);
                    String tempVH = cursor.getString(3);  // will likely not use version history
                    String tempC = cursor.getString(4);
                    String tempIA = cursor.getString(5);
                    String tempII = cursor.getString(6);
                    String tempM = cursor.getString(7);

                    // declare new Cookbook object to return in Recipe
                    Cookbook c = new Cookbook(tempC);

                    // convert tempIA/tempII (String representations of ingredients + amounts in database) to ArrayList<Ingredient>
                    ArrayList<Ingredient> tempIngrs = new ArrayList<Ingredient>();

                    // grab amounts from database, put in easier-to-work-with form
                    String[] amtArray = tempIA.split(Pattern.quote("|"));
                    ArrayList<Double> amtArrayList = new ArrayList<Double>();
                    for(int i = 0; i < amtArray.length; i++){
                        if(!amtArray[i].equals("")) amtArrayList.add(Double.parseDouble((amtArray[i]).trim()));
                    }

                    // grab ingredients from database, put in easier-to-work-with form
                    String[] ingArray = tempII.split(Pattern.quote("|"));
                    ArrayList<String> ingArrayList = new ArrayList<String>();
                    for(int i = 0; i < ingArray.length; i++){
                        if(!ingArray[i].equals("")) ingArrayList.add(ingArray[i]);
                    }

                    // create new ArrayList of Ingredients to add to new Recipe
                    for(int i = 0; i < amtArrayList.size(); i++){
                        Ingredient ingredient = new Ingredient(amtArrayList.get(i),ingArrayList.get(i));
                        tempIngrs.add(ingredient);
                    }

                    // convert tempM (String representation of method steps) to Hashtable<Integer, String>
                    Hashtable<Integer, String> tempMethod = new Hashtable<Integer, String>();

                    // grab method steps from database, put in easier-to-work-with form
                    String[] stepArray = tempM.split(Pattern.quote("|"));
                    ArrayList<String> stepArrayList = new ArrayList<String>();
                    for(int i = 0; i < stepArray.length; i++) {
                        if(!stepArray[i].equals("")) stepArrayList.add(stepArray[i]);
                    }

                    // add method steps to Hashtable to add to new Recipe
                    int stepNum = 1;
                    for(String s : stepArrayList) tempMethod.put(Integer.valueOf(stepNum++), s);

                    cursor.close();
                    recipe = new Recipe(tempRT, tempV, c, tempIngrs, tempMethod);
                }
            }

        }

        db.close();
        return recipe;
    }

}