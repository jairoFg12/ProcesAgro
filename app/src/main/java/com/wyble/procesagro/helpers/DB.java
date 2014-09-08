package com.wyble.procesagro.helpers;

/**
 * Created by david on 9/7/14.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

public class DB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ProcesAgro.db";

    private String tableName;
    private JSONArray tableData;

    public DB(Context context, String tableName, JSONArray tableData) {
        super(context, DATABASE_NAME, null, 1);
        this.tableName = tableName;
        this.tableData = tableData;
        if (tableData != null) {
            this.emptyData();
            this.insertData();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableFields = this.join(this.getTableFields(), ", ");
        String sql = "CREATE TABLE IF NOT EXISTS " + this.tableName + " (autoId INTEGER PRIMARY KEY AUTOINCREMENT, " + tableFields + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + this.tableName);
        this.onCreate(db);
    }

    private void emptyData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(this.tableName, null, null);
        db.delete("SQLITE_SEQUENCE","NAME = ?",new String[]{this.tableName});
    }

    public void insertData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (int i = 0; i < this.tableData.length(); i++) {
            try {
                JSONObject jsonObject = this.tableData.getJSONObject(i);
                for (String tf : this.getTableFields()) {
                    contentValues.put(tf, jsonObject.getString(tf));
                }
                db.insert(this.tableName, null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<HashMap> getAllData() {
        ArrayList data = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + this.tableName, null);
        res.moveToFirst();
        while(res.isAfterLast() == false){
            HashMap obj = new HashMap();
            for (int j=0; j < res.getColumnCount(); j++) {
                obj.put(res.getColumnName(j), res.getString(res.getColumnIndex(res.getColumnName(j))));
            }
            data.add(obj);
            res.moveToNext();
        }
        res.close();
        return data;
    }

    private ArrayList<String> getTableFields() {
        ArrayList tableFields = new ArrayList();
        for (int i = 0; i < this.tableData.length(); i++) {
            try {
                JSONObject jsonObject = this.tableData.getJSONObject(i);
                for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
                    tableFields.add(String.valueOf(it.next()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
        return tableFields;
    }

    private String join(ArrayList<String> r, String delimiter) {
        if(r == null || r.size() == 0 ){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i, len = r.size() - 1;
        for (i = 0; i < len; i++){
            sb.append(r.get(i) + delimiter);
        }
        return sb.toString() + r.get(i);
    }

}
