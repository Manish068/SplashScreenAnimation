package com.andoiddevop.animationassets.view.activity.splashExample.HeartBeatScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.andoiddevop.animationassets.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class HeartBeatSplashScreen extends AppCompatActivity {

    //Initialize variable
    ImageView ivTop, ivHeart,ivBeat,ivBottom;
    TextView textViewHeartBeat;

    Handler handler = new Handler();
    CharSequence charSequence;
    int index;
    long delay = 200;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beat_splash_screen);

        //Assign Variable
        ivTop = findViewById(R.id.iv_Top);
        ivHeart = findViewById(R.id.iv_heart);
        ivBeat = findViewById(R.id.iv_HeartBeat);
        ivBottom = findViewById(R.id.iv_bottom);
        textViewHeartBeat = findViewById(R.id.textView_HeartBeat);

        //set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Initialize top animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.top_wave);
        ivTop.setAnimation(animation1);


        //Initialize Bottom Animation
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.bottom_wave);
        ivBottom.setAnimation(animation2);

        ObjectAnimator objectAnimator =
                ObjectAnimator.ofPropertyValuesHolder(ivHeart,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f));

        //set Duration
        objectAnimator.setDuration(500);
        //set Repeat count
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //set Repeat mode
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //start
        objectAnimator.start();


        //set animate text
        animatText("HeartBeat");

        //Load Gif
        Glide
                .with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/demoapp-ae96a.appspot.com/o/heart_beat.gif?alt=media&token=b21dddd8-782c-457c-babd-f2e922ba172b")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivBeat);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //set text
            textViewHeartBeat.setText(charSequence.subSequence(0,index++));
            //check condition
            if(index <= charSequence.length()){
                //when index is equal  to text length
                handler.postDelayed(runnable,delay);
            }
        }
    };

    public void animatText(CharSequence cs){
        //set Text
        charSequence = cs;
        //clear index
        index = 0;
        //Clear Text
        textViewHeartBeat.setText("");
        //Remove call back
        handler.removeCallbacks(runnable);
        //Run handler
        handler.postDelayed(runnable,delay);
    }

}