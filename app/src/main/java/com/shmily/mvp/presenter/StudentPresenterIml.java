package com.shmily.mvp.presenter;

import com.shmily.mvp.basemvp.BasePresenter;
import com.shmily.mvp.bean.StudentBean;
import com.shmily.mvp.model.IStudentModel;
import com.shmily.mvp.model.StudentModelImlV1;
import com.shmily.mvp.view.IStudentView;

import java.util.List;

/**
 * Created by Shmily on 2017/5/25.
 */

public class StudentPresenterIml extends BasePresenter<IStudentView>{

    private IStudentModel mStudentModelIml;
    public StudentPresenterIml() {
        mStudentModelIml = new StudentModelImlV1();
    }

    public void requestData() {
        // getView()通过父类的方法得到view的引用.
        getView().showLoading();
        if (mStudentModelIml != null) {
            mStudentModelIml.fetchLocal(new IStudentModel.OnLoadFromLocalListener() {
                @Override
                public void onLoadSuccessFromLocal(List<StudentBean> list) {
                    getView().showStudentList(list);
                }
            });
        }
    }
}
