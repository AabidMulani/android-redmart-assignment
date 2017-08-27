package com.redmartassignment.android.app.presenters;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.redmartassignment.android.app.activities.RedMartProductDetailsActivity;
import com.redmartassignment.android.app.services.DashBoardService;
import com.redmartassignment.android.app.views.DashboardView;
import com.redmartassignment.android.callbackInterfaces.GetProductsListener;
import com.redmartassignment.android.responseModels.productList.Product;
import com.redmartassignment.android.responseModels.productList.ProductListResponse;

import timber.log.Timber;


public class DashboardPresenter {

    Context context;
    DashBoardService dashBoardService;
    DashboardView dashboardView;
    int pageCounter;
    public boolean isLastPage;

    public DashboardPresenter(Context context, DashBoardService dashBoardService, DashboardView dashboardView, RecyclerView recyclerView) {
        this.context = context;
        this.dashBoardService = dashBoardService;
        this.dashboardView = dashboardView;
        pageCounter = 0;
        isLastPage = false;
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);
        makeGetProductsRequest();
    }

    private void makeGetProductsRequest() {
        Timber.d("-- makeGetProductsRequest --");
        if (pageCounter == 0) {
            dashboardView.showMainProgressBar();
        } else {
            dashboardView.showFooterLoader();
        }
        dashBoardService.getProductList(pageCounter, getProductsListener);
    }

    public void loadProducts() {
        Timber.d("-- loadProducts --");
        pageCounter++;
        makeGetProductsRequest();
    }

    public void onProductClicked(Activity activity, Product product, View imageView, View amountView) {
        Timber.d("-- onProductClicked --");
        Intent intent = new Intent(activity, RedMartProductDetailsActivity.class);
        intent.putExtra("product", product);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, new Pair<View, String>(imageView, "productImage"),
                new Pair<View, String>(amountView, "productName"));
        dashboardView.callDetailViewForThisProduct(intent, activityOptions);
    }

    public GetProductsListener getProductsListener = new GetProductsListener() {
        @Override
        public void onProductListSuccess(ProductListResponse productsListResponse) {
            if (productsListResponse.getProducts().size() > 0) {
                isLastPage = false;
            } else {
                isLastPage = true;
            }
            dashboardView.showOrUpdateRecyclerView(productsListResponse.getProducts());
        }

        @Override
        public void onProductListError(String errorMsg) {
            isLastPage = true;
            dashboardView.showThisErrorMsg(errorMsg);
        }
    };


    public RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = dashboardView.getLayoutManager().getChildCount();
            int totalItemCount = dashboardView.getLayoutManager().getItemCount();
            int firstVisibleItemPosition = dashboardView.getLayoutManager().findFirstVisibleItemPosition();

            if (!dashboardView.isLoading() && !isLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= dashboardView.getPageCount()) {
                    loadProducts();
                }
            }
        }
    };
}
