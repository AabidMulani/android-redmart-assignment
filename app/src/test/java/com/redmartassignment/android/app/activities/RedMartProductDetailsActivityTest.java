package com.redmartassignment.android.app.activities;

import android.content.Context;

import com.redmartassignment.android.R;
import com.redmartassignment.android.app.presenters.DetailViewPresenter;
import com.redmartassignment.android.app.services.DetailViewService;
import com.redmartassignment.android.app.views.ProductDetailsView;
import com.redmartassignment.android.responseModels.productList.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RedMartProductDetailsActivityTest {

    DetailViewService detailViewService;

    @Mock
    ProductDetailsView productDetailsView;
    @Mock
    Context context;
    @Mock
    Product product;

    DetailViewPresenter detailViewPresenter;

    @Test
    public void checkIfProductObjectIsNullCase() throws Exception {
        detailViewService = new DetailViewService(null);
        detailViewPresenter = new DetailViewPresenter(context, productDetailsView, detailViewService);
        detailViewPresenter.displayAllDetails();
        verify(productDetailsView, only()).showThisErrorMsg(R.string.err_productDetailsNotFound);
    }

    @Test
    public void checkIfProductObjectIsNotNullCase() throws Exception {
        detailViewService = new DetailViewService(product);
        detailViewPresenter = new DetailViewPresenter(context, productDetailsView, detailViewService);
        detailViewPresenter.displayAllDetails();
        verify(productDetailsView, never()).showThisErrorMsg(R.string.err_productDetailsNotFound);
    }

    @Test
    public void checkIfTitleDisplayerCorrectly() throws Exception {
        // here we can get an actual object of Product (from a JSON raw file and make assert test cases with the known values)

        detailViewService = new DetailViewService(product);
        detailViewPresenter = new DetailViewPresenter(context, productDetailsView, detailViewService);
        when(product.getTitle()).thenReturn("");
        detailViewPresenter.displayAllDetails();
        verify(productDetailsView, atLeastOnce()).updateTitleAndSizeDetails("", null);
    }

    @Test
    public void checkIfImageAdapterInvokedCorrectly() throws Exception {
        // here we can get an actual object of Product (from a JSON raw file and make assert test cases with the known values)
        detailViewService = new DetailViewService(product);
        detailViewPresenter = new DetailViewPresenter(context, productDetailsView, detailViewService);
        detailViewPresenter.displayAllDetails();
        verify(productDetailsView, never()).updateImageGallery(null);
    }

    @Test
    public void checkForAddToCartCorrectlyHandled() throws Exception {
        // here we can get an actual object of Product (from a JSON raw file and make assert test cases with the known values)
        detailViewService = new DetailViewService(product);
        detailViewPresenter = new DetailViewPresenter(context, productDetailsView, detailViewService);
        detailViewPresenter.onAddToCartClicked();
        verify(productDetailsView, only()).showThisErrorMsg(R.string.err_addToCartPending);
    }

    @Test
    public void checkForSaveToListCorrectlyHandled() throws Exception {
        // here we can get an actual object of Product (from a JSON raw file and make assert test cases with the known values)
        detailViewService = new DetailViewService(product);
        detailViewPresenter = new DetailViewPresenter(context, productDetailsView, detailViewService);
        detailViewPresenter.onSaveToListClicked();
        verify(productDetailsView, only()).showThisErrorMsg(R.string.err_saveToListPending);
    }

}