package com.example.mayank.bitotsav;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {
    private boolean swipeable = false;

    public CustomViewPager(Context context) {
        super(context);
    }
    public void setSwipeable(boolean swipeable) {
        this.swipeable = swipeable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return (this.swipeable) ? super.onInterceptTouchEvent(arg0) : false;
    }
}
