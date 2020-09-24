package com.andoiddevop.animationassets.view.activity.splashExample.SimpleSplashAnimation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.andoiddevop.animationassets.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleSplashAnimation extends AppCompatActivity {


    @BindView(R.id.firstArrow)
    View firstArrow;
    @BindView(R.id.SecondArrow)
    View SecondArrow;
    @BindView(R.id.thirdArrow)
    View thirdArrow;
    @BindView(R.id.fourthArrow)
    View fourthArrow;
    @BindView(R.id.fifthArrow)
    View fifthArrow;
    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewAppName)
    TextView textViewAppName;

    Animation top_animation,middle_animation, bottom_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);
        ButterKnife.bind(this);
        Context context = getApplicationContext();
        top_animation = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        middle_animation = AnimationUtils.loadAnimation(context,R.anim.middle_animation );
        bottom_animation = AnimationUtils.loadAnimation(context, R.anim.bottom_animation);

        firstArrow.setAnimation(top_animation);
        SecondArrow.setAnimation(top_animation);
        thirdArrow.setAnimation(top_animation);
        fourthArrow.setAnimation(top_animation);
        fifthArrow.setAnimation(top_animation);

        textViewName.setAnimation(middle_animation);
        textViewAppName.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
                finish();
            }
        },2000);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }


}


