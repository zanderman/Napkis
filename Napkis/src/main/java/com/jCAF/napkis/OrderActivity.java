package com.jCAF.napkis;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    // -----------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        /*
        Find a way to place the menu bar on the bottom of the screen...
         */

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // -----------------------------------

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
