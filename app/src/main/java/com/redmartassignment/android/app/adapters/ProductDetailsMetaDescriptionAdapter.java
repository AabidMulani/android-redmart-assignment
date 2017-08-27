package com.redmartassignment.android.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redmartassignment.android.R;
import com.redmartassignment.android.responseModels.productList.Primary;
import com.redmartassignment.android.widgets.RobotoTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailsMetaDescriptionAdapter extends RecyclerView.Adapter<ProductDetailsMetaDescriptionAdapter.ProductDescriptionViewHolder> {
    private List<Primary> descriptiopDataList;
    private Context context;

    public ProductDetailsMetaDescriptionAdapter(Activity activity, List<Primary> descriptiopDataList) {
        this.descriptiopDataList = descriptiopDataList;
        this.context = activity;
    }


    @Override
    public ProductDescriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_details_meta_desc, parent, false);
        return new ProductDescriptionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProductDescriptionViewHolder holder, final int position) {

        final Primary descriptionData = descriptiopDataList.get(position);

        holder.titleTextView.setText(descriptionData.getName());
        holder.descTextView.setText(descriptionData.getContent());

    }


    @Override
    public int getItemCount() {
        return descriptiopDataList.size();
    }

    class ProductDescriptionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleTextView)
        RobotoTextView titleTextView;
        @BindView(R.id.descTextView)
        RobotoTextView descTextView;

        ProductDescriptionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

