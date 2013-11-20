package com.jCAF.napkis;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lndsharkfury on 11/16/13.
 */
public class OrderActivity extends Base_Activity {

    public LinearLayout linearCardLayout;
    public TextView newCard;
    public static int cardCounter = 0;
    public static String stuff = "";
//    final static String URLadd = "http://www.napkis.com/add/menuitem/";
//
//    String name;
//    String meal;
//    String price;
//
//    public class sendHttp extends AsyncTask<String, Void, Void>
//    {
//        public sendHttp()
//        {
//            Log.i(TAG, "constructor");
//        }
//
//        @Override
//        public Void doInBackground(String... fields)
//        {
//            Log.i(TAG, "Post1");
//            int first, second, third;
//            String items = fields[0];
//
//            first = items.indexOf(":", 0) + 1;
//            second = items.indexOf(":", first+1)+1;
//            third = items.indexOf(":", second+1)+1;
//
//            name = items.substring(first, second-1);
//            meal = items.substring(second, third-1);
//            price = items.substring(third, items.length()-1);
//
//            Log.i(TAG, "Begin");
//
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost(URLadd);
//            try
//            {
//                List<NameValuePair> nameVals = new ArrayList<NameValuePair>();
//                nameVals.add(new BasicNameValuePair("name", name));
//                nameVals.add(new BasicNameValuePair("meal", meal));
//                nameVals.add(new BasicNameValuePair("price", price));
//
//                httppost.setEntity(new UrlEncodedFormEntity(nameVals, "utf-8"));
//                HttpResponse res = httpClient.execute(httppost);
//
//                Log.i(TAG, "data: " + nameVals.toString());
//                Log.i(TAG, "Status: " + res.getStatusLine().getStatusCode());
//            }
//            catch (ClientProtocolException e)
//            {
//                e.printStackTrace();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid)
//        {
//            super.onPostExecute(aVoid);
//            Log.i(TAG, "Finished Send");
//        }
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch(id) {
            case R.id.refresh:
                addCard(findViewById(R.id.scrollView));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void serviceGrabber(String str)
    {
        NapApp app = new NapApp();
        NapApp.sendHttp send = app.new sendHttp();

        send.execute(str);


        stuff = str;


    }

    // Add a new card to the view.
   public void addCard(View view) {

       cardCounter++;

       // Add new card when prompted.
       linearCardLayout = (LinearLayout) findViewById(R.id.llayout1);
       newCard = (TextView) getLayoutInflater().inflate(R.layout.card_template, null);

       newCard.setId(cardCounter); // define new TAG for each order.
       newCard.setTag("" + cardCounter);
       newCard.setText("Order Number: " + cardCounter + " Entry: " + stuff);
       newCard.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up_right));

       linearCardLayout.addView(newCard);

   }

    // Load all information pertaining to that specific order.
    public void orderDetail(View view) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("table_number", "" + view.getTag()); // Grab TAG for specific order.
        startActivity(intent);
    }


}
