package com.enriquesportfolio.funfacts;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
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


public class FunFactMainActivity extends ActionBarActivity {

    public static final String TAG = FunFactMainActivity.class.getSimpleName();

    //Member Variable, a property about the object and hence lower case m
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    //Methods, abilities the object can perform
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_fact_main);

        // Declare View Variables and assign their views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = v -> {
            // The button was clicked!
            // Update the label with our dynamic fact
            String fact = mFactBook.getFact();
            factLabel.setText(fact);

            int color = mColorWheel.getColor();
            relativeLayout.setBackgroundColor(color);

            showFactButton.setTextColor(color);
        };

        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Yay! Our activity was created.", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Logging from onCreate().");
    }
}
