package com.example.root.atmdatabase2;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       // AtmDetails atm=getIntent().getExtras().getParcelable("rumi");
       Intent mIntent = getIntent();
        ArrayList<AtmDetails> mUsers = mIntent.getParcelableArrayListExtra("UniqueKey");
        Toast.makeText(Main3Activity.this, "success", Toast.LENGTH_SHORT).show();

        list=(ListView)findViewById(R.id.listView);


       /* RumiAdapter adapter=new RumiAdapter(this,mUsers);
        list.setAdapter(adapter);*/
    }
}

class RumiAdapter extends ArrayAdapter<String>
{
    Context context;
    int atmId, bankId,status;
    Double lat, lon;
    RumiAdapter(Context c, AtmDetails atm){
        super(c,R.layout.single_row,R.id.atmId, (List<String>) atm);
        this.context=c;
        this.atmId=atm.getAtmId();
        this.bankId=atm.getBankId();
        this.lat=atm.getLat();
        this.lon=atm.getLon();
        this.status=atm.getStatus();
    }
    class MyViewHolder
    {
        TextView bankId, atmId, lat, lon, status;


        MyViewHolder(View view)
        {
            bankId=(TextView)view.findViewById(R.id.bankId);
            atmId=(TextView)view.findViewById(R.id.atmId);
            lat=(TextView)view.findViewById(R.id.lat);
            lon=(TextView)view.findViewById(R.id.lon);
            status=(TextView)view.findViewById(R.id.status);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        MyViewHolder holder=null;
        if(row==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.single_row,parent,false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder=(MyViewHolder)row.getTag();
        }

        holder.bankId.setText(bankId);
        holder.atmId.setText(atmId);
        holder.lat.setText(lat.toString());
        holder.lon.setText(lon.toString());
        holder.status.setText(status);

        return row;
    }
}


