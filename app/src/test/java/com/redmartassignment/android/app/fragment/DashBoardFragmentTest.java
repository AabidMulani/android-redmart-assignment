package com.redmartassignment.android.app.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.redmartassignment.android.app.presenters.DashboardPresenter;
import com.redmartassignment.android.app.services.DashBoardService;
import com.redmartassignment.android.app.views.DashboardView;
import com.redmartassignment.android.callbackInterfaces.GetProductsListener;
import com.redmartassignment.android.responseModels.productList.Product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DashBoardFragmentTest {


    @Mock
    private List<Product> productsList;
    @Mock
    Product product;
    @Mock
    DashboardView dashboardView;
    @Mock
    DashBoardService dashBoardService;
    @Mock
    Context context;
    @Mock
    Activity activity;
    @Mock
    View imageView;
    @Mock
    View amountView;
    @Mock
    RecyclerView recyclerView;
    @Mock
    GetProductsListener getProductsListener;

    DashboardPresenter dashboardPresenter;


    @Before
    public void setUp() throws Exception {
        dashboardPresenter = new DashboardPresenter(context, dashBoardService, dashboardView, recyclerView);
    }

    @Test
    public void testForMainProductListingSuccessCase() throws Exception {
        dashboardPresenter.loadProducts();
        verify(dashboardView, atLeastOnce()).showMainProgressBar();
        verify(dashBoardService, atLeastOnce()).getProductList(0, dashboardPresenter.getProductsListener);
    }

    @Test
    public void testForMainProductListingErrorCase() throws Exception {
        dashboardPresenter.getProductsListener.onProductListError("something wrong");
        verify(dashboardView, atLeastOnce()).showThisErrorMsg("something wrong");
    }

    @Test
    public void testForProductClickedFlow() throws Exception {
        dashboardPresenter.onProductClicked(activity, product, imageView, amountView);
        dashboardView.callDetailViewForThisProduct(any(Intent.class), any(ActivityOptionsCompat.class));
    }


    @Test
    public void testForLoadMoreScroller() throws Exception {
        when(dashboardView.getLayoutManager()).thenReturn(new GridLayoutManager(activity, 3));
        when(dashboardView.isLoading()).thenReturn(false);
        dashboardPresenter.recyclerViewOnScrollListener.onScrolled(recyclerView, 1, 1);
        verify(dashBoardService, atLeastOnce()).getProductList(0, dashboardPresenter.getProductsListener);
    }


    @Test
    public void testForCurrentLoadingOnCase() throws Exception {
        when(dashboardView.getLayoutManager()).thenReturn(new GridLayoutManager(activity, 3));
        when(dashboardView.isLoading()).thenReturn(true);
        dashboardPresenter.recyclerViewOnScrollListener.onScrolled(recyclerView, 1, 1);
        verify(dashBoardService, never()).getProductList(1, dashboardPresenter.getProductsListener);
    }



    @Test
    public void testForPageCountCompleteForLoadMoreCase() throws Exception {
        when(dashboardView.getLayoutManager()).thenReturn(new GridLayoutManager(activity, 3));
        when(dashboardView.isLoading()).thenReturn(true);
        dashboardPresenter.isLastPage = true;
        dashboardPresenter.recyclerViewOnScrollListener.onScrolled(recyclerView, 1, 1);
        verify(dashBoardService, never()).getProductList(1, dashboardPresenter.getProductsListener);
    }


}