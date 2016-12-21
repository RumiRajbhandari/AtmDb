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
        list=(ListView)findViewById(R.id.listView);
       Intent mIntent = getIntent();
        ArrayList<AtmDetails> atm = mIntent.getParcelableArrayListExtra("UniqueKey");
        System.out.println(atm.isEmpty());
        //Toast.makeText(Main3Activity.this, "success", Toast.LENGTH_SHORT).show();




        RumiAdapter adapter=new RumiAdapter(this,atm);
        list.setAdapter(adapter);
    }

}

class RumiAdapter extends ArrayAdapter<AtmDetails>
{
    Context context;
    ArrayList<AtmDetails> atm;
    private static LayoutInflater inflater=null;
    int atmId, bankId,status;
    Double lat, lon;
    RumiAdapter(Context c, ArrayList<AtmDetails> atm){
        super(c,R.layout.single_row,R.id.atmId,  atm);
        this.context=c;
        this.atm=atm;
        inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       /* this.bankId=atm.getBankId();
        this.lat=atm.getLat();
        this.lon=atm.getLon();
        this.status=atm.getStatus();*/
    }

    public int getCount(){
        return atm.size();
    }

    public AtmDetails getItem(AtmDetails atm){
        return atm;
    }
    public long getItemId(int position){
        return position;
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

        holder.bankId.setText(String.valueOf(atm.get(position).getAtmId()));
        holder.atmId.setText(String.valueOf(atm.get(position).getBankId()));
        holder.lat.setText(Double.toString( atm.get(position).getLat()));
        holder.lon.setText(Double.toString( atm.get(position).getLon()));
        holder.status.setText(String.valueOf(atm.get(position).getStatus()));

        return row;
    }
}


