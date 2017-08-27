package com.redmartassignment.android.app.services;


import com.redmartassignment.android.responseModels.productList.Product;

public class DetailViewService {

    private Product selectedProduct;

    public DetailViewService(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

}
