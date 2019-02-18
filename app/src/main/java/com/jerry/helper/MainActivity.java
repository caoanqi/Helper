package com.jerry.helper;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.jerry.helper.adapter.MainAdapter;
import com.jerry.helper.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private List<String> activityNameData = new ArrayList<>();
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initListener();
        initData();
    }

    private void initListener() {

    }

    private void initData() {

        if (activityNameData.size() > 0) {
            activityNameData.clear();
        }

        activityNameData.add("android 原声语音播报");
        activityNameData.add("百度语音播报");
        activityNameData.add("讯飞语音播报");
        activityNameData.add("自定义view");
        onBindingData();

    }

    private void onBindingData() {
        if (adapter == null) {
            adapter = new MainAdapter(this, activityNameData);
        }
        activityMainBinding.rvActivityList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        activityMainBinding.rvActivityList.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.rvActivityList.setAdapter(adapter);
    }
}

