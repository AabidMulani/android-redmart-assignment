
package com.redmartassignment.android.responseModels.productList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product implements Parcelable {

    @SerializedName("category_tags")
    @Expose
    private List<String> categoryTags = null;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("categories")
    @Expose
    private List<Long> categories = null;
    @SerializedName("types")
    @Expose
    private List<Long> types = null;
    @SerializedName("details")
    @Expose
    private Details details;
    @SerializedName("product_life")
    @Expose
    private ProductLife productLife;
    @SerializedName("filters")
    @Expose
    private Filters filters;
    @SerializedName("img")
    @Expose
    private Img img;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("measure")
    @Expose
    private Measure measure;
    @SerializedName("pricing")
    @Expose
    private Pricing pricing;
    @SerializedName("warehouse")
    @Expose
    private Warehouse warehouse;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("description_fields")
    @Expose
    private DescriptionFields descriptionFields;
    @SerializedName("promotions")
    @Expose
    private List<Promotion> promotions = null;
    @SerializedName("inventory")
    @Expose
    private Inventory inventory;
    @SerializedName("pr")
    @Expose
    private Long pr;

    private int currentCartCounter = 0;

    public List<String> getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(List<String> categoryTags) {
        this.categoryTags = categoryTags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    public List<Long> getTypes() {
        return types;
    }

    public void setTypes(List<Long> types) {
        this.types = types;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public ProductLife getProductLife() {
        return productLife;
    }

    public void setProductLife(ProductLife productLife) {
        this.productLife = productLife;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public DescriptionFields getDescriptionFields() {
        return descriptionFields;
    }

    public void setDescriptionFields(DescriptionFields descriptionFields) {
        this.descriptionFields = descriptionFields;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Long getPr() {
        return pr;
    }

    public void setPr(Long pr) {
        this.pr = pr;
    }

    public int getCurrentCartCounter() {
        return currentCartCounter;
    }

    public void setCurrentCartCounter(int currentCartCounter) {
        this.currentCartCounter = currentCartCounter;
    }

    public Product() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.categoryTags);
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeString(this.sku);
        dest.writeList(this.categories);
        dest.writeList(this.types);
        dest.writeParcelable(this.details, flags);
        dest.writeParcelable(this.productLife, flags);
        dest.writeParcelable(this.filters, flags);
        dest.writeParcelable(this.img, flags);
        dest.writeTypedList(this.images);
        dest.writeParcelable(this.measure, flags);
        dest.writeParcelable(this.pricing, flags);
        dest.writeParcelable(this.warehouse, flags);
        dest.writeParcelable(this.attributes, flags);
        dest.writeParcelable(this.descriptionFields, flags);
        dest.writeTypedList(this.promotions);
        dest.writeParcelable(this.inventory, flags);
        dest.writeValue(this.pr);
        dest.writeInt(this.currentCartCounter);
    }

    protected Product(Parcel in) {
        this.categoryTags = in.createStringArrayList();
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.title = in.readString();
        this.desc = in.readString();
        this.sku = in.readString();
        this.categories = new ArrayList<Long>();
        in.readList(this.categories, Long.class.getClassLoader());
        this.types = new ArrayList<Long>();
        in.readList(this.types, Long.class.getClassLoader());
        this.details = in.readParcelable(Details.class.getClassLoader());
        this.productLife = in.readParcelable(ProductLife.class.getClassLoader());
        this.filters = in.readParcelable(Filters.class.getClassLoader());
        this.img = in.readParcelable(Img.class.getClassLoader());
        this.images = in.createTypedArrayList(Image.CREATOR);
        this.measure = in.readParcelable(Measure.class.getClassLoader());
        this.pricing = in.readParcelable(Pricing.class.getClassLoader());
        this.warehouse = in.readParcelable(Warehouse.class.getClassLoader());
        this.attributes = in.readParcelable(Attributes.class.getClassLoader());
        this.descriptionFields = in.readParcelable(DescriptionFields.class.getClassLoader());
        this.promotions = in.createTypedArrayList(Promotion.CREATOR);
        this.inventory = in.readParcelable(Inventory.class.getClassLoader());
        this.pr = (Long) in.readValue(Long.class.getClassLoader());
        this.currentCartCounter = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
