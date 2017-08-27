
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AtpLot implements Parcelable {

    @SerializedName("from_date")
    @Expose
    private String fromDate;
    @SerializedName("to_date")
    @Expose
    private String toDate;
    @SerializedName("stock_status")
    @Expose
    private Long stockStatus;
    @SerializedName("qty_in_stock")
    @Expose
    private Long qtyInStock;
    @SerializedName("qty_in_carts")
    @Expose
    private Long qtyInCarts;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Long getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Long stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Long getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(Long qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public Long getQtyInCarts() {
        return qtyInCarts;
    }

    public void setQtyInCarts(Long qtyInCarts) {
        this.qtyInCarts = qtyInCarts;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fromDate);
        dest.writeString(this.toDate);
        dest.writeValue(this.stockStatus);
        dest.writeValue(this.qtyInStock);
        dest.writeValue(this.qtyInCarts);
    }

    public AtpLot() {
    }

    protected AtpLot(Parcel in) {
        this.fromDate = in.readString();
        this.toDate = in.readString();
        this.stockStatus = (Long) in.readValue(Long.class.getClassLoader());
        this.qtyInStock = (Long) in.readValue(Long.class.getClassLoader());
        this.qtyInCarts = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<AtpLot> CREATOR = new Parcelable.Creator<AtpLot>() {
        @Override
        public AtpLot createFromParcel(Parcel source) {
            return new AtpLot(source);
        }

        @Override
        public AtpLot[] newArray(int size) {
            return new AtpLot[size];
        }
    };
}
