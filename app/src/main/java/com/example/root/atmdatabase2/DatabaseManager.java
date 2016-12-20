package com.example.root.atmdatabase2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/17/16.
 */
public class DatabaseManager {
    private SQLiteDatabase db;

    public DatabaseManager(SQLiteDatabase db){this.db=db;}

    void addAtm(AtmDetails atm) {

        ContentValues values = new ContentValues();

        values.put(AtmContract.AtmEntry.COLUMN_BANKID, atm.getBankId());
        values.put(AtmContract.AtmEntry.COLUMN_LAT, atm.getLat());
        values.put(AtmContract.AtmEntry.COLUMN_LON, atm.getLon());
        values.put(AtmContract.AtmEntry.COLUMN_STATUS, atm.getStatus());

        // Inserting Row
        db.insert(AtmContract.AtmEntry.TABLE_NAME, null, values);
        //db.close(); // Closing database connection
    }
    public ArrayList<AtmDetails> listAtm(){
        //String[] list=new String[];
        ArrayList<AtmDetails> list=new ArrayList<>();





        Cursor cursor=db.query(AtmContract.AtmEntry.TABLE_NAME,AtmContract.AtmEntry.ALL_COLUMNS,null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            AtmDetails atm=new AtmDetails();
            /*int bankid=cursor.getInt(0);
            atm.setBankId(bankid);
            int atmid=cursor.getInt(1);
            atm.setAtmId(atmid);
            double lat=cursor.getDouble(2);
            atm.setLat(lat);
            double lon=cursor.getDouble(3);
            atm.setLat(lon);
            int status=cursor.getInt(4);
            atm.setStatus(status);*/

            int atmid= cursor.getInt(cursor.getColumnIndex(AtmContract.AtmEntry._ID));
            int bankid=cursor.getInt(cursor.getColumnIndex(AtmContract.AtmEntry.COLUMN_BANKID));
            double lat=cursor.getDouble(cursor.getColumnIndex(AtmContract.AtmEntry.COLUMN_LAT));
            double lon=cursor.getDouble(cursor.getColumnIndex(AtmContract.AtmEntry.COLUMN_LON));
            int status=cursor.getInt(cursor.getColumnIndex(AtmContract.AtmEntry.COLUMN_STATUS));

            atm.setAtmId(atmid);
            atm.setBankId(bankid);
            atm.setLat(lat);
            atm.setLon(lon);
            atm.setStatus(status);


            //list.add(i,atm);
            //i++;
            list.add(atm);


            // buffer.append(bankid+" "+atmid+" "+lat+" "+lon+" "+status+"\n");
            //buffer.append(" "+atmid+"\n");

        }

        //return buffer.toString();
       // cursor.close();
        return list;

    }



    // Updating single contact
    public int updateAtm(AtmDetails atm) {

        ContentValues values = new ContentValues();
        values.put(AtmContract.AtmEntry._ID, atm.getAtmId());
        values.put(AtmContract.AtmEntry.COLUMN_BANKID, atm.getBankId());
        values.put(AtmContract.AtmEntry.COLUMN_LAT, atm.getLat());
        values.put(AtmContract.AtmEntry.COLUMN_LON, atm.getLon());
        values.put(AtmContract.AtmEntry.COLUMN_STATUS, atm.getStatus());

        // updating row
        return db.update(AtmContract.AtmEntry.TABLE_NAME, values, AtmContract.AtmEntry._ID + " = ?",
                new String[] { String.valueOf(atm.getAtmId()) });
    }

    // Deleting single contact
    public int deleteAtm() {

        int count=db.delete(AtmContract.AtmEntry.TABLE_NAME,null,null);
        db.close();
        return count;
    }


    // Getting contacts Count
    public int getAtmCount() {
        String countQuery = "SELECT  * FROM " + AtmContract.AtmEntry.TABLE_NAME;

        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
