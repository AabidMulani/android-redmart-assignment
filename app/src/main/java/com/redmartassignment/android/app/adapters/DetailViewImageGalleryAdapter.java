package com.redmartassignment.android.app.adapters;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.redmartassignment.android.R;
import com.redmartassignment.android.responseModels.productList.Image;
import com.redmartassignment.android.utils.AppConstants;
import com.redmartassignment.android.utils.Utils;
import com.redmartassignment.android.widgets.SquareImageView;

import java.util.List;

public class DetailViewImageGalleryAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Image> imageList;

    public DetailViewImageGalleryAdapter(Context context, List<Image> imageList) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_image_gallery, container, false);
        SquareImageView imageView = (SquareImageView) itemView.findViewById(R.id.productImageView);
        Utils.loadThisImage(context, AppConstants.getImageUrl(imageList.get(position).getName()), imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
