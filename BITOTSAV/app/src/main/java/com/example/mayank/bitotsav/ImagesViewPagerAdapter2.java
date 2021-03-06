package com.example.mayank.bitotsav;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImagesViewPagerAdapter2 extends PagerAdapter {

    int[] images;
    Context context;
    LayoutInflater layoutInflater;
    public  ImagesViewPagerAdapter2(Context context, int[] images){
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
        View itemView = layoutInflater.inflate(R.layout.image_view_pager2, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imagesView2);
        imageView.setImageResource(images[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);

    }
}
