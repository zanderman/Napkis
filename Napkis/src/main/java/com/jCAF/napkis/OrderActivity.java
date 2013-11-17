package com.jCAF.napkis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by lndsharkfury on 11/16/13.
 */
public class OrderActivity extends Activity {

    public LinearLayout linearCardLayout;
    public TextView newCard;
    public static int cardCounter = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);
    }


    // Add a new card to the view.
   public void addCard(View view) {


       // Add new card when prompted.
       linearCardLayout = (LinearLayout) findViewById(R.id.llayout1);
       newCard = (TextView) getLayoutInflater().inflate(R.layout.card_template, null);

       newCard.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up_right));

       linearCardLayout.addView(newCard);
       cardCounter++;
   }

    // Load all information pertaining to that specific order.
    public void orderDetail(View view) {

        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        cardCounter = 0;
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
