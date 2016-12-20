package com.example.root.atmdatabase2;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    Button add, update, delete, list;
    EditText bankId, lat, lon, status,edit;
    DatabaseHandler db;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=(Button)findViewById(R.id.add);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.delete);
        list=(Button)findViewById(R.id.list);

        bankId=(EditText)findViewById(R.id.bankId);
        lat=(EditText)findViewById(R.id.lat);
        lon=(EditText)findViewById(R.id.lon);
        status=(EditText)findViewById(R.id.status);
        edit=(EditText)findViewById(R.id.edit);

        db = new DatabaseHandler(this);
        final DatabaseManager manager=new DatabaseManager(db.getWritableDatabase());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AtmDetails atm=new AtmDetails();

                atm.setBankId(Integer.parseInt(bankId.getText().toString()));
                atm.setLat(Double.parseDouble(lat.getText().toString()));
                atm.setLon(Double.parseDouble(lon.getText().toString()));
                atm.setStatus(Integer.parseInt(status.getText().toString()));
                manager.addAtm(atm);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ArrayList<AtmDetails> list=manager.listAtm();
               // AtmDetails list= manager.listAtm();
               /* Intent i=getIntent();
                i.putStringArrayListExtra("text",(ArrayList<String>list);
                startActivity(i);*/
                //Toast.makeText(MainActivity.this, ""+display, Toast.LENGTH_SHORT).show();
                /*for (AtmDetails am : list) {
                    String log = "AtmId: "+am.getAtmId()+" ,BankId: " + am.getBankId() + " ,Latitude: " + am.getLat()+ " ,Longitude: " + am.getLon()+ " ,Status: " + am.getStatus();
                    // Writing Contacts to log
                    Log.d("Name: ", log);}*/

               /* Intent intent=new Intent(getBaseContext(),Main3Activity.class);
                intent.putExtra("rumi", (ArrayList<AtmDetails>) list);
                startActivity(intent);*/

                Intent mIntent = new Intent(MainActivity.this, Main3Activity.class);
                mIntent.putParcelableArrayListExtra("UniqueKey", list);
                startActivity(mIntent);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=manager.deleteAtm();
                Toast.makeText(MainActivity.this, ""+count, Toast.LENGTH_SHORT).show();

            }
        });

    }


}




