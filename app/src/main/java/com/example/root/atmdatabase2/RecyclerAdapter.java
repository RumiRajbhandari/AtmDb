package com.example.root.atmdatabase2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 12/16/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private List<AtmDetails> atmList;
    int bankId,atmId,status;
    Double lat, lon;
    public RecyclerAdapter(List<AtmDetails> atmDetails){
        this.atmList=atmDetails;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        AtmDetails atmDetails=atmList.get(position);

        holder.atmId1.setText(atmDetails.getAtmId());
        holder.bankId1.setText(atmDetails.getBankId());
        holder.lat1.setText((int) atmDetails.getLat());
        holder.lon1.setText((int) atmDetails.getLon());
        holder.status1.setText(atmDetails.getStatus());
    }

    @Override
    public int getItemCount() {
        return atmList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
       TextView bankId1,atmId1,status1;
        TextView lat1, lon1;

        public RecyclerViewHolder(View view){
            super(view);
            bankId1=(TextView)view.findViewById(R.id.bankId);
            atmId1=(TextView)view.findViewById(R.id.atmId);
            status1=(TextView)view.findViewById(R.id.status);
            lat1=(TextView) view.findViewById(R.id.lat);
            lon1=(TextView)view.findViewById(R.id.lon);
        }
    }
    }

