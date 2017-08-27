
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Inventory implements Parcelable {

    @SerializedName("atp_status")
    @Expose
    private Long atpStatus;
    @SerializedName("max_sale_qty")
    @Expose
    private Long maxSaleQty;
    @SerializedName("qty_in_carts")
    @Expose
    private Long qtyInCarts;
    @SerializedName("qty_in_stock")
    @Expose
    private Long qtyInStock;
    @SerializedName("stock_status")
    @Expose
    private Long stockStatus;
    @SerializedName("stock_type")
    @Expose
    private Long stockType;
    @SerializedName("atp_lots")
    @Expose
    private List<AtpLot> atpLots = null;
    @SerializedName("next_available_date")
    @Expose
    private String nextAvailableDate;
    @SerializedName("limited_stock_status")
    @Expose
    private Long limitedStockStatus;
    @SerializedName("original_max_sale_qty")
    @Expose
    private Long originalMaxSaleQty;
    @SerializedName("__v")
    @Expose
    private Long v;

    public Long getAtpStatus() {
        return atpStatus;
    }

    public void setAtpStatus(Long atpStatus) {
        this.atpStatus = atpStatus;
    }

    public Long getMaxSaleQty() {
        return maxSaleQty;
    }

    public void setMaxSaleQty(Long maxSaleQty) {
        this.maxSaleQty = maxSaleQty;
    }

    public Long getQtyInCarts() {
        return qtyInCarts;
    }

    public void setQtyInCarts(Long qtyInCarts) {
        this.qtyInCarts = qtyInCarts;
    }

    public Long getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(Long qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public Long getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Long stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Long getStockType() {
        return stockType;
    }

    public void setStockType(Long stockType) {
        this.stockType = stockType;
    }

    public List<AtpLot> getAtpLots() {
        return atpLots;
    }

    public void setAtpLots(List<AtpLot> atpLots) {
        this.atpLots = atpLots;
    }

    public String getNextAvailableDate() {
        return nextAvailableDate;
    }

    public void setNextAvailableDate(String nextAvailableDate) {
        this.nextAvailableDate = nextAvailableDate;
    }

    public Long getLimitedStockStatus() {
        return limitedStockStatus;
    }

    public void setLimitedStockStatus(Long limitedStockStatus) {
        this.limitedStockStatus = limitedStockStatus;
    }

    public Long getOriginalMaxSaleQty() {
        return originalMaxSaleQty;
    }

    public void setOriginalMaxSaleQty(Long originalMaxSaleQty) {
        this.originalMaxSaleQty = originalMaxSaleQty;
    }

    public Long getV() {
        return v;
    }

    public void setV(Long v) {
        this.v = v;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.atpStatus);
        dest.writeValue(this.maxSaleQty);
        dest.writeValue(this.qtyInCarts);
        dest.writeValue(this.qtyInStock);
        dest.writeValue(this.stockStatus);
        dest.writeValue(this.stockType);
        dest.writeTypedList(this.atpLots);
        dest.writeString(this.nextAvailableDate);
        dest.writeValue(this.limitedStockStatus);
        dest.writeValue(this.originalMaxSaleQty);
        dest.writeValue(this.v);
    }

    public Inventory() {
    }

    protected Inventory(Parcel in) {
        this.atpStatus = (Long) in.readValue(Long.class.getClassLoader());
        this.maxSaleQty = (Long) in.readValue(Long.class.getClassLoader());
        this.qtyInCarts = (Long) in.readValue(Long.class.getClassLoader());
        this.qtyInStock = (Long) in.readValue(Long.class.getClassLoader());
        this.stockStatus = (Long) in.readValue(Long.class.getClassLoader());
        this.stockType = (Long) in.readValue(Long.class.getClassLoader());
        this.atpLots = in.createTypedArrayList(AtpLot.CREATOR);
        this.nextAvailableDate = in.readString();
        this.limitedStockStatus = (Long) in.readValue(Long.class.getClassLoader());
        this.originalMaxSaleQty = (Long) in.readValue(Long.class.getClassLoader());
        this.v = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<Inventory> CREATOR = new Parcelable.Creator<Inventory>() {
        @Override
        public Inventory createFromParcel(Parcel source) {
            return new Inventory(source);
        }

        @Override
        public Inventory[] newArray(int size) {
            return new Inventory[size];
        }
    };
}
