package com.example.crud_employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAddEmploye(View view) {
        Intent intent =new Intent(this,AddEmploye.class);
        startActivity(intent);
    }

    public void btnListEmployes(View view) {
        Intent intent =new Intent(this,ListViewActivity.class);
        startActivity(intent);
    }
}
