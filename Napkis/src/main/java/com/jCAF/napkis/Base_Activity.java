package com.jCAF.napkis;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by lndsharkfury on 11/17/13.
 */
public class Base_Activity extends Activity {

    String TAG;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch(id) {
            case R.id.refresh:
                Log.i(TAG, "Refresh item clicked");
                return true;

            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
