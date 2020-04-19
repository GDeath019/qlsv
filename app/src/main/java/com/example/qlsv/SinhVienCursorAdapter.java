package com.example.qlsv;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class SinhVienCursorAdapter extends ResourceCursorAdapter {
    public SinhVienCursorAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, layout, c, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textID = (TextView) view.findViewById(R.id.tvMsv);
        TextView textName = (TextView) view.findViewById(R.id.tvName);
        TextView textYearob = (TextView) view.findViewById(R.id.tvNamSinh);
        /////////////////
        textID.setText(cursor.getString(cursor.getColumnIndex(DBhelper.getID())));
        textName.setText(cursor.getString(cursor.getColumnIndex(DBhelper.getNAME())));
        textYearob.setText(cursor.getString(cursor.getColumnIndex(DBhelper.getYEAROB())));
    }
}
