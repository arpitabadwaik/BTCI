package com.bynry.bpal.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;

import com.bynry.bpal.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    // array of integers for images IDs
    private Integer[] mImageIds = { R.drawable.ic_action_image_1,
            R.drawable.ic_action_image_2, R.drawable.ic_action_image_3
    };

    // constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mImageIds[i]);
        imageView.setLayoutParams(new Gallery.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }
}
