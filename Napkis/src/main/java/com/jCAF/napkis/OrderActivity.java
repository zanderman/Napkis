package com.jCAF.napkis;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by lndsharkfury on 11/16/13.
 */
public class OrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);

//        ImageView welcomeImage = (ImageView) findViewById(R.id.welcome_image);
//        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
//        welcomeImage.startAnimation(hyperspaceJumpAnimation);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
