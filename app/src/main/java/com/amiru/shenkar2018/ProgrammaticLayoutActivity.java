package com.amiru.shenkar2018;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.amiru.shenkar2018.llg.StaticView;

/**
 * If your game will be based on layout with layout transitions - this example can be a good reference.
 * This class demonstrates building a constraint layout without XML
 * It also demonstrates layout transitions without using scenes.
 * <p>
 * -au
 */
public class ProgrammaticLayoutActivity extends AppCompatActivity {
    ConstraintLayout mConstraintLayout;
    private int mCornerId;

    /**
     * use such a method to calculate translation from px to dp
     * - so element size will be roughly similar between devices.
     */
    public static float dpToPx(final float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatic_layout);
        mConstraintLayout = findViewById(R.id.rootLayout);

        addBottomRightTextView();

        final int centerView = addCenterView();

        final View cornerView = addCornerViewTo(centerView);

        final Transition mTransition = new ChangeBounds();
        mTransition.setDuration(1000); // todo: make the duration a function of the distance

        // types of Interpolators:
        // -----------------------
        // AccelerateDecelerateInterpolator, AccelerateInterpolator, AnticipateInterpolator,
        // AnticipateOvershootInterpolator, BounceInterpolator, CycleInterpolator,
        // DecelerateInterpolator, LinearInterpolator, OvershootInterpolator, PathInterpolator
        mTransition.setInterpolator(new BounceInterpolator());
        final ConstraintSet set = new ConstraintSet();

        mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // applies the current state
                set.clone(mConstraintLayout);

                mCornerId = (mCornerId + 1) % 4;

                attachToCorner(set, cornerView.getId(), centerView, mCornerId);

                set.applyTo(mConstraintLayout);

                TransitionManager.beginDelayedTransition(mConstraintLayout, mTransition);
            }
        });

    }

    /**
     * @param cornerId 0 = top left, 1 = top right, 2 = bottom right, 3 = bottom left
     */
    private void attachToCorner(ConstraintSet set, @IdRes int vId, @IdRes int toViewId, int cornerId) {

        // more layout params:
        // https://developer.android.com/reference/android/support/constraint/ConstraintLayout.LayoutParams.html

        // right-left
        if (cornerId == 0 || cornerId == 3) {
            // left
            // The following breaks the old connection.
            set.clear(vId, ConstraintSet.START);
            set.connect(vId, ConstraintSet.END, toViewId, ConstraintSet.START, 8);
        } else {
            // right
            set.clear(vId, ConstraintSet.END);
            set.connect(vId, ConstraintSet.START, toViewId, ConstraintSet.END, 8);
        }

        if (cornerId == 1 || cornerId == 0) {
            // top
            set.clear(vId, ConstraintSet.TOP);
            set.connect(vId, ConstraintSet.BOTTOM, toViewId, ConstraintSet.TOP, 8);
        } else {
            // bottom
            set.clear(vId, ConstraintSet.BOTTOM);
            set.connect(vId, ConstraintSet.TOP, toViewId, ConstraintSet.BOTTOM, 8);
        }
    }

    /**
     * example for adding a custom view
     * to the center of the parent view
     * with some fixed size
     */
    private int addCenterView() {
        // remember the first constructor of StaticView? It's exactly for this kind of use:
        StaticView centerView = new StaticView(this);

        int size = (int) (dpToPx(100));

        centerView.setId(View.generateViewId());
        ConstraintSet set = createConstraintSet(centerView.getId(),
                size, size);

        // pin to the center of the container
        set.centerHorizontally(centerView.getId(), R.id.rootLayout);
        set.centerVertically(centerView.getId(), R.id.rootLayout);

        // add the view to the container!!
        mConstraintLayout.addView(centerView);

        // Apply the changes
        set.applyTo(mConstraintLayout);

        return centerView.getId();
    }

    /**
     * example for adding a view with its location relative to another view
     */
    private View addCornerViewTo(@IdRes int otherViewId) {
        // remember the first constructor of StaticView? It's exactly for this kind of use:
        View thisView = new View(this);
        thisView.setBackgroundColor(getResources().getColor(R.color.cornerView));

        thisView.setId(View.generateViewId());
        ConstraintSet set = createConstraintSet(thisView.getId(), 50, 50);
        mCornerId = 0;
        // pin to the center of the container
        attachToCorner(set, thisView.getId(), otherViewId, mCornerId);

        // add the view to the container!!
        mConstraintLayout.addView(thisView);

        // Apply the changes
        set.applyTo(mConstraintLayout);

        return thisView;

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
        mConstraintLayout.addView(bottomRightTv);

        // Apply the changes
        set.applyTo(mConstraintLayout);
    }

    /**
     * Notice that the width and height can be a fixed size in pixels, or one of the "magic numbers"
     * i.e. ConstraintSet.WRAP_CONTENT, ConstraintSet.MATCH_PARENT, etc...
     */
    private ConstraintSet createConstraintSet(@IdRes int viewId, int width, int height) {
        ConstraintSet set = new ConstraintSet();
        set.constrainHeight(viewId, height);
        set.constrainWidth(viewId, width);
        return set;
    }
}
