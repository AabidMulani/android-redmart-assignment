
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductLife implements Parcelable {

    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("metric")
    @Expose
    private String metric;
    @SerializedName("is_minimum")
    @Expose
    private Boolean isMinimum;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Boolean getIsMinimum() {
        return isMinimum;
    }

    public void setIsMinimum(Boolean isMinimum) {
        this.isMinimum = isMinimum;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.time);
        dest.writeString(this.metric);
        dest.writeValue(this.isMinimum);
    }

    public ProductLife() {
    }

    protected ProductLife(Parcel in) {
        this.time = (Long) in.readValue(Long.class.getClassLoader());
        this.metric = in.readString();
        this.isMinimum = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<ProductLife> CREATOR = new Parcelable.Creator<ProductLife>() {
        @Override
        public ProductLife createFromParcel(Parcel source) {
            return new ProductLife(source);
        }

        @Override
        public ProductLife[] newArray(int size) {
            return new ProductLife[size];
        }
    };
}
