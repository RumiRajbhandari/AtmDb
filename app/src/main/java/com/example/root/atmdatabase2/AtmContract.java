package com.example.root.atmdatabase2;

import android.provider.BaseColumns;

/**
 * Created by root on 12/17/16.
 */
public final class AtmContract {
    private AtmContract() {
    }

    public static class AtmEntry implements BaseColumns {

        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "atmNepal";
        public static final String TABLE_NAME = "ATM";


        // private static final String COLUMN_ATMID="_atmId";
        public static final String COLUMN_BANKID = "bankId";
        public static final String COLUMN_LAT = "lat";
        public static final String COLUMN_LON = "lon";
        public static final String COLUMN_STATUS = "status";

        public static final String[] ALL_COLUMNS = {_ID, COLUMN_BANKID, COLUMN_LAT, COLUMN_LON, COLUMN_STATUS};

        public static final String[] COLUMN_METADATA() {
            String atmIdInfo = _ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ";
            String bankIdInfo = COLUMN_BANKID + " INTEGER";
            String latInfo = COLUMN_LAT + " DOUBLE";
            String lonInfo = COLUMN_LON + " DOUBLE";
            String statusInfo = COLUMN_STATUS + " INTEGER";
            return new String[]{atmIdInfo, bankIdInfo, latInfo, lonInfo, statusInfo};
        }

    }

}
