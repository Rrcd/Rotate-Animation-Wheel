package com.example.rotateanimationwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottolImageView;
    private TextView bottolTextView, result;
    private Random bottolRandomNumber = new Random();
    private int lastDirection;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottolImageView = findViewById(R.id.bottolImageViewId);
        bottolTextView = findViewById(R.id.bottolTextViewId);
        result = findViewById(R.id.resultId);

        final Button bottolButton = findViewById(R.id.bottolButtonId);

        bottolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newDuration = bottolRandomNumber.nextInt(3600) + 360;
                float provitX = (float) bottolImageView.getWidth()/ 2;
                float provitY = (float) bottolImageView.getHeight()/ 2;

                Animation rotate = new RotateAnimation(lastDirection, newDuration, provitX, provitY);
                rotate.setDuration(9000);
                rotate.setFillAfter(true);

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        bottolButton.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        bottolButton.setEnabled(true);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                lastDirection = newDuration;

                bottolImageView.startAnimation(rotate);

            }
        });

    }
}