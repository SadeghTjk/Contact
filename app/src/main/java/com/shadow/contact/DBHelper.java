package com.shadow.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "co.db";
    final static String TABLE_NAME = "Contacts";
    final static String COL0 = "id";
    final static String COL1 = "name";
    final static String COL2 = "number";
    final static String COL3 = "pic";

    public DBHelper(Context context) {
        super(context, DB_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,number TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }

    public boolean insertData(String name,String number){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1,name);
        cv.put(COL2,number);

        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data =  db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return data;

    }
    public Cursor deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data =  db.rawQuery("delete from "+ TABLE_NAME,null);
        return data;

    }
    //db.execSQL("delete from "+ TABLE_NAME);
}
