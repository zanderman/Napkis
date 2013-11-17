package com.jCAF.napkis;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by lndsharkfury on 11/17/13.
 */
public class CardLayout extends LinearLayout implements OnGlobalLayoutListener {

    public CardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayoutObserver();

    }

    public CardLayout(Context context) {
        super(context);
        initLayoutObserver();
    }

    private void initLayoutObserver() {
        setOrientation(LinearLayout.VERTICAL);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    public void onGlobalLayout() {
//        getViewTreeObserver().removeGlobalOnLayoutListener(this);
//
//        final int heightPx = getContext().getResources().getDisplayMetrics().heightPixels;
//
//        boolean inversed = false;
//        final int childCount = getChildCount();
//
//        for (int i = 0; i < childCount; i++) {
//            View child = getChildAt(i);
//
//            int[] location = new int[2];
//
//            child.getLocationOnScreen(location);
//
//            if (location[1] > heightPx) {
//                break;
//            }
//
//            // Alternates between animations.
//            if (!inversed) {
//                child.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_left));
//            } else {
//                child.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_right));
//            }
//
//            inversed = !inversed;
//        }




    }

}
