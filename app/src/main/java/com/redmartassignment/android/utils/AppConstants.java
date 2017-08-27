package com.redmartassignment.android.utils;

public class AppConstants {
    private static final String BASE_URL = "https://api.redmart.com";
    private static final String IMAGE_BASE_URL = "http://media.redmart.com/newmedia/200p";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getImageUrl(String imagePath) {
        return IMAGE_BASE_URL + imagePath;
    }
}
