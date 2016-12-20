package com.example.root.atmdatabase2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by root on 12/14/16.
 */
public class AtmDetails implements Parcelable {
    int atmId;
    int bankId;
    double lat;
    double lon;
    int status;

    public AtmDetails(){

    }
    public AtmDetails(int atmId, int bankId, double lat, double lon, int status){
        this.atmId=atmId;
        this.bankId=bankId;
        this.lat=lat;
        this.lon=lon;
        this.status=status;
    }
    public AtmDetails(int bankId, double lat, double lon,int status){

        this.bankId=bankId;
        this.lat=lat;
        this.lon=lon;
        this.status=status;

    }

    public static final Creator<AtmDetails> CREATOR = new Creator<AtmDetails>() {
        @Override
        public AtmDetails createFromParcel(Parcel in) {
            return new AtmDetails(in);
        }

        @Override
        public AtmDetails[] newArray(int size) {
            return new AtmDetails[size];
        }
    };

    public void setAtmId(int atmId){
        this.atmId=atmId;
    }
    public void setBankId(int bankId){
        this.bankId=bankId;
    }
    public void setLat(double lat)
    {
        this.lat=lat;
    }
    public void setLon(double lon){
        this.lon=lon;
    }
    public void setStatus(int status){
        this.status=status;
    }
    public int getAtmId(){
        return this.atmId;
    }
    public int getBankId(){
        return this.bankId;
    }
    public double getLat(){
        return this.lat;
    }
    public double getLon(){
        return this.lon;
    }
    public int getStatus(){
        return this.status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(atmId);
        dest.writeInt(bankId);
        dest.writeDouble(lat);
        dest.writeDouble(lon);
        dest.writeInt(status);

    }
    public static final Parcelable.Creator<AtmDetails> myContract= new Creator<AtmDetails>() {
        @Override
        public AtmDetails createFromParcel(Parcel source) {
            return new AtmDetails(source);
        }

        @Override
        public AtmDetails[] newArray(int size) {
            return new AtmDetails[size];
        }
    };
    public AtmDetails(Parcel source){
        atmId=source.readInt();
        bankId=source.readInt();
        lat=source.readDouble();
        lon=source.readDouble();
        status=source.readInt();
    }
}
