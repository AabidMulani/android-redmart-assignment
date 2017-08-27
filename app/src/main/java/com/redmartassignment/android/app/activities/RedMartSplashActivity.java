package com.redmartassignment.android.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.redmartassignment.android.BaseActivity;


public class RedMartSplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // do all the initializations here
        // right now there is nothing to initialize so
        // i am adding an forced delay using @Handler

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity, RedMartDashboardActivity.class));
                finish();
            }
        }, 2000);

    }
}
