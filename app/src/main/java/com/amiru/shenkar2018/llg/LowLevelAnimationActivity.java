package com.amiru.shenkar2018.llg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.amiru.shenkar2018.R;

public class LowLevelAnimationActivity extends AppCompatActivity {

    AnimatedView animatedView;
    //    EditText angle;
    SeekBar seekBar;

    TextView angleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_level_animation);
        animatedView = findViewById(R.id.animatedView);
//        angle = findViewById(R.id.angle);
        seekBar = findViewById(R.id.seekBar2);
        angleTv = findViewById(R.id.angleTv);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
//                textView.setText("" + progress);
//                textView.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                //textView.setY(100); just added a value set this properly using screen with height aspect ratio , if you do not set it by default it will be there below seek bar
                angleTv.setText("" + progress);
                onShoot(null);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

    public void onShoot(View view) {
        // start logic flow for the view
        animatedView.setT0(System.currentTimeMillis());
        animatedView.setAngle(Float.valueOf(angleTv.getText().toString()));
        animatedView.setV0(100);
    }
}
