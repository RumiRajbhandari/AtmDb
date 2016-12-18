package com.example.root.atmdatabase2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/14/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {



    public DatabaseHandler(Context context) {
        super(context, AtmContract.AtmEntry.DATABASE_NAME, null, AtmContract.AtmEntry.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       // String CREATE_TABLE_ATM="CREATE TABLE ATM(atmId INTEGER PRIMARY KEY, bankId INTEGER, lat DOUBLE, lon DOUBLE, status INTEGER)";
        //db.execSQL(CREATE_TABLE_ATM);
        db.execSQL(getCreateQuery(AtmContract.AtmEntry.TABLE_NAME, AtmContract.AtmEntry.COLUMN_METADATA()));



    }

    public String getCreateQuery(String tableName, String[] columnMetaData){
        StringBuilder builder=new StringBuilder();
        String intialQ="CREATE TABLE " + tableName +" (";
        builder.append(intialQ);
        builder.append(TextUtils.join(", ",columnMetaData));
        builder.append(")");
        return builder.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ATM" );
        onCreate(db);
    }

}




