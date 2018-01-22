package com.shmily.mvp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shmily.mvp.Util.Config;
import com.shmily.mvp.basemvp.BaseActivity;
import com.shmily.mvp.bean.StudentBean;
import com.shmily.mvp.presenter.StudentPresenterIml;
import com.shmily.mvp.view.IStudentView;

import java.util.List;

/**
 * Activity 在mvp 中充当view的角色，实现view的接口
 */
public class StudentActivity extends BaseActivity<IStudentView,StudentPresenterIml> implements IStudentView {

    private ListView listView;
    private TextView text_local;
    private TextView text_internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initView();
        fetchData();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listview);
        text_local = (TextView) findViewById(R.id.tv_localresule);
        text_internet = (TextView) findViewById(R.id.tv_internetresult);

    }

    private void fetchData(){
        mPresenter.requestData();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,getString(R.string.loading),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStudentList(List<StudentBean> list) {
        listView.setAdapter(new MyAdapter(StudentActivity.this,list));
    }

    @Override
    public void showIntertReturn(String str) {
        text_internet.setText(str);
    }


    /**
     * 子类实现父类的方法
     * @return
     */
    @Override
    public StudentPresenterIml createPresenter() {
        return new StudentPresenterIml();
    }

    /**
     * 通过type标签区分不同请求
     * @param type
     */    @Override
    public void isFailure(int type) {
        switch (type) {
            case Config.RequestLocal:
                text_local.setText(getString(R.string.localfailed));
                break;
            case Config.RequestInternet:
                text_internet.setText(getString(R.string.internetfailed));
                break;

        }

    }
}
