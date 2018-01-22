package com.shmily.mvp.basemvp;

import java.lang.ref.WeakReference;

/**
 * Created by Shmily on 2017/6/2.
 */

public abstract class BasePresenter<T> {
    //View接口类型弱引用
    public WeakReference<T>  mViewRefer;

    /**
     * bind view with presenter
     * @param view
     */
    protected void attachView(T view) {
        //建立关联
        mViewRefer = new WeakReference<T>(view);
    }

    //可以通过此方法,判断是否与View建立了关联
    protected boolean isViewAttached() {
        return mViewRefer != null && mViewRefer.get() != null;
    }

    /**
     * unbind view with presenter
     */
    protected void detachView(){
        if (mViewRefer != null) {
            mViewRefer.clear();
            mViewRefer = null;
        }
    }
    /**
     * base 类提供view的引用
     * @return
     */
    public T getView(){
        return mViewRefer.get();
    }
}
