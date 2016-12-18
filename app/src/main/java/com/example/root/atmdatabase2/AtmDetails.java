package com.example.root.atmdatabase2;

import java.io.Serializable;

/**
 * Created by root on 12/14/16.
 */
public class AtmDetails {
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
}
