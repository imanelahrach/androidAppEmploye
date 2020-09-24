package com.example.crud_employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddEmploye extends AppCompatActivity {
    private EditText txtNom,txtPre;
    private boolean update = false;
    private Employe employe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employe);

        txtNom=findViewById(R.id.txtNom);
        txtPre=findViewById(R.id.txtPre);
        Intent intent=getIntent();
        employe=(Employe) intent.getSerializableExtra("DATA");

        if (employe != null) {
            txtPre.setText(employe.getPrenom());
            txtNom.setText(employe.getName());
            update=true;
        }

    }

    public void btnSaveEmploye(View view) {

        SQLiteDatabase db =DataBaseHelper.getInstance(getApplicationContext()).getWritableDatabase();

        if(update)
        {
            db.execSQL("UPDATE  employe SET name=?,prenom=? WHERE id =?" ,
                    new String[]{
                            txtNom.getText().toString(),txtPre.getText().toString(),String.valueOf(employe.getId())
                    });
        }
        else{
            db.execSQL("INSERT INTO employe(name,prenom) VALUES (?,?)" ,
                    new String[]{
                            txtNom.getText().toString(),txtPre.getText().toString()
                    });

        }
        Intent intent =new Intent(this,ListViewActivity.class);
        startActivity(intent);
    }
}
