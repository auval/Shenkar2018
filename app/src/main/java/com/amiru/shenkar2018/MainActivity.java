package com.amiru.shenkar2018;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView calcScreen;

    /**
     * Example on how to create a simple calculator
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         calcScreen = findViewById(R.id.calcScreen);
    }

    public void onDigitClicked(View view) {
        String digitClicked = (String) ((Button) view).getText();

        String currentText = (String) calcScreen.getText();

        int currentValue = Integer.parseInt(currentText);

        int newValue = 10*currentValue + Integer.parseInt(digitClicked);

        calcScreen.setText(String.valueOf(newValue));

    }
}
