package com.example.duan1_nhom3.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.duan1_nhom3.Model.TheLoai;
import com.example.duan1_nhom3.database.MySqlHelper;

import java.util.ArrayList;
import java.util.List;
public class DAOTheLoai {
    MySqlHelper helper;
    SQLiteDatabase database;

    public DAOTheLoai(Context context) {
       helper  = new MySqlHelper(context);
    }

    public List<TheLoai> getALL_theloai(){
        List<TheLoai> theLoaiList = new ArrayList<>();
        database = helper.getReadableDatabase();
        Cursor cursor =database.rawQuery("SELECT*FROM LOAISP",null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()){
                TheLoai theLoai = new TheLoai();
                theLoai.setId_theloai(cursor.getInt(0));
                theLoai.setTentheloai(cursor.getString(1));
                theLoaiList.add(theLoai);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return theLoaiList;
    }
}
