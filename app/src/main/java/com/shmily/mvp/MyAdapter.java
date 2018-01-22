package com.shmily.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shmily.mvp.bean.StudentBean;

import java.util.List;

/**
 * Created by Shmily on 2017/5/25.
 */

public class MyAdapter extends BaseAdapter{

    private ViewHolder mViewHolder;
    private List<StudentBean> mList;
    private Context mContext;

    public MyAdapter(Context context,List<StudentBean> list){
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext,R.layout.layout_student_item,null);
            mViewHolder = new ViewHolder();
            mViewHolder.img_head = (ImageView) convertView.findViewById(R.id.imag_head);
            mViewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            mViewHolder.tv_sex = (TextView) convertView.findViewById(R.id.tv_sex);
            mViewHolder.tv_age = (TextView) convertView.findViewById(R.id.tv_age);
            mViewHolder.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
            convertView.setTag(mViewHolder);
        }
        else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        switch (position) {
            case 0:
                mViewHolder.img_head.setBackgroundResource(R.drawable.head0);
                break;
            case 1:
                mViewHolder.img_head.setBackgroundResource(R.drawable.head1);
                break;
            case 2:
                mViewHolder.img_head.setBackgroundResource(R.drawable.head2);
                break;
            case 3:
                mViewHolder.img_head.setBackgroundResource(R.drawable.head3);
                break;
            case 4:
                mViewHolder.img_head.setBackgroundResource(R.drawable.head4);
                break;
            case 5:
                mViewHolder.img_head.setBackgroundResource(R.drawable.head5);
                break;
            case 6:
                mViewHolder.img_head.setBackgroundResource(R.drawable.head6);
                break;
        }
        mViewHolder.tv_name.setText(mList.get(position).getName());
        mViewHolder.tv_sex.setText(mList.get(position).getSex());
        mViewHolder.tv_age.setText(mList.get(position).getEge());
        mViewHolder.tv_phone.setText(mList.get(position).getPhone());
        return convertView;
    }

    static class ViewHolder{
        ImageView img_head;
        TextView tv_name;
        TextView tv_age;
        TextView tv_sex;
        TextView tv_phone;
    }

}
