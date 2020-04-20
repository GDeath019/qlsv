package com.example.qlsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SinhVienBaseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Student> arrayList;

    public SinhVienBaseAdapter(Context context, ArrayList<Student> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.activity_custom_s_v,null);
        }
        Student st = (Student) getItem(position);
        if (st!=null){
            TextView textID = (TextView) view.findViewById(R.id.tvMsv);
            TextView textName = (TextView) view.findViewById(R.id.tvName);
            TextView textYearob = (TextView) view.findViewById(R.id.tvNamSinh);
            /////
            textID.setText(st.getID()+"");
            textName.setText(st.getName());
            textYearob.setText(st.getYearob()+"");
        }
        return view;
    }
}
