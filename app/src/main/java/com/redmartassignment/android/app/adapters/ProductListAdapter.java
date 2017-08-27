package com.redmartassignment.android.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.redmartassignment.android.R;
import com.redmartassignment.android.callbackInterfaces.OnProductClickListener;
import com.redmartassignment.android.responseModels.productList.Product;
import com.redmartassignment.android.utils.AppConstants;
import com.redmartassignment.android.utils.Utils;
import com.redmartassignment.android.widgets.RobotoTextView;
import com.redmartassignment.android.widgets.SquareImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int LOADING_VIEW = 1;
    private static final int ITEM_VIEW = 2;
    private List<Product> discoverDataTables;
    private Context context;
    private OnProductClickListener productClickListener;
    private boolean isLoadingAdded;

    public ProductListAdapter(Activity activity, List<Product> discoverDataTables, OnProductClickListener productClickListener) {
        this.discoverDataTables = discoverDataTables;
        this.context = activity;
        this.productClickListener = productClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LOADING_VIEW) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer_product_list_loader, null);
            return new ProgressBarFooterViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_list, null);
            return new ProductListViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holderObject, final int position) {

        if (holderObject instanceof ProductListViewHolder) {
            final ProductListViewHolder holder = (ProductListViewHolder) holderObject;
            final Product productData = discoverDataTables.get(position);

            Utils.loadThisImage(context, AppConstants.getImageUrl(productData.getImg().getName()), holder.productImageView);
            holder.productTitleTextView.setText(productData.getTitle());

            if (productData.getPricing() != null) {
                holder.priceMainTextView.setVisibility(View.VISIBLE);
                if (productData.getPricing().getPromoPrice() != null && productData.getPricing().getPromoPrice() > 0) {
                    holder.priceOriginalTextView.setVisibility(View.VISIBLE);
                    holder.priceMainTextView.setText(Utils.formatAmountToString(productData.getPricing().getPromoPrice()));
                    holder.priceOriginalTextView.setText(Utils.formatAmountToString(productData.getPricing().getPrice()));
                    holder.priceOriginalTextView.setPaintFlags(holder.priceOriginalTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    holder.priceOriginalTextView.setVisibility(View.GONE);
                    holder.priceMainTextView.setText(Utils.formatAmountToString(productData.getPricing().getPrice()));
                }

                if (productData.getPricing().getSavingsText() != null) {
                    holder.promoTextView.setVisibility(View.VISIBLE);
                    holder.promoTextView.setText(productData.getPricing().getSavingsText());
                    if (productData.getPricing().getSavingsType() != null) {
                        int colorResId;
                        if (productData.getPricing().getSavingsType() == 1) {
                            colorResId = R.color.promoType_1;
                        } else if (productData.getPricing().getSavingsType() == 2) {
                            colorResId = R.color.promoType_2;
                        } else {
                            colorResId = R.color.promoType_others;
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            holder.promoTextView.setBackgroundColor(context.getColor(colorResId));
                        } else {
                            holder.promoTextView.setBackgroundColor(context.getResources().getColor(colorResId));
                        }
                    }
                } else {
                    holder.promoTextView.setVisibility(View.GONE);
                }

            } else {
                holder.priceMainTextView.setVisibility(View.GONE);
            }

            if (productData.getMeasure() != null && productData.getMeasure().getWtOrVol() != null) {
                holder.sizeDetailsTextView.setText(productData.getMeasure().getWtOrVol());
            }

            if (productData.getCurrentCartCounter() == 0) {
                holder.addToCartTextView.setVisibility(View.VISIBLE);
                holder.addToCartBottomLayout.setVisibility(View.GONE);
                holder.productMainCardView.setCardBackgroundColor(Color.WHITE);
            } else {
                holder.addToCartTextView.setVisibility(View.GONE);
                holder.addToCartBottomLayout.setVisibility(View.VISIBLE);
                holder.cartCountTextView.setText(String.valueOf(productData.getCurrentCartCounter()));
                holder.productMainCardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            }


            holder.cartMinusTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    productData.setCurrentCartCounter(productData.getCurrentCartCounter() - 1);
                    productClickListener.onAddToCartCounterChanged(productData, productData.getCurrentCartCounter(), false);
                    notifyItemChanged(position);
                }
            });

            holder.cartAddTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    productData.setCurrentCartCounter(productData.getCurrentCartCounter() + 1);
                    productClickListener.onAddToCartCounterChanged(productData, productData.getCurrentCartCounter(), true);
                    notifyItemChanged(position);
                }
            });


            holder.addToCartTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    productData.setCurrentCartCounter(1);
                    productClickListener.onAddToCartCounterChanged(productData, 1, true);
                    notifyItemChanged(position);
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    productClickListener.onProductClicked(productData, holder.productImageView, holder.productTitleTextView);
                }
            });
        } else {
            ProgressBarFooterViewHolder holder = (ProgressBarFooterViewHolder) holderObject;
            // do nothing
            holder.progressBar.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return (position == discoverDataTables.size() - 1 && isLoadingAdded) ? LOADING_VIEW : ITEM_VIEW;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        discoverDataTables.add(new Product());
        notifyItemInserted(discoverDataTables.size() - 1);
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = discoverDataTables.size() - 1;
        Product item = discoverDataTables.get(position);

        if (item != null) {
            discoverDataTables.remove(position);
            notifyItemRemoved(position);
        }
    }

    public List<Product> getDiscoverDataTables() {
        return discoverDataTables;
    }

    @Override
    public int getItemCount() {
        return discoverDataTables.size();
    }

    class ProductListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.productImageView)
        SquareImageView productImageView;
        @BindView(R.id.productMainCardView)
        CardView productMainCardView;
        @BindView(R.id.promoTextView)
        RobotoTextView promoTextView;
        @BindView(R.id.productTitleTextView)
        RobotoTextView productTitleTextView;
        @BindView(R.id.sizeDetailsTextView)
        RobotoTextView sizeDetailsTextView;
        @BindView(R.id.priceMainTextView)
        RobotoTextView priceMainTextView;
        @BindView(R.id.priceOriginalTextView)
        RobotoTextView priceOriginalTextView;
        @BindView(R.id.cartMinusTextView)
        ImageView cartMinusTextView;
        @BindView(R.id.cartCountTextView)
        RobotoTextView cartCountTextView;
        @BindView(R.id.cartAddTextView)
        ImageView cartAddTextView;
        @BindView(R.id.addToCartBottomLayout)
        RelativeLayout addToCartBottomLayout;
        @BindView(R.id.addToCartTextView)
        RobotoTextView addToCartTextView;

        ProductListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ProgressBarFooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressBar)
        ProgressBar progressBar;

        ProgressBarFooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

