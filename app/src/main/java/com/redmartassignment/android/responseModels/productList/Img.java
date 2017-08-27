
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Img implements Parcelable {

    @SerializedName("h")
    @Expose
    private Long h;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("w")
    @Expose
    private Long w;
    @SerializedName("position")
    @Expose
    private Long position;

    public Long getH() {
        return h;
    }

    public void setH(Long h) {
        this.h = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getW() {
        return w;
    }

    public void setW(Long w) {
        this.w = w;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.h);
        dest.writeString(this.name);
        dest.writeValue(this.w);
        dest.writeValue(this.position);
    }

    public Img() {
    }

    protected Img(Parcel in) {
        this.h = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.w = (Long) in.readValue(Long.class.getClassLoader());
        this.position = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<Img> CREATOR = new Parcelable.Creator<Img>() {
        @Override
        public Img createFromParcel(Parcel source) {
            return new Img(source);
        }

        @Override
        public Img[] newArray(int size) {
            return new Img[size];
        }
    };
}
