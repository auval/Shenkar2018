package com.amiru.shenkar2018;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.amiru.shenkar2018.llg.StaticView;

/**
 * https://developer.android.com/reference/android/support/constraint/ConstraintLayout.LayoutParams.html
 */
public class ProgrammaticLayoutActivity extends AppCompatActivity {
    ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatic_layout);
        rootLayout = findViewById(R.id.rootLayout);

        addBottomRightTextView();
        int centerView = addCenterView();
        addCornerViewTo(centerView);
    }

    private int addCenterView() {
        // remember the first constructor of StaticView? It's exactly for this kind of use:
        StaticView centerView = new StaticView(this);

        centerView.setId(View.generateViewId());
        float screenDensity = getScreenDensity();
        ConstraintSet set = createConstraintSet(centerView.getId(), (int) (100 * screenDensity), (int) (100 * screenDensity));

        // pin to the center of the container
        set.centerHorizontally(centerView.getId(), R.id.rootLayout);
        set.centerVertically(centerView.getId(), R.id.rootLayout);

        // add the view to the container!!
        rootLayout.addView(centerView);

        // Apply the changes
        set.applyTo(rootLayout);

        return centerView.getId();
    }

    private void addCornerViewTo(@IdRes int otherViewId) {
        // remember the first constructor of StaticView? It's exactly for this kind of use:
        View thisView = new View(this);
        thisView.setBackgroundColor(getResources().getColor(R.color.cornerView));

        thisView.setId(View.generateViewId());
        ConstraintSet set = createConstraintSet(thisView.getId(), 50, 50);

        // pin to the center of the container
        set.connect(thisView.getId(), ConstraintSet.BOTTOM, otherViewId, ConstraintSet.TOP, 8);
        set.connect(thisView.getId(), ConstraintSet.END, otherViewId, ConstraintSet.START, 8);

        // add the view to the container!!
        rootLayout.addView(thisView);

        // Apply the changes
        set.applyTo(rootLayout);

    }


    /**
     * demonstrating bottom right constraint
     */
    private void addBottomRightTextView() {
        TextView bottomRightTv = new TextView(this);
        bottomRightTv.setText("Bottom Right!");
        bottomRightTv.setTextSize(36);
        bottomRightTv.setId(View.generateViewId());

        ConstraintSet set = createConstraintSet(bottomRightTv.getId(), ConstraintSet.WRAP_CONTENT, ConstraintSet.WRAP_CONTENT);

        // pin to the bottom of the container
        set.connect(bottomRightTv.getId(), ConstraintSet.BOTTOM, R.id.rootLayout, ConstraintSet.BOTTOM, 8);
        set.connect(bottomRightTv.getId(), ConstraintSet.END, R.id.rootLayout, ConstraintSet.END, 8);


        // add the view to the container!!
        rootLayout.addView(bottomRightTv);

        // Apply the changes
        set.applyTo(rootLayout);
    }

    private ConstraintSet createConstraintSet(@IdRes int viewId, int width, int height) {
        ConstraintSet set = new ConstraintSet();
        set.constrainHeight(viewId, height);
        set.constrainWidth(viewId, width);
        return set;
    }

    private float getScreenDensity() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        return metrics.density;
    }

}
