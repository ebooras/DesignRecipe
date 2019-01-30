package com.example.eliss.designrecipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;

public class CreateRecipeActivity extends AppCompatActivity {
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
    private static final int newTaskFlag = Intent.FLAG_ACTIVITY_NEW_TASK;

    private EditText recipeTitle;
    private EditText version;
    private EditText cookbook;
    private EditText ingredient1Amount;
    private EditText ingredient1;
    private EditText ingredient2Amount;
    private EditText ingredient2;
    private EditText ingredient3Amount;
    private EditText ingredient3;
    private EditText ingredient4Amount;
    private EditText ingredient4;
    private EditText ingredient5Amount;
    private EditText ingredient5;
    private EditText ingredient6Amount;
    private EditText ingredient6;
    private EditText ingredient7Amount;
    private EditText ingredient7;
    private EditText ingredient8Amount;
    private EditText ingredient8;
    private EditText ingredient9Amount;
    private EditText ingredient9;
    private EditText ingredient10Amount;
    private EditText ingredient10;
    private EditText methodStep1;
    private EditText methodStep2;
    private EditText methodStep3;
    private EditText methodStep4;
    private EditText methodStep5;
    private EditText methodStep6;
    private EditText methodStep7;
    private EditText methodStep8;
    private EditText methodStep9;
    private EditText methodStep10;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        recipeTitle = (EditText) findViewById(R.id.titleEditText);
        version = (EditText) findViewById(R.id.versionEditText);
        cookbook = (EditText) findViewById(R.id.cookbookEditText);
        ingredient1Amount = (EditText) findViewById(R.id.ingredient1AmountEditText);
        ingredient1 = (EditText) findViewById(R.id.ingredient1EditText);
        ingredient2Amount = (EditText) findViewById(R.id.ingredient2AmountEditText);
        ingredient2 = (EditText) findViewById(R.id.ingredient2EditText);
        ingredient3Amount = (EditText) findViewById(R.id.ingredient3AmountEditText);
        ingredient3 = (EditText) findViewById(R.id.ingredient3EditText);
        ingredient4Amount = (EditText) findViewById(R.id.ingredient4AmountEditText);
        ingredient4 = (EditText) findViewById(R.id.ingredient4EditText);
        ingredient5Amount = (EditText) findViewById(R.id.ingredient5AmountEditText);
        ingredient5 = (EditText) findViewById(R.id.ingredient5EditText);
        ingredient6Amount = (EditText) findViewById(R.id.ingredient6AmountEditText);
        ingredient6 = (EditText) findViewById(R.id.ingredient6EditText);
        ingredient7Amount = (EditText) findViewById(R.id.ingredient7AmountEditText);
        ingredient7 = (EditText) findViewById(R.id.ingredient7EditText);
        ingredient8Amount = (EditText) findViewById(R.id.ingredient8AmountEditText);
        ingredient8 = (EditText) findViewById(R.id.ingredient8EditText);
        ingredient9Amount = (EditText) findViewById(R.id.ingredient9AmountEditText);
        ingredient9 = (EditText) findViewById(R.id.ingredient9EditText);
        ingredient10Amount = (EditText) findViewById(R.id.ingredient10AmountEditText);
        ingredient10 = (EditText) findViewById(R.id.ingredient10EditText);
        methodStep1 = (EditText) findViewById(R.id.step1EditText);
        methodStep2 = (EditText) findViewById(R.id.step2EditText);
        methodStep3 = (EditText) findViewById(R.id.step3EditText);
        methodStep4 = (EditText) findViewById(R.id.step4EditText);
        methodStep5 = (EditText) findViewById(R.id.step5EditText);
        methodStep6 = (EditText) findViewById(R.id.step6EditText);
        methodStep7 = (EditText) findViewById(R.id.step7EditText);
        methodStep8 = (EditText) findViewById(R.id.step8EditText);
        methodStep9 = (EditText) findViewById(R.id.step9EditText);
        methodStep10 = (EditText) findViewById(R.id.step10EditText);

