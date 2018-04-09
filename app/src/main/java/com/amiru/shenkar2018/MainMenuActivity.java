package com.amiru.shenkar2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    MyAdapter mAdapter;

    ArrayList<MyListItem> hw = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mRecyclerView = findViewById(R.id.homeworkList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        for (int i = 1; i <= 100; i++) {
            hw.add(new MyListItem("This is item number " + i));
        }


        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(hw);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void onCalcClicked(View view) {
        startActivity(new Intent(this, CalculatorActivity.class));
    }
}
