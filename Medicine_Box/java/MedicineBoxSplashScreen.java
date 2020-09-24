package com.andoiddevop.animationassets.view.activity.splashExample.MedicineBox;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.andoiddevop.animationassets.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MedicineBoxSplashScreen extends AppCompatActivity {

    @BindView(R.id.imageViewCapsule)
    ImageView imageViewCapsule;
    @BindView(R.id.textViewMedicalBox)
    TextView textViewMedicalBox;

    private boolean isFirstAnimation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicinebox_splash_screen);
        ButterKnife.bind(this);

         /*Simple hold animation to hold ImageView in the centre of the screen at a slightly larger
        scale than the ImageView's original one.*/
        Animation hold = AnimationUtils.loadAnimation(this, R.anim.hold);

        /* Translates ImageView from current position to its original position, scales it from
        larger scale to its original scale.*/
        final Animation translateScale = AnimationUtils.loadAnimation(this, R.anim.translate_scale);


        ObjectAnimator flip = ObjectAnimator.ofFloat(imageViewCapsule, "rotationY", 720f, 0f);
        flip.setDuration(2500);
        flip.start();


       translateScale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isFirstAnimation) {
                    imageViewCapsule.clearAnimation();
                    textViewMedicalBox.clearAnimation();
                    Intent intent = new Intent(MedicineBoxSplashScreen.this, MedicineBox_LoginActivity.class);
                    imageViewCapsule.setVisibility(View.GONE);
                    textViewMedicalBox.setVisibility(View.GONE);
                    startActivity(intent);
                    finish();
                }

                isFirstAnimation = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        hold.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageViewCapsule.clearAnimation();
                textViewMedicalBox.clearAnimation();
                imageViewCapsule.startAnimation(translateScale);
                textViewMedicalBox.setAnimation(translateScale);
                imageViewCapsule.setVisibility(View.GONE);
                textViewMedicalBox.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageViewCapsule.startAnimation(hold);
        textViewMedicalBox.setAnimation(hold);
    }

}