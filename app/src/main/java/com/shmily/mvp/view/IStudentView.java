package com.shmily.mvp.view;

import com.shmily.mvp.bean.StudentBean;

import java.util.List;

/**
 * Created by Shmily on 2017/5/25.
 * view 负责数据的显示 StudentView在Activity中显示
 */

public interface IStudentView {

    /**
     * 显示进度条
     */
    void showLoading();

    /**
     * 显示学生数据
     * @param list
     */
    void showStudentList(List<StudentBean> list);

    /***
     * 显示网络返回
     * @param str
     */
    void showIntertReturn(String str);

    /**
     * 数据获取失败（标签为type）
     * @param type
     */
    void isFailure(int type);
}
