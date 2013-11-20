package com.jCAF.napkis;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.sendgrid.SendGrid;



/**
 * Created by lndsharkfury on 11/17/13.
 */
public class DetailActivity  extends Base_Activity {

    SendGrid sendgrid = new SendGrid("zanderman", "VTech2012");

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.details_layout);

            Intent intent = getIntent();
            String number = intent.getStringExtra("table_number");

            TextView numberTextView = (TextView) findViewById(R.id.table_number);
            numberTextView.setText(number);
        }


    // Send receipt using SendGrid
    public void sendEmail(View view) {
        sendgrid.addTo("acd1797@vt.edu");
        sendgrid.addToName("Example Guy");
        sendgrid.setFrom("other@example.com");
        sendgrid.setSubject("Hello World");
        sendgrid.setText("My first email through SendGrid");
        sendgrid.send();
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





//    private class SendEmailTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground()
//    }


}
