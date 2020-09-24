package com.andoiddevop.animationassets.view.activity.splashExample.DeliverySplashScreen;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.andoiddevop.animationassets.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeliverySplashScreen extends AppCompatActivity {

    @BindView(R.id.textViewFoodDelivery)
    TextView textViewFoodDelivery;

    @BindView(R.id.imageviewDeliveryBoy)
    ImageView imageviewDeliveryBoy;

    @BindView(R.id.textViewSlogan)
    TextView textViewSlogan;

    Animation image_in,image_out,text_in,text_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_splash_screen);
        ButterKnife.bind(this);

        image_in = AnimationUtils.loadAnimation(this, R.anim.deliveryboy_image_in);
        image_out = AnimationUtils.loadAnimation(this, R.anim.deliveryboy_image_out);
        text_in = AnimationUtils.loadAnimation(this, R.anim.delivery_text_in);
        text_out = AnimationUtils.loadAnimation(this, R.anim.delivery_text_out);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startEnterAnimation();
            }
        },1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startExitAnimation();
            }
        },3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        },5000);
    }

    private void startExitAnimation() {

        imageviewDeliveryBoy.setAnimation(image_out);
        textViewFoodDelivery.setAnimation(text_out);
        textViewSlogan.setAnimation(text_out);
        imageviewDeliveryBoy.setVisibility(View.GONE);
        textViewFoodDelivery.setVisibility(View.GONE);
        textViewSlogan.setVisibility(View.GONE);
    }

    private void startEnterAnimation() {
        imageviewDeliveryBoy.setAnimation(image_in);
        textViewFoodDelivery.setAnimation(text_in);
        textViewSlogan.setAnimation(text_in);
        imageviewDeliveryBoy.setVisibility(View.VISIBLE);
        textViewFoodDelivery.setVisibility(View.VISIBLE);
        textViewSlogan.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}