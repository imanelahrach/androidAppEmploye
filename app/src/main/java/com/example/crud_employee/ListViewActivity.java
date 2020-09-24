package com.example.crud_employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<Employe> employes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);

        SQLiteDatabase db =DataBaseHelper.getInstance(getApplicationContext()).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM employe",null);

        while (cursor.moveToNext())
        {
                Employe employe =new Employe();
            employe.setId(cursor.getInt(0));
                    employe.setName(cursor.getString(1));
                    employe.setPrenom(cursor.getString(2));

                    employes.add(employe);

        }

        ArrayAdapter<Employe> adapter = new ArrayAdapter<>(getApplicationContext(),
                                        android.R.layout.simple_list_item_1,
                                        employes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailEmployeActivity.class);
                intent.putExtra("DATA",employes.get(position));
                startActivity(intent);
            }
        });

    }
}
