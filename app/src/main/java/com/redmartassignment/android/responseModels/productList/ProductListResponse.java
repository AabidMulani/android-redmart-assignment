
package com.redmartassignment.android.responseModels.productList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductListResponse {

    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("on_sale_count")
    @Expose
    private Long onSaleCount;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("page")
    @Expose
    private Long page;
    @SerializedName("page_size")
    @Expose
    private Long pageSize;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getOnSaleCount() {
        return onSaleCount;
    }

    public void setOnSaleCount(Long onSaleCount) {
        this.onSaleCount = onSaleCount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

}
