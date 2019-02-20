package com.jerry.helper.view;

import android.content.Intent;
import android.widget.Toast;

import com.jerry.helper.R;
import com.jerry.helper.databinding.ActivityCustomViewBinding;
import com.jerry.helper.util.LogbackUtil;
import com.jerry.helper.view.custom_view.CircleViewActivity;
import com.jerry.helplib.base.BaseActivity;
import com.jerry.helplib.constant.PermissionConstants;
import com.jerry.helper.util.PermissionUtils;

import java.util.List;

public class CustomViewActivity extends BaseActivity<ActivityCustomViewBinding> {

    @Override
    public int getContentViewId() {
        return R.layout.activity_custom_view;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        binding.btCircleView.setOnClickListener(v -> {
            startActivity(new Intent().setClass(CustomViewActivity.this, CircleViewActivity.class));
        });
    }

    @Override
    public void initData() {
        LogbackUtil.getInstance().getLogger().debug("test");

    }
}
