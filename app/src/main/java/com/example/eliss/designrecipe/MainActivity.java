package com.example.eliss.designrecipe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
    private static final int newTaskFlag = Intent.FLAG_ACTIVITY_NEW_TASK;

    private ImageButton mainImage;
    private Button createRecipe;
    private TextView recipe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // manual insertion of toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.searchToolbar);
        setSupportActionBar(myToolbar);

        createRecipe = (Button) findViewById(R.id.createRecipeHomeButton);
        mainImage = (ImageButton) findViewById(R.id.mainImageView);
        recipe1 = (TextView) findViewById(R.id.edit1TextView);

        DBHandler db = new DBHandler(this);
        // pull most recent edit to display
        Recipe tmpRecipe = db.getMostRecent();
        if(tmpRecipe!=null){
            String recipe1Data = tmpRecipe.getRecipeTitle() +
                    " -- edited on " + (tmpRecipe.getCookbook()).getDateCreated() +
                    "\n\t\tVersion: " + tmpRecipe.getVersion() +
                    "\n\t\tCookbook: " + tmpRecipe.getCookbook() + "\n";
            recipe1.setText(recipe1Data);
        }

    }

    /*
        Takes the user to the 'Create Recipe' activity
        startActivity() is called with no result necessary
    */
    public void onCreateRecipeButtonClick(View v){
        Intent myIntent = new Intent(this, CreateRecipeActivity.class);
        // creates new intent for recipe entry (clears all previous data entered)
        myIntent.addFlags(newTaskFlag);
        startActivity(myIntent);
    }

    /*
        When resuming home screen, no change (load previous state)
     */
    @Override
    public void onResume(){
        super.onResume();
    }

    /*
        When a new intent is created, set current intent to this one
     */
    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /*
        Inflates menu (toolbar) to add items
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
        Handles toolbar item clicks, such as when user clicks the Search button
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_search){
            Intent myIntent = new Intent(this, TempCookbookSearch.class);
            myIntent.addFlags(mFlag);
            startActivity(myIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
