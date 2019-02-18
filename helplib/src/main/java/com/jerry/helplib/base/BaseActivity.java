package com.jerry.helplib.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author : 曹幼林
 * @date : 2019/2/11
 */
public abstract class BaseActivity<D extends ViewDataBinding> extends AppCompatActivity {

    protected D binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getContentViewId());
        initView();
        initListener();
        initData();
    }

    /**
     * 获取布局id
     *
     * @return 布局id
     */
    public abstract int getContentViewId();

    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 初始化事件
     */
    public abstract void initListener();

    /**
     * 初始化数据
     */
    public abstract void initData();

}
