
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DescriptionFields implements Parcelable {

    @SerializedName("secondary")
    @Expose
    private List<Primary> secondary = null;
    @SerializedName("primary")
    @Expose
    private List<Primary> primary = null;

    public List<Primary> getSecondary() {
        return secondary;
    }

    public void setSecondary(List<Primary> secondary) {
        this.secondary = secondary;
    }

    public List<Primary> getPrimary() {
        return primary;
    }

    public void setPrimary(List<Primary> primary) {
        this.primary = primary;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.secondary);
        dest.writeTypedList(this.primary);
    }

    public DescriptionFields() {
    }

    protected DescriptionFields(Parcel in) {
        this.secondary = in.createTypedArrayList(Primary.CREATOR);
        this.primary = in.createTypedArrayList(Primary.CREATOR);
    }

    public static final Parcelable.Creator<DescriptionFields> CREATOR = new Parcelable.Creator<DescriptionFields>() {
        @Override
        public DescriptionFields createFromParcel(Parcel source) {
            return new DescriptionFields(source);
        }

        @Override
        public DescriptionFields[] newArray(int size) {
            return new DescriptionFields[size];
        }
    };
}
