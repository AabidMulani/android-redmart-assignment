
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters implements Parcelable {

    @SerializedName("natural")
    @Expose
    private Long natural;
    @SerializedName("vegan")
    @Expose
    private Long vegan;
    @SerializedName("vendor_name")
    @Expose
    private String vendorName;
    @SerializedName("brand_uri")
    @Expose
    private String brandUri;
    @SerializedName("mfr_name")
    @Expose
    private String mfrName;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("frequency")
    @Expose
    private Long frequency;
    @SerializedName("trending_frequency")
    @Expose
    private Long trendingFrequency;
    @SerializedName("country_of_origin")
    @Expose
    private String countryOfOrigin;
    @SerializedName("is_organic")
    @Expose
    private Long isOrganic;
    @SerializedName("fsc")
    @Expose
    private Long fsc;

    public Long getNatural() {
        return natural;
    }

    public void setNatural(Long natural) {
        this.natural = natural;
    }

    public Long getVegan() {
        return vegan;
    }

    public void setVegan(Long vegan) {
        this.vegan = vegan;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getBrandUri() {
        return brandUri;
    }

    public void setBrandUri(String brandUri) {
        this.brandUri = brandUri;
    }

    public String getMfrName() {
        return mfrName;
    }

    public void setMfrName(String mfrName) {
        this.mfrName = mfrName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Long getTrendingFrequency() {
        return trendingFrequency;
    }

    public void setTrendingFrequency(Long trendingFrequency) {
        this.trendingFrequency = trendingFrequency;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Long getIsOrganic() {
        return isOrganic;
    }

    public void setIsOrganic(Long isOrganic) {
        this.isOrganic = isOrganic;
    }

    public Long getFsc() {
        return fsc;
    }

    public void setFsc(Long fsc) {
        this.fsc = fsc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.natural);
        dest.writeValue(this.vegan);
        dest.writeString(this.vendorName);
        dest.writeString(this.brandUri);
        dest.writeString(this.mfrName);
        dest.writeString(this.brandName);
        dest.writeValue(this.frequency);
        dest.writeValue(this.trendingFrequency);
        dest.writeString(this.countryOfOrigin);
        dest.writeValue(this.isOrganic);
        dest.writeValue(this.fsc);
    }

    public Filters() {
    }

    protected Filters(Parcel in) {
        this.natural = (Long) in.readValue(Long.class.getClassLoader());
        this.vegan = (Long) in.readValue(Long.class.getClassLoader());
        this.vendorName = in.readString();
        this.brandUri = in.readString();
        this.mfrName = in.readString();
        this.brandName = in.readString();
        this.frequency = (Long) in.readValue(Long.class.getClassLoader());
        this.trendingFrequency = (Long) in.readValue(Long.class.getClassLoader());
        this.countryOfOrigin = in.readString();
        this.isOrganic = (Long) in.readValue(Long.class.getClassLoader());
        this.fsc = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<Filters> CREATOR = new Parcelable.Creator<Filters>() {
        @Override
        public Filters createFromParcel(Parcel source) {
            return new Filters(source);
        }

        @Override
        public Filters[] newArray(int size) {
            return new Filters[size];
        }
    };
}
