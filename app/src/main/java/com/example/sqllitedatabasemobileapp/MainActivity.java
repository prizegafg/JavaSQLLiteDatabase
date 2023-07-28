package com.example.sqllitedatabasemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        TextView tvName = findViewById(R.id.tvName);
        Button btnSimpan = findViewById(R.id.btnStore);
        Button btnGetName = findViewById(R.id.btnGetName);
        EditText edtName = findViewById(R.id.etname);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.addStudentDetail(edtName.getText().toString());
                edtName.setText("");
                Toast.makeText(MainActivity.this, "Sukses Tersimpan!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList = databaseHelper.getAllStudentsList();
                tvName.setText("");
                for(int i=0; i<arrayList.size(); i++){
                    tvName.setText(tvName.getText().toString()+", "+arrayList.get(i));
                }
            }
        });
    }
}