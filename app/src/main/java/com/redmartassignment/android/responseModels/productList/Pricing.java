
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pricing implements Parcelable {

    @SerializedName("promo_id")
    @Expose
    private Long promoId;
    @SerializedName("on_sale")
    @Expose
    private Long onSale;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("promo_price")
    @Expose
    private Double promoPrice;
    @SerializedName("savings")
    @Expose
    private Double savings;
    @SerializedName("savings_amount")
    @Expose
    private Double savingsAmount;
    @SerializedName("savings_type")
    @Expose
    private Long savingsType;
    @SerializedName("savings_text")
    @Expose
    private String savingsText;
    @SerializedName("discounts")
    @Expose
    private Discounts discounts;
    @SerializedName("applicable_discount")
    @Expose
    private String applicableDiscount;

    public Long getPromoId() {
        return promoId;
    }

    public void setPromoId(Long promoId) {
        this.promoId = promoId;
    }

    public Long getOnSale() {
        return onSale;
    }

    public void setOnSale(Long onSale) {
        this.onSale = onSale;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(Double savings) {
        this.savings = savings;
    }

    public Double getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(Double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public Long getSavingsType() {
        return savingsType;
    }

    public void setSavingsType(Long savingsType) {
        this.savingsType = savingsType;
    }

    public String getSavingsText() {
        return savingsText;
    }

    public void setSavingsText(String savingsText) {
        this.savingsText = savingsText;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Discounts discounts) {
        this.discounts = discounts;
    }

    public String getApplicableDiscount() {
        return applicableDiscount;
    }

    public void setApplicableDiscount(String applicableDiscount) {
        this.applicableDiscount = applicableDiscount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.promoId);
        dest.writeValue(this.onSale);
        dest.writeValue(this.price);
        dest.writeValue(this.promoPrice);
        dest.writeValue(this.savings);
        dest.writeValue(this.savingsAmount);
        dest.writeValue(this.savingsType);
        dest.writeString(this.savingsText);
        dest.writeParcelable(this.discounts, flags);
        dest.writeString(this.applicableDiscount);
    }

    public Pricing() {
    }

    protected Pricing(Parcel in) {
        this.promoId = (Long) in.readValue(Long.class.getClassLoader());
        this.onSale = (Long) in.readValue(Long.class.getClassLoader());
        this.price = (Double) in.readValue(Double.class.getClassLoader());
        this.promoPrice = (Double) in.readValue(Double.class.getClassLoader());
        this.savings = (Double) in.readValue(Double.class.getClassLoader());
        this.savingsAmount = (Double) in.readValue(Double.class.getClassLoader());
        this.savingsType = (Long) in.readValue(Long.class.getClassLoader());
        this.savingsText = in.readString();
        this.discounts = in.readParcelable(Discounts.class.getClassLoader());
        this.applicableDiscount = in.readString();
    }

    public static final Parcelable.Creator<Pricing> CREATOR = new Parcelable.Creator<Pricing>() {
        @Override
        public Pricing createFromParcel(Parcel source) {
            return new Pricing(source);
        }

        @Override
        public Pricing[] newArray(int size) {
            return new Pricing[size];
        }
    };
}
