package com.jerry.helplib.base;

import android.databinding.ViewDataBinding;

/**
 * @author : 曹幼林
 * @date : 2019/2/11
 */
public abstract class BaseMvpActivity<D extends ViewDataBinding, P extends BasePresenter> extends BaseActivity<D> {
    private P presenter;


}
