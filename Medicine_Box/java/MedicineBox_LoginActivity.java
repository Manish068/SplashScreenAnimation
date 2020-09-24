package com.andoiddevop.animationassets.view.activity.splashExample.MedicineBox;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.andoiddevop.animationassets.R;
import com.google.android.material.card.MaterialCardView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MedicineBox_LoginActivity extends AppCompatActivity {


    @BindView(R.id.textViewMedicalSlogan)
    TextView textViewMedicalSlogan;
    @BindView(R.id.LoginCardContainer)
    MaterialCardView LoginCardContainer;
    @BindView(R.id.imageViewCapsule)
    ImageView imageViewCapsule;
    @BindView(R.id.textViewMedicalBox)
    TextView textViewMedicalBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_box__login);
        ButterKnife.bind(this);

        overridePendingTransition(0, 0);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        textViewMedicalSlogan.setAnimation(animation);
        LoginCardContainer.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        }, 2000);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}