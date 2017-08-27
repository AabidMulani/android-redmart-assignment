
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Secondary implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("content")
    @Expose
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Secondary() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.content);
    }

    protected Secondary(Parcel in) {
        this.name = in.readString();
        this.content = in.readString();
    }

    public static final Creator<Secondary> CREATOR = new Creator<Secondary>() {
        @Override
        public Secondary createFromParcel(Parcel source) {
            return new Secondary(source);
        }

        @Override
        public Secondary[] newArray(int size) {
            return new Secondary[size];
        }
    };
}
