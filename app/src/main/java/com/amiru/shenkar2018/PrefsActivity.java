package com.amiru.shenkar2018;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * demonstrating SharedPreferences
 * https://developer.android.com/training/data-storage/shared-preferences.html
 */
public class PrefsActivity extends AppCompatActivity {
    SeekBar seekbar;
    EditText name;
    TextView theNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs);
        seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    saveProgress(progress);
                }
                theNumber.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        name = findViewById(R.id.nameEditText);
        name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Toast.makeText(getBaseContext(), name.getText(), Toast.LENGTH_SHORT).show();
                    saveName(name.getText().toString());
                    return true;
                }
                return false;
            }
        });

        theNumber = findViewById(R.id.theNumberTextField);


        goFetchValues();

    }

    /**
     * "static" to avoid memory leak
     */
    private void goFetchValues() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                int numericValue = sharedPref.getInt("numeric_value", 0);
                String userName = sharedPref.getString("user_name", "");

                seekbar.setProgress(numericValue);
                theNumber.setText(String.valueOf(numericValue));
                name.setText(userName);
            }
        }).start();
    }

    private void saveName(final String text) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("user_name", text);
                editor.apply();
            }
        }).start();
    }

    private void saveProgress(final int progress) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("numeric_value", progress);
                editor.apply();

            }
        }).start();
    }
}
