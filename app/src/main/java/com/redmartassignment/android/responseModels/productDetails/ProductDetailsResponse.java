
package com.redmartassignment.android.responseModels.productDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.redmartassignment.android.responseModels.productList.Product;
import com.redmartassignment.android.responseModels.productList.Status;

public class ProductDetailsResponse {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("page")
    @Expose
    private Long page;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("page_size")
    @Expose
    private Long pageSize;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

}
