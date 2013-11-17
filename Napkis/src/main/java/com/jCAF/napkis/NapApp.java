package com.jCAF.napkis;


import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.lang.Override;import java.lang.String;import java.lang.Void;import java.util.ArrayList;
import java.util.List;

public class NapApp extends Application
{
    final static String URLadd = "http://www.napkis.com/add/menuitem/";
    //final static String URLget = "http://www.napkis.com/get/menuitem/";

    private static final String TAG = "HTTP";

    String name;
    String meal;
    String price;

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i(TAG, "Created");
    }

    public class sendHttp extends AsyncTask <String, Void, Void>
    {
        public sendHttp()
        {
            Log.i(TAG, "constructor");
        }

        @Override
        public Void doInBackground(String... fields)
        {
            Log.i(TAG, "Post1");
            int first, second, third;
            String items = fields[0];

            first = items.indexOf(":", 0) + 1;
            second = items.indexOf(":", first+1)+1;
            third = items.indexOf(":", second+1)+1;

            name = items.substring(first, second-1);
            meal = items.substring(second, third-1);
            price = items.substring(third, items.length()-1);

            Log.i(TAG, "Begin");

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(URLadd);
            try
            {
                List<NameValuePair> nameVals = new ArrayList<NameValuePair>();
                nameVals.add(new BasicNameValuePair("name", name));
                nameVals.add(new BasicNameValuePair("meal", meal));
                nameVals.add(new BasicNameValuePair("price", price));

                httppost.setEntity(new UrlEncodedFormEntity(nameVals, "utf-8"));
                HttpResponse res = httpClient.execute(httppost);

                Log.i(TAG, "data: " + nameVals.toString());
                Log.i(TAG, "Status: " + res.getStatusLine().getStatusCode());
            }
            catch (ClientProtocolException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            Log.i(TAG, "Finished Send");
        }
    }
}
