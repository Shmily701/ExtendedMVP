package com.shmily.mvp.basemvp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Shmily on 2017/6/2.
 */

public abstract class BaseActivity<V,T extends  BasePresenter<V>> extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建Presenter 将在view中创建presenter提取到Base类
        mPresenter = createPresenter();
        // p与v的关联
        mPresenter.attachView((V)this);
    }

    public T mPresenter;

    /**
     * create presenter
     * @return 模版方法，具体实现到子类
     */
    public abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // p与v解除关联 解决内存泄漏的问题
        mPresenter.detachView();
    }
}
