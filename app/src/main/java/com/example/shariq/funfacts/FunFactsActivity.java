package com.example.shariq.funfacts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Declare our View variables and assign the views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button  showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout factLayout = (RelativeLayout) findViewById(R.id.layoutOne);
        final Random randomGenerator = new Random();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String fact = mFactBook.getFact();
            //Update the label with our dynamic fact
            factLabel.setText(fact);
            int color = mColorWheel.getColor();
            factLayout.setBackgroundColor(color);
            showFactButton.setTextColor(color);

            int randomNumber = randomGenerator.nextInt(19);
            String randomString = "";
            randomString = randomNumber + "";
            Toast.makeText(getBaseContext(), randomString, Toast.LENGTH_SHORT).show();
            }
        };
        showFactButton.setOnClickListener(listener);





        Log.d(TAG, "We're logging from the onCreate() method!"); //Video Reference: The Android Log


    }
}
