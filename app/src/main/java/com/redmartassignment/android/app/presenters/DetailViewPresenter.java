package com.redmartassignment.android.app.presenters;

import android.content.Context;

import com.redmartassignment.android.R;
import com.redmartassignment.android.app.services.DetailViewService;
import com.redmartassignment.android.app.views.ProductDetailsView;
import com.redmartassignment.android.responseModels.productList.Primary;
import com.redmartassignment.android.responseModels.productList.Product;
import com.redmartassignment.android.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class DetailViewPresenter {

    private DetailViewService detailViewService;
    private ProductDetailsView productDetailsView;
    private Context context;

    public DetailViewPresenter(Context context, ProductDetailsView productDetailsView, DetailViewService detailViewService) {
        this.detailViewService = detailViewService;
        this.productDetailsView = productDetailsView;
        this.context = context;
    }

    public void displayAllDetails() {
        Timber.d("-- displayAllDetails --");
        Product selectedProduct = detailViewService.getSelectedProduct();
        if (selectedProduct == null) {
            productDetailsView.showThisErrorMsg(R.string.err_productDetailsNotFound);
            return;
        }


        productDetailsView.updateTitleAndSizeDetails(selectedProduct.getTitle(), selectedProduct.getMeasure() != null ? selectedProduct.getMeasure().getWtOrVol() : null);

        productDetailsView.updateImageGallery(selectedProduct.getImages());

        Double displayAmount = null;
        Double originalAmount = null;
        int colorResId = R.color.promoType_others;

        if (selectedProduct.getPricing() != null) {
            if (selectedProduct.getPricing().getPromoPrice() != null && selectedProduct.getPricing().getPromoPrice() > 0) {
                displayAmount = selectedProduct.getPricing().getPromoPrice();
                originalAmount = selectedProduct.getPricing().getPrice();
            } else {
                displayAmount = selectedProduct.getPricing().getPrice();
            }

            if (selectedProduct.getPricing().getSavingsType() != null) {
                if (selectedProduct.getPricing().getSavingsType() == 1) {
                    colorResId = R.color.promoType_1;
                } else if (selectedProduct.getPricing().getSavingsType() == 2) {
                    colorResId = R.color.promoType_2;
                } else {
                    colorResId = R.color.promoType_others;
                }
            }

            productDetailsView.updateAmountDetails(Utils.formatAmountToString(displayAmount), Utils.formatAmountToString(originalAmount), selectedProduct.getPricing().getSavingsText(), colorResId);
        }

        if (selectedProduct.getDescriptionFields() != null) {
            List<Primary> descList = new ArrayList<>();

            if (selectedProduct.getDescriptionFields().getPrimary() != null) {
                for (Primary primary : selectedProduct.getDescriptionFields().getPrimary()) {
                    if (!"".equals(primary.getName()) && !"".equals(primary.getContent())) {
                        descList.add(primary);
                    }
                }
            }

            if (selectedProduct.getDescriptionFields().getSecondary() != null) {
                for (Primary primary : selectedProduct.getDescriptionFields().getSecondary()) {
                    if (!"".equals(primary.getName()) && !"".equals(primary.getContent())) {
                        descList.add(primary);
                    }
                }

            }

            if (descList.size() > 0) {
                productDetailsView.updateProductMetaDescriptions(descList);
            }
        }
    }

    public void onAddToCartClicked() {
        Timber.d("-- onAddToCartClicked --");
        productDetailsView.showThisErrorMsg(R.string.err_addToCartPending);
    }


    public void onSaveToListClicked() {
        Timber.d("-- onSaveToListClicked --");
        productDetailsView.showThisErrorMsg(R.string.err_saveToListPending);
    }


}
