package com.example.root.atmdatabase2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        AtmDetails atm = getIntent().getExtras().getParcelable(AtmDetails.KEY_ATM_DETAILS);
        // since our list adapter is expecting a list of objects and also since we are
        // sending a list of objects to this activity, we shall fetch a list of objects
        list = (ListView) findViewById(R.id.listView);

        List<AtmDetails> atmList = getIntent().getExtras().getParcelableArrayList(AtmDetails.KEY_ATM_DETAILS);
        RumiAdapter adapter = new RumiAdapter(this, atmList);
        list.setAdapter(adapter);
    }


    //    public class RumiAdapter extends ArrayAdapter<String> {
// We are creating a list of AtmDetails here
    public class RumiAdapter extends ArrayAdapter<AtmDetails> {

        private static final String TAG = "DEBUG";
        Context context;

        RumiAdapter(Context c, List<AtmDetails> atmList) {
            super(c, R.layout.single_row, 0, atmList);
            this.context = c;
        }

        class MyViewHolder {

            TextView bankId, atmId, lat, lon, status;

            MyViewHolder(View view) {
                // great work here :) initializing everything in the constructor
                // kudos!
                bankId = (TextView) view.findViewById(R.id.bank_id);
                atmId = (TextView) view.findViewById(R.id.atm_id);
                lat = (TextView) view.findViewById(R.id.bank_lat);
                lon = (TextView) view.findViewById(R.id.bank_lon);
                status = (TextView) view.findViewById(R.id.bank_status);
            }
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            MyViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.single_row, parent, false);
                holder = new MyViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (MyViewHolder) convertView.getTag();
            }

            // fetch atm details
            AtmDetails details = getItem(position);
            Log.e(TAG, "getView: " + details);

            // using String.format to initialize text rather than string concat
            // for more refer to https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
            holder.bankId.setText(String.format("Bank id: %s", String.valueOf(details.getBankId())));
            holder.atmId.setText(String.format("Atm id: %s", String.valueOf(details.getAtmId())));
            holder.lat.setText(String.format("Bank lat: %s", String.valueOf(details.getLat())));
            holder.lon.setText(String.format("Bank lon: %s", String.valueOf(details.getLon())));
            holder.status.setText(String.format("Bank status: %s", String.valueOf(details.getStatus())));
            return convertView;
        }
    }
}




