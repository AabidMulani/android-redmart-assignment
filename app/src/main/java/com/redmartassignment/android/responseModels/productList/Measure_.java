
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measure_ implements Parcelable {

    @SerializedName("vol_metric")
    @Expose
    private String volMetric;
    @SerializedName("wt")
    @Expose
    private Double wt;
    @SerializedName("wt_metric")
    @Expose
    private String wtMetric;
    @SerializedName("l")
    @Expose
    private Double l;
    @SerializedName("w")
    @Expose
    private Double w;
    @SerializedName("h")
    @Expose
    private Double h;
    @SerializedName("vol")
    @Expose
    private Double vol;
    @SerializedName("vol_metric_alt")
    @Expose
    private String volMetricAlt;

    public String getVolMetric() {
        return volMetric;
    }

    public void setVolMetric(String volMetric) {
        this.volMetric = volMetric;
    }

    public Double getWt() {
        return wt;
    }

    public void setWt(Double wt) {
        this.wt = wt;
    }

    public String getWtMetric() {
        return wtMetric;
    }

    public void setWtMetric(String wtMetric) {
        this.wtMetric = wtMetric;
    }

    public Double getL() {
        return l;
    }

    public void setL(Double l) {
        this.l = l;
    }

    public Double getW() {
        return w;
    }

    public void setW(Double w) {
        this.w = w;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public String getVolMetricAlt() {
        return volMetricAlt;
    }

    public void setVolMetricAlt(String volMetricAlt) {
        this.volMetricAlt = volMetricAlt;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.volMetric);
        dest.writeValue(this.wt);
        dest.writeString(this.wtMetric);
        dest.writeValue(this.l);
        dest.writeValue(this.w);
        dest.writeValue(this.h);
        dest.writeValue(this.vol);
        dest.writeString(this.volMetricAlt);
    }

    public Measure_() {
    }

    protected Measure_(Parcel in) {
        this.volMetric = in.readString();
        this.wt = (Double) in.readValue(Double.class.getClassLoader());
        this.wtMetric = in.readString();
        this.l = (Double) in.readValue(Double.class.getClassLoader());
        this.w = (Double) in.readValue(Double.class.getClassLoader());
        this.h = (Double) in.readValue(Double.class.getClassLoader());
        this.vol = (Double) in.readValue(Double.class.getClassLoader());
        this.volMetricAlt = in.readString();
    }

    public static final Parcelable.Creator<Measure_> CREATOR = new Parcelable.Creator<Measure_>() {
        @Override
        public Measure_ createFromParcel(Parcel source) {
            return new Measure_(source);
        }

        @Override
        public Measure_[] newArray(int size) {
            return new Measure_[size];
        }
    };
}
