package com.shmily.mvp.model;

import com.shmily.mvp.bean.StudentBean;

import java.util.List;

/**
 * Created by Shmily on 2017/5/25.
 * Model 负责数据的获取
 */

public interface IStudentModel{
    /**
     * 加载本地数据
     * @param listener
     */
    void fetchLocal(OnLoadFromLocalListener listener);

    /**
     * 本地加载完成的回调
     */
    interface OnLoadFromLocalListener {
        void onLoadSuccessFromLocal(List<StudentBean> list);
    }
}
