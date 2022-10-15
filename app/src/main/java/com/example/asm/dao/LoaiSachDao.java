package com.example.asm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm.DBhelperne;
import com.example.asm.model.LoaiSach;
import java.util.ArrayList;
import java.util.List;

public class LoaiSachDao {
    private DBhelperne mySQLite;
    private SQLiteDatabase db;
    public LoaiSachDao(Context context){
        mySQLite = new DBhelperne(context);
        db = mySQLite.getWritableDatabase();
    }
    public long insert(LoaiSach l){
        ContentValues values=new ContentValues();
        values.put("tenLoai",l.getTenLoai());
        return db.insert("LoaiSach",null,values);
    }
    public int upate(LoaiSach l){
        ContentValues values=new ContentValues();
        values.put("tenLoai",l.getTenLoai());
        return db.update("LoaiSach",values,"maLoai=?",new String[]{l.getMaLoai()+""});
    }
    public int delete(int s){
        return db.delete("LoaiSach","maLoai=?",new String[]{s+""});
    }
    public List<LoaiSach> getDaTa(String sql, String...selectionArgs){
        List<LoaiSach> list=new ArrayList<>();
        Cursor c=db.rawQuery(sql,selectionArgs);
        if (c.getCount() > 0) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                int a = c.getInt(0);
                String b = c.getString(1);
                list.add(new LoaiSach(a,b));
                c.moveToNext();
            }
            c.close();
        }
        return list;
    }
    public List<LoaiSach> getAll(){
        String sql="select * from LoaiSach";
        return getDaTa(sql);
    }
    public LoaiSach getID(String id){
        String sql="select * from LoaiSach where maLoai=?";
        List<LoaiSach> list=getDaTa(sql,id);
        return list.get(0);
    }
}
