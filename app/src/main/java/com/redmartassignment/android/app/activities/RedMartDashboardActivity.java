package com.redmartassignment.android.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.redmartassignment.android.BaseActivity;
import com.redmartassignment.android.BaseFragment;
import com.redmartassignment.android.R;
import com.redmartassignment.android.app.fragment.DashBoardFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RedMartDashboardActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private BaseFragment currentSelectedFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        showThisFragment(new DashBoardFragment());
    }


    private void showThisFragment(BaseFragment fragment) {
        currentSelectedFragment = fragment;
        getSupportActionBar().setTitle(fragment.getFragmentTitle());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}
