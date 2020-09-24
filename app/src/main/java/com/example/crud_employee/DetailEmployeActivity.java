package com.example.crud_employee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailEmployeActivity extends AppCompatActivity {

    TextView txtDetailName,txtDetailPre;
    Employe employe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_employe);

        Intent intent=getIntent();
       employe=(Employe) intent.getSerializableExtra("DATA");

        txtDetailName=findViewById(R.id.txtDetailName);
        txtDetailPre=findViewById(R.id.txtDetailPre);

        txtDetailName.setText(employe.getName());
        txtDetailPre.setText(employe.getPrenom());



    }

    public void btnModifierEmploye(View view) {
        Intent intent = new Intent(getApplicationContext(),AddEmploye.class);
        intent.putExtra("DATA",employe);
        startActivity(intent);
    }

    public void btnSupprimerEmploye(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Etes vous sure de voiloire supprimer cet element").setTitle("Attention");
        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SQLiteDatabase db =DataBaseHelper.getInstance(getApplicationContext()).getWritableDatabase();
                db.execSQL("DELETE FROM employe WHERE id=?",new String [] { String.valueOf(employe.getId())});

                Intent intent = new Intent(getApplicationContext(),ListViewActivity.class);
                intent.putExtra("DATA",employe);
                startActivity(intent);
            }
        });

builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
});
   AlertDialog dialog=builder.create();
   dialog.show();
    }
}
