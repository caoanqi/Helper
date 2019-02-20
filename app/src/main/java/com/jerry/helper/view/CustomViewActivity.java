package com.jerry.helper.view;

import android.widget.Toast;

import com.jerry.helper.R;
import com.jerry.helper.databinding.ActivityCustomViewBinding;
import com.jerry.helper.util.LogbackUtil;
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

        PermissionUtils.permission(PermissionConstants.STORAGE)
                .rationale(new PermissionUtils.OnRationaleListener() {
                    @Override
                    public void rationale(final ShouldRequest shouldRequest) {

                    }
                })
                .callback(new PermissionUtils.FullCallback() {
                    @Override
                    public void onGranted(List<String> permissionsGranted) {
                        Toast.makeText(CustomViewActivity.this,"已授权",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(List<String> permissionsDeniedForever,
                                         List<String> permissionsDenied) {

                    }
                })
                .request();

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        LogbackUtil.getInstance().getLogger().debug("test");

    }
}
