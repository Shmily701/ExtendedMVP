package com.shmily.mvp.model;

import com.shmily.mvp.bean.StudentBean;

import java.util.ArrayList;

/**
 * Created by Shmily on 2017/5/25.
 */

public class StudentModelImlV1 implements IStudentModel {

    @Override
    public void fetchLocal(OnLoadFromLocalListener listener) {
        ArrayList<StudentBean> list = loadDataFromLocal();
        if ( listener == null || list == null || list.isEmpty()){
            return;
        }
        listener.onLoadSuccessFromLocal(list);
    }

    /**
     * 加载本地数据
     * @return
     */
    private ArrayList<StudentBean> loadDataFromLocal(){

        ArrayList<StudentBean> list = new ArrayList<>();
        StudentBean student1 = new StudentBean();
        student1.setName("jason");
        student1.setSex("女");
        student1.setEge("10");
        student1.setPhone("010-1234567");
        list.add(student1);

        StudentBean student2 = new StudentBean();
        student2.setName("tofel");
        student2.setSex("男");
        student2.setEge("12");
        student2.setPhone("010-2233445");
        list.add(student2);

        StudentBean student3 = new StudentBean();
        student3.setName("nike");
        student3.setSex("男");
        student3.setEge("6");
        student3.setPhone("010-2233567");
        list.add(student3);

        StudentBean student4 = new StudentBean();
        student4.setName("lander");
        student4.setSex("男");
        student4.setEge("15");
        student4.setPhone("010-4455667");
        list.add(student4);

        StudentBean student5 = new StudentBean();
        student5.setName("angle");
        student5.setSex("女");
        student5.setEge("6");
        student5.setPhone("010-2390480");
        list.add(student5);

        StudentBean student6 = new StudentBean();
        student6.setName("baby");
        student6.setSex("女");
        student6.setEge("8");
        student6.setPhone("010-2850649");
        list.add(student6);

        StudentBean student7 = new StudentBean();
        student7.setName("geson");
        student7.setSex("男");
        student7.setEge("14");
        student7.setPhone("010-9087567");
        list.add(student7);

        return list;
    }

}
