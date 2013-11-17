package com.jCAF.napkis;

import android.app.Activity;
import android.content.Context;
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

//    String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);

    }

   public void addCard(View view) {

       // Add text
       LinearLayout linearCardLayout = (LinearLayout) findViewById(R.id.llayout1);
       TextView newCard = (TextView) getLayoutInflater().inflate(R.layout.card_template, null);

       newCard.setAnimation(AnimationUtils.loadAnimation( this, R.anim.slide_up_right));

       linearCardLayout.addView(newCard);
   }

}
