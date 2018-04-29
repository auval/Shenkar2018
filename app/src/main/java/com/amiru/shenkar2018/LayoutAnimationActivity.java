package com.amiru.shenkar2018;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class LayoutAnimationActivity extends AppCompatActivity {

    int mLayoutState = 1;
    TransitionManager mTransitionManager;
    Transition mTransition;
    Scene mScene1;
    Scene mScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_layout_animation);

//        View view = findViewById(R.id.touch_me);


        /**
         * This is how to get a reference to the root view
         */
        final ViewGroup rootView = findViewById(android.R.id.content);

        mScene1 = Scene.getSceneForLayout(rootView, R.layout.activity_layout_animation, getBaseContext());
        mScene2 = Scene.getSceneForLayout(rootView, R.layout.activity_layout_animation_2, getBaseContext());
        mScene1.enter();

        mTransitionManager = new TransitionManager();
        mTransition = new ChangeBounds();


    }

    public void onTextClicked(View view) {
        if (mLayoutState == 1) {
            mTransitionManager.setTransition(mScene1, mScene2, mTransition);
            mTransitionManager.transitionTo(mScene2);
            mLayoutState = 2;
        } else {
            mTransitionManager.setTransition(mScene2, mScene1, mTransition);
            mTransitionManager.transitionTo(mScene1);
            mLayoutState = 1;
        }
    }
}
