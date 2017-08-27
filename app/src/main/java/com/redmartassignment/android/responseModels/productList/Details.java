
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details implements Parcelable {

    @SerializedName("prod_type")
    @Expose
    private Long prodType;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("status")
    @Expose
    private Long status;
    @SerializedName("is_new")
    @Expose
    private Double isNew;
    @SerializedName("storage_class")
    @Expose
    private String storageClass;
    @SerializedName("country_of_origin")
    @Expose
    private String countryOfOrigin;

    public Long getProdType() {
        return prodType;
    }

    public void setProdType(Long prodType) {
        this.prodType = prodType;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Double getIsNew() {
        return isNew;
    }

    public void setIsNew(Double isNew) {
        this.isNew = isNew;
    }

    public String getStorageClass() {
        return storageClass;
    }

    public void setStorageClass(String storageClass) {
        this.storageClass = storageClass;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.prodType);
        dest.writeString(this.uri);
        dest.writeValue(this.status);
        dest.writeValue(this.isNew);
        dest.writeString(this.storageClass);
        dest.writeString(this.countryOfOrigin);
    }

    public Details() {
    }

    protected Details(Parcel in) {
        this.prodType = (Long) in.readValue(Long.class.getClassLoader());
        this.uri = in.readString();
        this.status = (Long) in.readValue(Long.class.getClassLoader());
        this.isNew = (Double) in.readValue(Double.class.getClassLoader());
        this.storageClass = in.readString();
        this.countryOfOrigin = in.readString();
    }

    public static final Parcelable.Creator<Details> CREATOR = new Parcelable.Creator<Details>() {
        @Override
        public Details createFromParcel(Parcel source) {
            return new Details(source);
        }

        @Override
        public Details[] newArray(int size) {
            return new Details[size];
        }
    };
}
