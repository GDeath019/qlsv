package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNS, edtMsv;
    Button btnInsert, btnUpdate, btnDelete, btnLoad;
    ListView lvSv;
    DBhelper dBhelper, getdBhelper;
    Cursor cursorTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Quan ly sinh vien");
        anhXa();

        dBhelper = new DBhelper(MainActivity.this);
        /////

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long resultAdd = dBhelper.Insert(Integer.parseInt(getValueString(edtMsv))
                        ,getValueString(edtName)
                        ,Integer.parseInt(getValueString(edtNS)));
                if(resultAdd==-1){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Insert Success", Toast.LENGTH_SHORT).show();
                    clear();

                }
            }
        });
        /////

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long resultUpdate = dBhelper.Update(Integer.parseInt(getValueString(edtMsv))
                        ,getValueString(edtName)
                        ,Integer.parseInt(getValueString(edtNS)));
                if (resultUpdate==0){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }else if(resultUpdate==1){
                    Toast.makeText(MainActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
                    clear();
                }else {
                    Toast.makeText(MainActivity.this, "Error, multiple records update", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /////

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long resultDelete = dBhelper.Delete(Integer.parseInt(getValueString(edtMsv)));
                if(resultDelete==0){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
                    clear();
                }
            }
        });
        /////

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dBhelper.getAllRecord();
                cursorTest = dBhelper.getAllRecord();

                SinhVienCursorAdapter sinhVienCursorAdapter = new
                        SinhVienCursorAdapter(MainActivity.this
                        , R.layout.activity_custom_s_v
                        ,cursor
                        ,0);

                lvSv.setAdapter(sinhVienCursorAdapter);
                clear();
            }
        });
        /////
        lvSv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //getdBhelper = new DBhelper(MainActivity.this);
                //getdBhelper = parent.getItemAtPosition(position);
                getdBhelper = (DBhelper) parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void anhXa(){
        edtMsv = (EditText) findViewById(R.id.msv);
        edtName = (EditText) findViewById(R.id.hoTen);
        edtNS = (EditText) findViewById(R.id.namSinh);
        /////
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        /////
        lvSv = (ListView) findViewById(R.id.listSV);
    }
    public void clear(){
        edtMsv.setText("");
        edtNS.setText("");
        edtName.setText("");
    }
    private String getValueString(EditText edt){
        return edt.getText().toString().trim();
    }
    protected void onStart(){
        super.onStart();
        dBhelper.openDB();
    }
    protected void onStop(){
        super.onStop();
        dBhelper.closeDB();
    }
}
