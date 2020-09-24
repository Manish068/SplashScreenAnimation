package com.andoiddevop.animationassets.view.activity.splashExample.EbookSplashScreen;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.andoiddevop.animationassets.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EbookSplashScreen extends AppCompatActivity {


    @BindView(R.id.imageViewBookStoreBackground)
    ImageView imageViewBookStoreBackground;
    @BindView(R.id.bookStoreLogo)
    ImageView bookStoreLogo;
    @BindView(R.id.textViewAppName)
    TextView textViewAppName;
    @BindView(R.id.lottie_book_stack)
    LottieAnimationView lottieBookStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_splash_screen);
        ButterKnife.bind(this);

        imageViewBookStoreBackground.animate().translationY(-2600).setDuration(1000).setStartDelay(4000);
        bookStoreLogo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        textViewAppName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieBookStack.animate().translationY(1600).setDuration(1000).setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        },5000);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}