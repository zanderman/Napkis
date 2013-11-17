package com.jCAF.napkis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lndsharkfury on 11/17/13.
 */
public class DetailActivity  extends Base_Activity {



        @Override
        public void onCreate(Bundle savedInstanceState) {

//            LinearLayout dl = (LinearLayout) getLayoutInflater().inflate(R.layout.details_layout, null);
//            dl.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));

            super.onCreate(savedInstanceState);
            setContentView(R.layout.details_layout);

            Intent intent = getIntent();
            String number = intent.getStringExtra("table_number");

            TextView numberTextView = (TextView) findViewById(R.id.table_number);
            numberTextView.setText(number);
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
