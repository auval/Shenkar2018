package com.amiru.shenkar2018;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
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

        // "tag" is an optional string you can add to any view to use if you need
        // here I set it in the layout file, to make sure I don't try to cast operators to Integer
        Object tag = view.getTag();

        if ("num".equals(tag)) {
            String digitClicked = (String) ((Button) view).getText();
            String currentText = (String) calcScreen.getText();
            int currentValue = Integer.parseInt(currentText);
            int newValue = 10 * currentValue + Integer.parseInt(digitClicked);
            calcScreen.setText(String.valueOf(newValue));
        }
    }
}
