package com.example.duan1_nhom3.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.Sanphamgiohang;
import com.example.duan1_nhom3.database.MySqlHelper;

import java.util.ArrayList;
import java.util.List;

public class DAOSanPhamgh {
    MySqlHelper mMySqlHeper;
    SQLiteDatabase mSQLiteDatabase;

    public DAOSanPhamgh(Context context) {
        mMySqlHeper = new MySqlHelper(context);
    }

    public List<SanPham> selectAll(){
        List<SanPham> list= new ArrayList<>();
        mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String select = "select * from GIOHANG";
        Cursor c = mSQLiteDatabase.rawQuery(select, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            SanPham obj= new SanPham();
            obj.setMasp(c.getInt(0));
            obj.setTensp(c.getString(1));
            obj.setGiasp(c.getString(2));
            obj.setSoluong(c.getString(3));
            obj.setSanphamPhoto(c.getBlob(4));
            obj.setId_theloai(c.getInt(5));
            obj.setTentheloai(c.getString(6));
            list.add(obj);
            c.moveToNext();
        }

        c.close();
        return list;
    }


    public boolean them_SanPham2(SanPham sp){
        mSQLiteDatabase= mMySqlHeper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENSP", sp.getTensp());
        values.put("GIASP", sp.getGiasp());
        values.put("SOLUONGSP", sp.getSoluong());
        values.put("ANHSP", sp.getSanphamPhoto());
        values.put("TENLOAISP", sp.getTentheloai());
        Log.e("Duong","Thêm sản phẩm");
        long row = this.mSQLiteDatabase.insert("GIOHANG",null,values);
        if (row <= 0){
            Log.e("manh1","Thêm thất bại");
            return  false;
        }
        Log.e("manh","Thêm thành công vào database");
        return true;

    }
}