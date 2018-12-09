package com.example.mayank.bitotsav;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImagesViewPagerAdapter extends PagerAdapter {
    int[] images;
    Context context;
    LayoutInflater layoutInflater;
    public  ImagesViewPagerAdapter(Context context, int[] images){
        this.images=images;
        Log.d("as", String.valueOf(images.length));
        this.context=context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.image_view_pager, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imagesView);
        imageView.setImageResource(images[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);

    }

}

