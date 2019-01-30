package com.example.eliss.designrecipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RecipeViewActivity extends AppCompatActivity {
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
    private static final int newTaskFlag = Intent.FLAG_ACTIVITY_NEW_TASK;

    private TextView recipeTitle;
    private TextView versionAndCookbook;
    private TextView ingredient1;
    private TextView ingredient2;
    private TextView ingredient3;
    private TextView ingredient4;
    private TextView ingredient5;
    private TextView ingredient6;
    private TextView ingredient7;
    private TextView ingredient8;
    private TextView ingredient9;
    private TextView ingredient10;
    private TextView method;

    Bundle myData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        recipeTitle = (TextView) findViewById(R.id.recipeTitleTextView);
        versionAndCookbook = (TextView) findViewById(R.id.versionAndCookbookTextView);
        ingredient1 = (TextView) findViewById(R.id.ingredient1TextView);
        ingredient2 = (TextView) findViewById(R.id.ingredient2TextView);
        ingredient3 = (TextView) findViewById(R.id.ingredient3TextView);
        ingredient4 = (TextView) findViewById(R.id.ingredient4TextView);
        ingredient5 = (TextView) findViewById(R.id.ingredient5TextView);
        ingredient6 = (TextView) findViewById(R.id.ingredient6TextView);
        ingredient7 = (TextView) findViewById(R.id.ingredient7TextView);
        ingredient8 = (TextView) findViewById(R.id.ingredient8TextView);
        ingredient9 = (TextView) findViewById(R.id.ingredient9TextView);
        ingredient10 = (TextView) findViewById(R.id.ingredient10TextView);
        method = (TextView) findViewById(R.id.recipeStepsTextView);

        try{
            // get data from CreateRecipeActivity
            myData = getIntent().getExtras();

            // unpack data and set all text on RecipeView screen
            String mRecipeTitle = myData.getString("recipeTitleData");
            recipeTitle.setText(mRecipeTitle);
            double mVersion = myData.getDouble("versionData");
            String mCookbook = myData.getString("cookbookData");
            versionAndCookbook.setText("Version "+ mVersion + " in " + mCookbook);

            double mIngr1Amt = myData.getDouble("ingredient1AmountData");
            String mIngr1 = myData.getString("ingredient1Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr1.equals("null") || mIngr1==null || mIngr1.length()==0) ingredient1.setText("");
            else ingredient1.setText(mIngr1Amt + " " + mIngr1);

            double mIngr2Amt = myData.getDouble("ingredient2AmountData");
            String mIngr2 = myData.getString("ingredient2Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr2.equals("null") || mIngr2==null || mIngr2.length()==0) ingredient2.setText("");
            else ingredient2.setText(mIngr2Amt + " " + mIngr2);

            double mIngr3Amt = myData.getDouble("ingredient3AmountData");
            String mIngr3 = myData.getString("ingredient3Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr3.equals("null") || mIngr3==null || mIngr3.length()==0) ingredient3.setText("");
            else ingredient3.setText(mIngr3Amt + " " + mIngr3);

            double mIngr4Amt = myData.getDouble("ingredient4AmountData");
            String mIngr4 = myData.getString("ingredient4Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr4.equals("null") || mIngr4==null || mIngr4.length()==0) ingredient4.setText("");
            else ingredient4.setText(mIngr4Amt + " " + mIngr4);

            double mIngr5Amt = myData.getDouble("ingredient5AmountData");
            String mIngr5 = myData.getString("ingredient5Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr5.equals("null") || mIngr5==null || mIngr5.length()==0) ingredient5.setText("");
            else ingredient5.setText(mIngr5Amt + " " + mIngr5);

            double mIngr6Amt = myData.getDouble("ingredient6AmountData");
            String mIngr6 = myData.getString("ingredient6Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr6.equals("null") || mIngr6==null || mIngr6.length()==0) ingredient6.setText("");
            else ingredient6.setText(mIngr6Amt + " " + mIngr6);

            double mIngr7Amt = myData.getDouble("ingredient7AmountData");
            String mIngr7 = myData.getString("ingredient7Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr7.equals("null") || mIngr7==null || mIngr7.length()==0) ingredient7.setText("");
            else ingredient7.setText(mIngr7Amt + " " + mIngr7);

            double mIngr8Amt = myData.getDouble("ingredient8AmountData");
            String mIngr8 = myData.getString("ingredient8Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr8.equals("null") || mIngr8==null || mIngr8.length()==0) ingredient8.setText("");
            else ingredient8.setText(mIngr8Amt + " " + mIngr8);

            double mIngr9Amt = myData.getDouble("ingredient9AmountData");
            String mIngr9 = myData.getString("ingredient9Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr9.equals("null") || mIngr9==null || mIngr9.length()==0) ingredient9.setText("");
            else ingredient9.setText(mIngr9Amt + " " + mIngr9);

            double mIngr10Amt = myData.getDouble("ingredient10AmountData");
            String mIngr10 = myData.getString("ingredient10Data");
            // if no ingredient was entered, don't show that ingredient at all
            if(mIngr10.equals("null") || mIngr10==null || mIngr10.length()==0) ingredient10.setText("");
            else ingredient10.setText(mIngr10Amt + " " + mIngr10);

            String step1Data = myData.getString("step1Data");
            String step1 = "";
            if(step1Data.equals("null") || step1Data==null || step1Data.length()==0) step1 = ""; // if no step was entered, don't show it at all
            else step1 += "1. " + step1Data;

            String step2Data = myData.getString("step2Data");
            String step2 = "";
            if(step2Data.equals("null") || step2Data==null || step2Data.length()==0) step2 = ""; // if no step was entered, don't show it at all
            else step2 += "2. " + step2Data;

            String step3Data = myData.getString("step3Data");
            String step3 = "";
            if(step3Data.equals("null") || step3Data==null || step3Data.length()==0) step3 = ""; // if no step was entered, don't show it at all
            else step3 += "3. " + step3Data;

            String step4Data = myData.getString("step4Data");
            String step4 = "";
            if(step4Data.equals("null") || step4Data==null || step4Data.length()==0) step4 = ""; // if no step was entered, don't show it at all
            else step4 += "4. " + step4Data;

            String step5Data = myData.getString("step5Data");
            String step5 = "";
            if(step5Data.equals("null") || step5Data==null || step5Data.length()==0) step5 = ""; // if no step was entered, don't show it at all
            else step5 += "5. " + step5Data;

            String step6Data = myData.getString("step6Data");
            String step6 = "";
            if(step6Data.equals("null") || step6Data==null || step6Data.length()==0) step6 = ""; // if no step was entered, don't show it at all
            else step6 += "6. " + step6Data;

            String step7Data = myData.getString("step7Data");
            String step7 = "";
            if(step7Data.equals("null") || step7Data==null || step7Data.length()==0) step7 = ""; // if no step was entered, don't show it at all
            else step7 += "7. " + step7Data;

            String step8Data = myData.getString("step8Data");
            String step8 = "";
            if(step8Data.equals("null") || step8Data==null || step8Data.length()==0) step8 = ""; // if no step was entered, don't show it at all
            else step8 += "8. " + step8Data;

            String step9Data = myData.getString("step9Data");
            String step9 = "";
            if(step9Data.equals("null") || step9Data==null || step9Data.length()==0) step9 = ""; // if no step was entered, don't show it at all
            else step9 += "9. " + step9Data;

            String step10Data = myData.getString("step10Data");
            String step10 = "";
            if(step10Data.equals("null") || step10Data==null || step10Data.length()==0) step10 = ""; // if no step was entered, don't show it at all
            else step10 += "10. " + step10Data;

            method.setText(step1 + "\n" + step2 + "\n" + step3 + "\n" + step4 + "\n" + step5 + "\n"
                    + step6 + "\n" + step7 + "\n" + step8 + "\n" + step9 + "\n" + step10 + "\n");
        } catch(NullPointerException e){
            Toast.makeText(this, "Error: cannot retrieve recipe", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

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
        When page is resumed, no change
     */
    @Override
    public void onResume(){
        super.onResume();
    }

    /*
        Takes user back to 'Create Recipe' page to make changes
     */
    public void onEditButtonClick(View v){
        // fill in blanks in CreateRecipeActivity with data given in bundle

        Intent returnIntent = new Intent(this, CreateRecipeActivity.class);

        String title = myData.getString("recipeTitleData");
        double version = myData.getDouble("versionData");
        String cookbook = myData.getString("cookbookData");
        double ingAmt1 = myData.getDouble("ingredient1AmountData");
        String ing1 = myData.getString("ingredient1Data");
        double ingAmt2 = myData.getDouble("ingredient2AmountData");
        String ing2 = myData.getString("ingredient2Data");
        double ingAmt3 = myData.getDouble("ingredient3AmountData");
        String ing3 = myData.getString("ingredient3Data");
        double ingAmt4 = myData.getDouble("ingredient4AmountData");
        String ing4 = myData.getString("ingredient4Data");
        double ingAmt5 = myData.getDouble("ingredient5AmountData");
        String ing5 = myData.getString("ingredient5Data");
        double ingAmt6 = myData.getDouble("ingredient6AmountData");
        String ing6 = myData.getString("ingredient6Data");
        double ingAmt7 = myData.getDouble("ingredient7AmountData");
        String ing7 = myData.getString("ingredient7Data");
        double ingAmt8 = myData.getDouble("ingredient8AmountData");
        String ing8 = myData.getString("ingredient8Data");
        double ingAmt9 = myData.getDouble("ingredient9AmountData");
        String ing9 = myData.getString("ingredient9Data");
        double ingAmt10 = myData.getDouble("ingredient10AmountData");
        String ing10 = myData.getString("ingredient10Data");
        String step1 = myData.getString("step1Data");
        String step2 = myData.getString("step2Data");
        String step3 = myData.getString("step3Data");
        String step4 = myData.getString("step4Data");
        String step5 = myData.getString("step5Data");
        String step6 = myData.getString("step6Data");
        String step7 = myData.getString("step7Data");
        String step8 = myData.getString("step8Data");
        String step9 = myData.getString("step9Data");
        String step10 = myData.getString("step10Data");

        returnIntent.putExtra("recipeTitleData", title);
        returnIntent.putExtra("versionData", version);
        returnIntent.putExtra("cookbookData", cookbook);
        returnIntent.putExtra("ingredient1AmountData", ingAmt1);
        returnIntent.putExtra("ingredient1Data", ing1);
        returnIntent.putExtra("ingredient2AmountData", ingAmt2);
        returnIntent.putExtra("ingredient2Data", ing2);
        returnIntent.putExtra("ingredient3AmountData", ingAmt3);
        returnIntent.putExtra("ingredient3Data", ing3);
        returnIntent.putExtra("ingredient4AmountData", ingAmt4);
        returnIntent.putExtra("ingredient4Data", ing4);
        returnIntent.putExtra("ingredient5AmountData", ingAmt5);
        returnIntent.putExtra("ingredient5Data", ing5);
        returnIntent.putExtra("ingredient6AmountData", ingAmt6);
        returnIntent.putExtra("ingredient6Data", ing6);
        returnIntent.putExtra("ingredient7AmountData", ingAmt7);
        returnIntent.putExtra("ingredient7Data", ing7);
        returnIntent.putExtra("ingredient8AmountData", ingAmt8);
        returnIntent.putExtra("ingredient8Data", ing8);
        returnIntent.putExtra("ingredient9AmountData", ingAmt9);
        returnIntent.putExtra("ingredient9Data", ing9);
        returnIntent.putExtra("ingredient10AmountData", ingAmt10);
        returnIntent.putExtra("ingredient10Data", ing10);
        returnIntent.putExtra("step1Data", step1);
        returnIntent.putExtra("step2Data", step2);
        returnIntent.putExtra("step3Data", step3);
        returnIntent.putExtra("step4Data", step4);
        returnIntent.putExtra("step5Data", step5);
        returnIntent.putExtra("step6Data", step6);
        returnIntent.putExtra("step7Data", step7);
        returnIntent.putExtra("step8Data", step8);
        returnIntent.putExtra("step9Data", step9);
        returnIntent.putExtra("step10Data", step10);

        returnIntent.addFlags(mFlag);
        startActivity(returnIntent);
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
