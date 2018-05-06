package com.amiru.shenkar2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.amiru.shenkar2018.llg.LowLevelGraphicsActivity;
import com.amiru.shenkar2018.recyclerview.RecyclerViewExampleActivity;
import com.amiru.shenkar2018.storage.StorageExampleActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lesson4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mi_settings) {
            Toast.makeText(getBaseContext(), "Todo: settings screen", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onStorageClicked(View view) {
        startActivity(new Intent(this, StorageExampleActivity.class));
    }

    public void onCalcClicked(View view) {
        startActivity(new Intent(this, CalculatorActivity.class));
    }

    public void onPrefsClicked(View view) {
        startActivity(new Intent(this, PrefsActivity.class));
    }

    public void onRecyclerDemoClicked(View view) {
        startActivity(new Intent(this, RecyclerViewExampleActivity.class));
    }

    public void onLayoutAnimationClicked(View view) {
        startActivity(new Intent(this, LayoutAnimationActivity.class));
    }

    public void onLowLevelGraphicsClicked(View view) {
        startActivity(new Intent(this, LowLevelGraphicsActivity.class));
    }

    public void onProgrammaticLayoutClicked(View view) {
        startActivity(new Intent(this, ProgrammaticLayoutActivity.class));
    }
}
