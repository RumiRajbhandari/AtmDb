package com.example.root.atmdatabase2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button add, update, delete, list;
    EditText bankId, lat, lon, status, edit;
    DatabaseHandler db;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.add);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        list = (Button) findViewById(R.id.list);

        // use edittext's hint
        // also using edittext's input type
        bankId = (EditText) findViewById(R.id.bank_id);
        lat = (EditText) findViewById(R.id.bank_lat);
        lon = (EditText) findViewById(R.id.bank_lon);
        status = (EditText) findViewById(R.id.bank_status);
        edit = (EditText) findViewById(R.id.edit);

        db = new DatabaseHandler(this);
        final DatabaseManager manager = new DatabaseManager(db.getWritableDatabase());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AtmDetails atm = new AtmDetails();

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

                // todo add is cursor empty check

                List<AtmDetails> list = manager.listAtm();

                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                // replaced key with static constant
                intent.putParcelableArrayListExtra(AtmDetails.KEY_ATM_DETAILS, (ArrayList<? extends Parcelable>) list);
                startActivity(intent);

            }
        });

        // update to include id deletion
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // todo empty check if input is null

                int count = manager.deleteAtm(Integer.parseInt(edit.getText().toString()));
                Toast.makeText(MainActivity.this, "" + count, Toast.LENGTH_SHORT).show();
            }
        });

    }


}




