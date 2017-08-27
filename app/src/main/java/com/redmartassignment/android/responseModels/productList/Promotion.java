
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promotion implements Parcelable {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("type")
    @Expose
    private Long type;
    @SerializedName("savings_text")
    @Expose
    private String savingsText;
    @SerializedName("promo_label")
    @Expose
    private String promoLabel;
    @SerializedName("current_product_group_id")
    @Expose
    private Long currentProductGroupId;
    @SerializedName("live_up_savings_text")
    @Expose
    private String liveUpSavingsText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getSavingsText() {
        return savingsText;
    }

    public void setSavingsText(String savingsText) {
        this.savingsText = savingsText;
    }

    public String getPromoLabel() {
        return promoLabel;
    }

    public void setPromoLabel(String promoLabel) {
        this.promoLabel = promoLabel;
    }

    public Long getCurrentProductGroupId() {
        return currentProductGroupId;
    }

    public void setCurrentProductGroupId(Long currentProductGroupId) {
        this.currentProductGroupId = currentProductGroupId;
    }

    public String getLiveUpSavingsText() {
        return liveUpSavingsText;
    }

    public void setLiveUpSavingsText(String liveUpSavingsText) {
        this.liveUpSavingsText = liveUpSavingsText;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeValue(this.type);
        dest.writeString(this.savingsText);
        dest.writeString(this.promoLabel);
        dest.writeValue(this.currentProductGroupId);
        dest.writeString(this.liveUpSavingsText);
    }

    public Promotion() {
    }

    protected Promotion(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.type = (Long) in.readValue(Long.class.getClassLoader());
        this.savingsText = in.readString();
        this.promoLabel = in.readString();
        this.currentProductGroupId = (Long) in.readValue(Long.class.getClassLoader());
        this.liveUpSavingsText = in.readString();
    }

    public static final Parcelable.Creator<Promotion> CREATOR = new Parcelable.Creator<Promotion>() {
        @Override
        public Promotion createFromParcel(Parcel source) {
            return new Promotion(source);
        }

        @Override
        public Promotion[] newArray(int size) {
            return new Promotion[size];
        }
    };
}
