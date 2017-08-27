package com.redmartassignment.android.app.activities;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.redmartassignment.android.BaseActivity;
import com.redmartassignment.android.R;
import com.redmartassignment.android.app.adapters.DetailViewImageGalleryAdapter;
import com.redmartassignment.android.app.adapters.ProductDetailsMetaDescriptionAdapter;
import com.redmartassignment.android.app.presenters.DetailViewPresenter;
import com.redmartassignment.android.app.services.DetailViewService;
import com.redmartassignment.android.app.views.ProductDetailsView;
import com.redmartassignment.android.responseModels.productList.Image;
import com.redmartassignment.android.responseModels.productList.Primary;
import com.redmartassignment.android.responseModels.productList.Product;
import com.redmartassignment.android.utils.Utils;
import com.redmartassignment.android.widgets.RobotoTextView;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;


public class RedMartProductDetailsActivity extends BaseActivity implements ProductDetailsView {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageViewPager)
    ViewPager imageViewPager;
    @BindView(R.id.indicator)
    CirclePageIndicator indicator;
    @BindView(R.id.productTitleTextView)
    RobotoTextView productTitleTextView;
    @BindView(R.id.sizeDetailsTextView)
    RobotoTextView sizeDetailsTextView;
    @BindView(R.id.priceMainTextView)
    RobotoTextView priceMainTextView;
    @BindView(R.id.priceOriginalTextView)
    RobotoTextView priceOriginalTextView;
    @BindView(R.id.promoTextView)
    RobotoTextView promoTextView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private DetailViewPresenter detailViewPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.d("-- onCreate --");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Product selectedProduct = (Product) getIntent().getParcelableExtra("product");

        // recycler view layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        detailViewPresenter = new DetailViewPresenter(activity, this, new DetailViewService(selectedProduct));
        detailViewPresenter.displayAllDetails();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.addToCartTextView)
    public void onAddToCartTextViewClick() {
        Timber.d("-- onAddToCartTextViewClick --");
        detailViewPresenter.onAddToCartClicked();
    }

    @OnClick(R.id.saveToListTextView)
    public void onSaveToListTextViewClick() {
        Timber.d("-- onSaveToListTextViewClick --");
        detailViewPresenter.onSaveToListClicked();
    }

    @Override
    public void updateTitleAndSizeDetails(String productName, String productDetails) {
        Timber.d("-- updateTitleAndSizeDetails --");
        getSupportActionBar().setTitle(productName);
        productTitleTextView.setText(productName);
        if (productDetails != null) {
            sizeDetailsTextView.setText(productDetails);
        }
        sizeDetailsTextView.setVisibility(productDetails == null ? View.GONE : View.VISIBLE);
    }

    @Override
    public void updateAmountDetails(String currentAmount, String originalAmount, String savingMsg, int savingBgColor) {
        Timber.d("-- updateAmountDetails --");
        if (originalAmount != null) {
            priceOriginalTextView.setText(originalAmount);
            priceOriginalTextView.setPaintFlags(priceOriginalTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        if (savingMsg != null) {
            promoTextView.setText(savingMsg);
            promoTextView.setBackgroundColor(getResources().getColor(savingBgColor));
        }

        priceMainTextView.setText(currentAmount);
        priceOriginalTextView.setVisibility(originalAmount == null ? View.GONE : View.VISIBLE);
        promoTextView.setVisibility(savingMsg == null ? View.GONE : View.VISIBLE);

    }

    @Override
    public void updateImageGallery(List<Image> images) {
        Timber.d("-- updateImageGallery --");
        for (Image image : images) {
            Timber.e("-- updateImageGallery: " + image.getName());
        }
        imageViewPager.setAdapter(new DetailViewImageGalleryAdapter(activity, images));
        indicator.setViewPager(imageViewPager);
        indicator.setVisibility(images.size() > 1 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void updateProductMetaDescriptions(List<Primary> metaDetailsList) {
        Timber.d("-- updateProductMetaDescriptions --");
        recyclerView.setAdapter(new ProductDetailsMetaDescriptionAdapter(activity, metaDetailsList));
    }

    @Override
    public void showThisErrorMsg(int stringResourceId) {
        Timber.d("-- showThisErrorMsg --");
        Utils.showShortToast(activity, getString(stringResourceId));
    }
}
