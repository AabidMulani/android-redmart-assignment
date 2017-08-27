
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Attributes implements Parcelable {

    @SerializedName("dag")
    @Expose
    private List<Object> dag = null;

    public List<Object> getDag() {
        return dag;
    }

    public void setDag(List<Object> dag) {
        this.dag = dag;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.dag);
    }

    public Attributes() {
    }

    protected Attributes(Parcel in) {
        this.dag = new ArrayList<Object>();
        in.readList(this.dag, Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<Attributes> CREATOR = new Parcelable.Creator<Attributes>() {
        @Override
        public Attributes createFromParcel(Parcel source) {
            return new Attributes(source);
        }

        @Override
        public Attributes[] newArray(int size) {
            return new Attributes[size];
        }
    };
}
