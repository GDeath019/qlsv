package com.example.qlsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.xml.transform.Templates;

public class ShopStudent extends RecyclerView.Adapter<ShopStudent.ViewHolder> {
    ArrayList<Student> arrayList;
    Context context;

    public ShopStudent(ArrayList<Student> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.activity_custom_s_v,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = arrayList.get(position);
        holder.tvID.setText(student.getID()+"");
        holder.tvName.setText(student.getName());
        holder.tvNS.setText(student.getYearob()+"");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvID,tvName,tvNS;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = (TextView)itemView.findViewById(R.id.tvMsv);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvNS = (TextView)itemView.findViewById(R.id.tvNamSinh);
        }
    }
}
