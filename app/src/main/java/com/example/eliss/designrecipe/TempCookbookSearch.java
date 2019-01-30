package com.example.eliss.designrecipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TempCookbookSearch extends AppCompatActivity {
    private static final int recipeViewFlag = Intent.FLAG_ACTIVITY_CLEAR_TASK;  // will clear last Recipe viewed

    private EditText searchBar;
    private Button findRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_cookbook_search);

        searchBar = (EditText) findViewById(R.id.recipeTitleSearchEditText);
        findRecipeButton = (Button) findViewById(R.id.findRecipeButton);
        registerForContextMenu(findRecipeButton);

    }

    /*
        Creates floating context menu that appears when Find Recipe button is held down
        Taken from https://developer.android.com/guide/topics/ui/menus.html#FloatingContextMenu
      */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    /*
        When a menu item is selected, a Toast pops up (temporarily)
        Taken from https://developer.android.com/guide/topics/ui/menus.html#FloatingContextMenu
      */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String title = (searchBar.getText().toString()).trim();
        DBHandler dbHandler = new DBHandler(this);

        switch (item.getItemId()) {
            case R.id.version1:
                Recipe vers1 = dbHandler.getRecipeVersion(title, 0);
                if(vers1!=null) {
                    // DEBUGGING
                    System.out.println(vers1.toString());

                    Toast.makeText(this, vers1.getVersion() + " selected", Toast.LENGTH_SHORT).show();
                    sendRecipeViewIntent(vers1);
                    searchBar.setText("");
                }
                else Toast.makeText(this, "recipe could not be selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.version2:
                Recipe vers2 = dbHandler.getRecipeVersion(title, 1);
                if(vers2!=null) {
                    // DEBUGGING
                    System.out.println(vers2.toString());

                    Toast.makeText(this, vers2.getVersion() + " selected", Toast.LENGTH_SHORT).show();
                    sendRecipeViewIntent(vers2);
                    searchBar.setText("");
                }
                else Toast.makeText(this, "recipe could not be selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.version3:
                Recipe vers3 = dbHandler.getRecipeVersion(title, 2);
                if(vers3!=null) {
                    // DEBUGGING
                    System.out.println(vers3.toString());

                    Toast.makeText(this, vers3.getVersion() + " selected", Toast.LENGTH_SHORT).show();
                    sendRecipeViewIntent(vers3);
                    searchBar.setText("");
                }
                else Toast.makeText(this, "recipe could not be selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    /*
        When a Recipe title is entered in the search bar, this method searches the database
        for a Recipe with the same title.
        If this Recipe is found, it will be displayed on a new Recipe View page.
     */
    public void findRecipeClick(View v){
        String title = (searchBar.getText().toString()).trim();

        DBHandler dbHandler = new DBHandler(this);
        Recipe recipe = dbHandler.findRecipe(title);

        if(recipe!=null){
            // DEBUGGING
            System.out.println(recipe.toString());

            sendRecipeViewIntent(recipe);
        } else {
            Toast.makeText(this, "Recipe not in database.", Toast.LENGTH_LONG).show();
        }

        searchBar.setText("");
    }

    /*
        When a Recipe title is entered in the search bar, this method will find that Recipe in the database
        and delete it from the database when found.
        A message will be displayed in a TextView to indicate whether the Recipe was successfully deleted or not.
     */
    public void deleteRecipeClick(View v){
        String title = (searchBar.getText().toString()).trim();

        DBHandler dbHandler = new DBHandler(this);
        Recipe recipe = dbHandler.findRecipe(title);
        String cookbookTitle = "";
        if(recipe!=null) cookbookTitle = (recipe.getCookbook()).getCookbookTitle();

        boolean result = dbHandler.deleteRecipe(title);
        if(result){
            Toast.makeText(this, "Recipe has been deleted from the " + cookbookTitle + " cookbook.", Toast.LENGTH_LONG).show();
            searchBar.setText("");
        } else {
            Toast.makeText(this, "No matching recipe found...", Toast.LENGTH_LONG).show();
            searchBar.setText("");
        }
    }

    /*
        When user exits and returns to this page, it will completely reset
     */
    @Override
    public void onResume(){
        super.onResume();
    }

    /*
        Since the act of sending data to a RecipeView is repeated so often,
        the bundling of intent data and starting the new intent is its own method
     */
    private void sendRecipeViewIntent(Recipe rec){
        Intent myIntent = new Intent(this, RecipeViewActivity.class);

        // put data values in new intent:
        myIntent.putExtra("recipeTitleData", rec.getRecipeTitle());
        myIntent.putExtra("versionData", rec.getVersion());
        myIntent.putExtra("cookbookData", (rec.getCookbook()).getCookbookTitle());

        ArrayList<Double> ingredientAmts = rec.getAllIngredientAmts();
        ArrayList<String> ingredientVals = rec.getAllIngredients();

        for(int i = 0; i < ingredientAmts.size(); i++){    // ingredientVals should be same size
            String amtKey = "ingredient" + (i+1) + "AmountData";
            myIntent.putExtra(amtKey, Double.valueOf(ingredientAmts.get(i)));

            String ingKey = "ingredient" + (i+1) + "Data";
            myIntent.putExtra(ingKey, ingredientVals.get(i));
        }

        ArrayList<String> steps = rec.getAllSteps();
        // DEBUGGING
        for (String s : steps) System.out.println(s + " in " + steps.indexOf(s));

        for(int i = 0; i < steps.size(); i++){
            String stepKey = "step" + (i+1) + "Data";
            myIntent.putExtra(stepKey, steps.get(i));
        }

        myIntent.addFlags(recipeViewFlag);
        startActivity(myIntent);
    }

}