        Bundle recipeData = null;
        try{
            recipeData = getIntent().getExtras();
        } catch(NullPointerException e){
            Toast.makeText(this, "Error: cannot retrieve package", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        if(recipeData != null){
            // retrieve and unpack data
            String title = recipeData.getString("recipeTitleData");
            double version_data = recipeData.getDouble("versionData");
            String cookbook_data = recipeData.getString("cookbookData");
            double ingAmt1 = recipeData.getDouble("ingredient1AmountData");
            String ing1 = recipeData.getString("ingredient1Data");
            double ingAmt2 = recipeData.getDouble("ingredient2AmountData");
            String ing2 = recipeData.getString("ingredient2Data");
            double ingAmt3 = recipeData.getDouble("ingredient3AmountData");
            String ing3 = recipeData.getString("ingredient3Data");
            double ingAmt4 = recipeData.getDouble("ingredient4AmountData");
            String ing4 = recipeData.getString("ingredient4Data");
            double ingAmt5 = recipeData.getDouble("ingredient5AmountData");
            String ing5 = recipeData.getString("ingredient5Data");
            double ingAmt6 = recipeData.getDouble("ingredient6AmountData");
            String ing6 = recipeData.getString("ingredient6Data");
            double ingAmt7 = recipeData.getDouble("ingredient7AmountData");
            String ing7 = recipeData.getString("ingredient7Data");
            double ingAmt8 = recipeData.getDouble("ingredient8AmountData");
            String ing8 = recipeData.getString("ingredient8Data");
            double ingAmt9 = recipeData.getDouble("ingredient9AmountData");
            String ing9 = recipeData.getString("ingredient9Data");
            double ingAmt10 = recipeData.getDouble("ingredient10AmountData");
            String ing10 = recipeData.getString("ingredient10Data");
            String step1 = recipeData.getString("step1Data");
            String step2 = recipeData.getString("step2Data");
            String step3 = recipeData.getString("step3Data");
            String step4 = recipeData.getString("step4Data");
            String step5 = recipeData.getString("step5Data");
            String step6 = recipeData.getString("step6Data");
            String step7 = recipeData.getString("step7Data");
            String step8 = recipeData.getString("step8Data");
            String step9 = recipeData.getString("step9Data");
            String step10 = recipeData.getString("step10Data");

            // populate fields with data
            recipeTitle.setText(title);
            version.setText(Double.toString(version_data));
            cookbook.setText(cookbook_data);

            ingredient1Amount.setText(Double.toString(ingAmt1));
            if(ing1.equals("null")) ingredient1.setText("");
            else ingredient1.setText(ing1);

            ingredient2Amount.setText(Double.toString(ingAmt2));
            if(ing2.equals("null")) ingredient2.setText("");
            else ingredient2.setText(ing2);

            ingredient3Amount.setText(Double.toString(ingAmt3));
            if(ing3.equals("null")) ingredient3.setText("");
            else ingredient3.setText(ing3);

            ingredient4Amount.setText(Double.toString(ingAmt4));
            if(ing4.equals("null")) ingredient4.setText("");
            else ingredient4.setText(ing4);

            ingredient5Amount.setText(Double.toString(ingAmt5));
            if(ing5.equals("null")) ingredient5.setText("");
            else ingredient5.setText(ing5);

            ingredient6Amount.setText(Double.toString(ingAmt6));
            if(ing6.equals("null")) ingredient6.setText("");
            else ingredient6.setText(ing6);

            ingredient7Amount.setText(Double.toString(ingAmt7));
            if(ing7.equals("null")) ingredient7.setText("");
            else ingredient7.setText(ing7);

            ingredient8Amount.setText(Double.toString(ingAmt8));
            if(ing8.equals("null")) ingredient8.setText("");
            else ingredient8.setText(ing8);

            ingredient9Amount.setText(Double.toString(ingAmt9));
            if(ing9.equals("null")) ingredient9.setText("");
            else ingredient9.setText(ing9);

            ingredient10Amount.setText(Double.toString(ingAmt10));
            if(ing10.equals("null")) ingredient10.setText("");
            else ingredient10.setText(ing10);

            if(step1.equals("null")) methodStep1.setText("");
            else methodStep1.setText(step1);

            if(step2.equals("null")) methodStep2.setText("");
            else methodStep2.setText(step2);

            if(step3.equals("null")) methodStep3.setText("");
            else methodStep3.setText(step3);

            if(step4.equals("null")) methodStep4.setText("");
            else methodStep4.setText(step4);

            if(step5.equals("null")) methodStep5.setText("");
            else methodStep5.setText(step5);

            if(step6.equals("null")) methodStep6.setText("");
            else methodStep6.setText(step6);

            if(step7.equals("null")) methodStep7.setText("");
            else methodStep7.setText(step7);

            if(step8.equals("null")) methodStep8.setText("");
            else methodStep8.setText(step8);

            if(step9.equals("null")) methodStep9.setText("");
            else methodStep9.setText(step9);

            if(step10.equals("null")) methodStep10.setText("");
            else methodStep10.setText(step10);
        }
    }

    @Override
    public void onResume(){ super.onResume(); }

    /*
        Takes all data entered and sends it to RecipeViewActivity for display,
        enters all data into database as well.
     */
    public void onCreateButtonClick(View v){
        Intent myIntent = new Intent(this, RecipeViewActivity.class);
        boolean proceed = true;

        double mVersion = 0, myIngr1Amt = 0, myIngr2Amt = 0, myIngr3Amt = 0, myIngr4Amt = 0, myIngr5Amt = 0,
                myIngr6Amt = 0, myIngr7Amt = 0, myIngr8Amt = 0, myIngr9Amt = 0, myIngr10Amt = 0;

        // validate input data types
        String mRecipeTitle = recipeTitle.getText().toString().trim();
        if(mRecipeTitle.length() <= 0){
            Toast.makeText(this, "Error: Recipe must have a title.", Toast.LENGTH_LONG).show();
            proceed = false;  // will prevent Recipe from being created
        }

        try{
            mVersion = Double.valueOf(version.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: version must be a double", Toast.LENGTH_LONG).show();
            proceed = false;  // will prevent Recipe from being created
        }

        String mCookbook = cookbook.getText().toString().trim();
        if(mCookbook.length() <= 0){
            Toast.makeText(this, "Error: Recipe must belong to a Cookbook.", Toast.LENGTH_LONG).show();
            proceed = false;  // will prevent Recipe from being created
        }

        try{
            myIngr1Amt = Double.valueOf(ingredient1Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 1 amount must be a double", Toast.LENGTH_LONG).show();
            proceed = false;  // will prevent Recipe from being created
        }

        String myIngr1 = ingredient1.getText().toString().trim();
        if(myIngr1.length() <= 0){
            myIngr1 = "null";   // puts null string in database
            proceed = false;  // will prevent Recipe from being created
        }

        try{
            myIngr2Amt = Double.valueOf(ingredient2Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 2 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr2 = ingredient2.getText().toString().trim();
        if(myIngr2.length() <= 0){
            myIngr2 = "null";   // puts null string in database
        }

        try{
            myIngr3Amt = Double.valueOf(ingredient3Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 3 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr3 = ingredient3.getText().toString().trim();
        if(myIngr3.length() <= 0){
            myIngr3 = "null";   // puts null string in database
        }

        try{
            myIngr4Amt = Double.valueOf(ingredient4Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 4 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr4 = ingredient4.getText().toString().trim();
        if(myIngr4.length() <= 0){
            myIngr4 = "null";   // puts null string in database
        }

        try{
            myIngr5Amt = Double.valueOf(ingredient5Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 5 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr5 = ingredient5.getText().toString().trim();
        if(myIngr5.length() <= 0){
            myIngr5 = "null";   // puts null string in database
        }

        try{
            myIngr6Amt = Double.valueOf(ingredient6Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 6 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr6 = ingredient6.getText().toString().trim();
        if(myIngr6.length() <= 0){
            myIngr6 = "null";   // puts null string in database
        }

        try{
            myIngr7Amt = Double.valueOf(ingredient7Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 7 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr7 = ingredient7.getText().toString().trim();
        if(myIngr7.length() <= 0){
            myIngr7 = "null";   // puts null string in database
        }

        try{
            myIngr8Amt = Double.valueOf(ingredient8Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 8 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr8 = ingredient8.getText().toString().trim();
        if(myIngr8.length() <= 0){
            myIngr8 = "null";   // puts null string in database
        }

        try{
            myIngr9Amt = Double.valueOf(ingredient9Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 9 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr9 = ingredient9.getText().toString().trim();
        if(myIngr9.length() <= 0){
            myIngr9 = "null";   // puts null string in database
        }

        try{
            myIngr10Amt = Double.valueOf(ingredient10Amount.getText().toString().trim());
        } catch(Exception e){
            Toast.makeText(this, "Error: ingredient 10 amount must be a double", Toast.LENGTH_LONG).show();
        }

        String myIngr10 = ingredient10.getText().toString().trim();
        if(myIngr10.length() <= 0){
            myIngr10 = "null";   // puts null string in database
        }

        String step1 = methodStep1.getText().toString().trim();
        if(step1.length() <= 0){
            step1 = "null";   // puts null string in database
            proceed = false;  // will prevent Recipe from being created
        }

        String step2 = methodStep2.getText().toString().trim();
        if(step2.length() <= 0){
            step2 = "null";   // puts null string in database
        }

        String step3 = methodStep3.getText().toString().trim();
        if(step3.length() <= 0){
            step3 = "null";   // puts null string in database
        }

        String step4 = methodStep4.getText().toString().trim();
        if(step4.length() <= 0){
            step4 = "null";   // puts null string in database
        }

        String step5 = methodStep5.getText().toString().trim();
        if(step5.length() <= 0){
            step5 = "null";   // puts null string in database
        }

        String step6 = methodStep6.getText().toString().trim();
        if(step6.length() <= 0){
            step6 = "null";   // puts null string in database
        }

        String step7 = methodStep7.getText().toString().trim();
        if(step7.length() <= 0){
            step7 = "null";   // puts null string in database
        }

        String step8 = methodStep8.getText().toString().trim();
        if(step8.length() <= 0){
            step8 = "null";   // puts null string in database
        }

        String step9 = methodStep9.getText().toString().trim();
        if(step9.length() <= 0){
            step9 = "null";   // puts null string in database
        }

        String step10 = methodStep10.getText().toString().trim();
        if(step10.length() <= 0){
            step10 = "null";   // puts null string in database
        }

        // database updates:
        DBHandler dbHandler = new DBHandler(this);

        // create new Cookbook object to pass into new Recipe
        Cookbook c = new Cookbook(mCookbook);

        // construct arrays for more efficient recipe creation
        double[] amts = { myIngr1Amt, myIngr2Amt, myIngr3Amt, myIngr4Amt, myIngr5Amt, myIngr6Amt,
                myIngr7Amt, myIngr8Amt, myIngr9Amt, myIngr10Amt };
        String[] ings = { myIngr1, myIngr2, myIngr3, myIngr4, myIngr5, myIngr6, myIngr7, myIngr8, myIngr9, myIngr10 };
        String[] steps = { step1, step2, step3, step4, step5, step6, step7, step8, step9, step10 };

        // create ArrayList of Ingredients to pass into new Recipe
        ArrayList<Ingredient> mIngredients = new ArrayList<Ingredient>();
        for(int i = 0; i < amts.length; i++){
            Ingredient ing = new Ingredient(amts[i], ings[i]);    // amts and ings should be the same length (amount/ingredient pairs)
            mIngredients.add(ing);
        }

        // create Hashtable of method steps to pass into new Recipe
        Hashtable<Integer, String> mMethod = new Hashtable<Integer, String>();
        int stepNum = 1;
        for(int i = 0; i < steps.length; i++){
            Integer s = Integer.valueOf(stepNum++);
            mMethod.put(s, steps[i]);
        }

        Recipe r = new Recipe(mRecipeTitle, mVersion, c, mIngredients, mMethod);

        // if we are not updating an already-existing Recipe, create a new entry in database
        if(r!=null && dbHandler.findRecipe(r.getRecipeTitle())==null && proceed) {
            dbHandler.addRecipe(r);
            Toast.makeText(this, mRecipeTitle + " added to database!", Toast.LENGTH_LONG).show();
        } else if(r!=null && dbHandler.findRecipe(r.getRecipeTitle())!=null && proceed){
            // if we are updating an already-existing Recipe with a new version
            // this copies the existing Recipe data into a new entry and replaces the updated data columns
            boolean res = dbHandler.updateRecipe(r);
            if(res) Toast.makeText(this, r.getRecipeTitle() + " updated!", Toast.LENGTH_LONG).show();
            else Toast.makeText(this, "Error updating " + r.getRecipeTitle(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error: Couldn't add recipe to database.", Toast.LENGTH_LONG).show();
        }

        // put data values in new intent if recipe was successfully created
        if(r!=null && proceed){
            myIntent.putExtra("recipeTitleData", mRecipeTitle);
            myIntent.putExtra("versionData", mVersion);
            myIntent.putExtra("cookbookData", c.getCookbookTitle());
            myIntent.putExtra("ingredient1AmountData", amts[0]);
            myIntent.putExtra("ingredient1Data", ings[0]);
            myIntent.putExtra("ingredient2AmountData", amts[1]);
            myIntent.putExtra("ingredient2Data", ings[1]);
            myIntent.putExtra("ingredient3AmountData", amts[2]);
            myIntent.putExtra("ingredient3Data", ings[2]);
            myIntent.putExtra("ingredient4AmountData", amts[3]);
            myIntent.putExtra("ingredient4Data", ings[3]);
            myIntent.putExtra("ingredient5AmountData", amts[4]);
            myIntent.putExtra("ingredient5Data", ings[4]);
            myIntent.putExtra("ingredient6AmountData", amts[5]);
            myIntent.putExtra("ingredient6Data", ings[5]);
            myIntent.putExtra("ingredient7AmountData", amts[6]);
            myIntent.putExtra("ingredient7Data", ings[6]);
            myIntent.putExtra("ingredient8AmountData", amts[7]);
            myIntent.putExtra("ingredient8Data", ings[7]);
            myIntent.putExtra("ingredient9AmountData", amts[8]);
            myIntent.putExtra("ingredient9Data", ings[8]);
            myIntent.putExtra("ingredient10AmountData", amts[9]);
            myIntent.putExtra("ingredient10Data", ings[9]);
            myIntent.putExtra("step1Data", steps[0]);
            myIntent.putExtra("step2Data", steps[1]);
            myIntent.putExtra("step3Data", steps[2]);
            myIntent.putExtra("step4Data", steps[3]);
            myIntent.putExtra("step5Data", steps[4]);
            myIntent.putExtra("step6Data", steps[5]);
            myIntent.putExtra("step7Data", steps[6]);
            myIntent.putExtra("step8Data", steps[7]);
            myIntent.putExtra("step9Data", steps[8]);
            myIntent.putExtra("step10Data", steps[9]);

            startActivity(myIntent);
        }

    }

    /*
        When 'Home' button is clicked, takes user back to MainActivity
        startActivity() called with no result necessary
     */
    public void onHomeButtonClick(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.addFlags(newTaskFlag);
        startActivity(myIntent);
    }

}
