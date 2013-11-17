package com.jCAF.napkis;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lndsharkfury on 11/16/13.
 */
public class Card_Fragment extends Fragment {

    View view;

    private static final String TAG = "FRAG";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG, "Started");
        view = inflater.inflate(R.layout.card_frag_layout, container, false);
        Log.i(TAG, "Finished");
        return view;
    }
}
