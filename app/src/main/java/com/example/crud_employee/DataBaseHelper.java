package com.example.crud_employee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static DataBaseHelper instance;

    public static synchronized DataBaseHelper getInstance(Context context)
    {
        if(instance==null)
        {
            instance=new DataBaseHelper(context);
        }
        return instance;
    }

    public DataBaseHelper(Context context) {
        super(context, "Employe.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE employe (" + "id INTEGER PRIMARY KEY ," + "name VARCHAR ," + "prenom VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS employe ");
        onCreate(db);
    }
}
