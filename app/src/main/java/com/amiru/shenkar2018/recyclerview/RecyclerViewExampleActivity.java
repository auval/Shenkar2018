package com.amiru.shenkar2018.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.amiru.shenkar2018.R;

import java.util.ArrayList;

public class RecyclerViewExampleActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);

        mRecyclerView = findViewById(R.id.homeworkList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager   mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<MyListItem> hw = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            hw.add(new MyListItem("This is item number " + i));
        }

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(hw);
        mRecyclerView.setAdapter(mAdapter);

    }
}
