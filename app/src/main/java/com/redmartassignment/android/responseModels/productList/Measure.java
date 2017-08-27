
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measure implements Parcelable {

    @SerializedName("wt_or_vol")
    @Expose
    private String wtOrVol;
    @SerializedName("size")
    @Expose
    private Double size;

    public String getWtOrVol() {
        return wtOrVol;
    }

    public void setWtOrVol(String wtOrVol) {
        this.wtOrVol = wtOrVol;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.wtOrVol);
        dest.writeValue(this.size);
    }

    public Measure() {
    }

    protected Measure(Parcel in) {
        this.wtOrVol = in.readString();
        this.size = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Measure> CREATOR = new Parcelable.Creator<Measure>() {
        @Override
        public Measure createFromParcel(Parcel source) {
            return new Measure(source);
        }

        @Override
        public Measure[] newArray(int size) {
            return new Measure[size];
        }
    };
}
