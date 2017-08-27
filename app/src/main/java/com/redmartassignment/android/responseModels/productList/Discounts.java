
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Discounts implements Parcelable {

    @SerializedName("promo")
    @Expose
    private Promo promo;
    @SerializedName("live_up")
    @Expose
    private LiveUp liveUp;

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public LiveUp getLiveUp() {
        return liveUp;
    }

    public void setLiveUp(LiveUp liveUp) {
        this.liveUp = liveUp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.promo, flags);
        dest.writeParcelable(this.liveUp, flags);
    }

    public Discounts() {
    }

    protected Discounts(Parcel in) {
        this.promo = in.readParcelable(Promo.class.getClassLoader());
        this.liveUp = in.readParcelable(LiveUp.class.getClassLoader());
    }

    public static final Parcelable.Creator<Discounts> CREATOR = new Parcelable.Creator<Discounts>() {
        @Override
        public Discounts createFromParcel(Parcel source) {
            return new Discounts(source);
        }

        @Override
        public Discounts[] newArray(int size) {
            return new Discounts[size];
        }
    };
}
