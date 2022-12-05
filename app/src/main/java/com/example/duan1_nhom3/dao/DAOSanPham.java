package com.example.duan1_nhom3.dao;

import static com.example.duan1_nhom3.database.MySqlHelper.KEY_KHACHHANG_IMAGEKH;
import static com.example.duan1_nhom3.database.MySqlHelper.KEY_KHACHHANG_MAKH;
import static com.example.duan1_nhom3.database.MySqlHelper.TABLE_NAME_KHACHHANG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.database.MySqlHelper;

import java.util.ArrayList;
import java.util.List;

public class DAOSanPham {
    MySqlHelper mMySqlHeper;
    SQLiteDatabase mSQLiteDatabase;

    public DAOSanPham(Context context) {
        mMySqlHeper = new MySqlHelper(context);
    }

    public List<SanPham> selectAll(){
        List<SanPham> list= new ArrayList<>();
        mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String select = "select * from SANPHAM";
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

    public List<SanPham> selectquan(){
        List<SanPham> list= new ArrayList<>();
        mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String select = "select * from SANPHAM WHERE TENLOAISP IN ('Quần nam','Quần nữ')" ;
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
    public List<SanPham> selectao(){
        List<SanPham> list= new ArrayList<>();
        mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String select = "select * from SANPHAM WHERE TENLOAISP IN ('Áo nam','Áo Nữ')" ;
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
    public List<SanPham> selectphukien(){
        List<SanPham> list= new ArrayList<>();
        mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String select = "select * from SANPHAM WHERE TENLOAISP IN ('Phụ kiện nam','Phụ kiện nữ')" ;
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
    public boolean them_SanPham1(SanPham sp){
        mSQLiteDatabase= mMySqlHeper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENSP", sp.getTensp());
        values.put("GIASP", sp.getGiasp());
        values.put("SOLUONGSP", sp.getSoluong());
        values.put("ANHSP", sp.getSanphamPhoto());
        values.put("TENLOAISP", sp.getTentheloai());
        Log.e("Duong","Thêm sản phẩm");
        long row = this.mSQLiteDatabase.insert("SANPHAM",null,values);
        if (row <= 0){
            Log.e("manh1","Thêm thất bại");
            return  false;
        }
        Log.e("manh","Thêm thành công vào database");
        return true;

    }
    public boolean updatesanpham(SanPham sp){
        mSQLiteDatabase= mMySqlHeper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENSP", sp.getTensp());
        values.put("GIASP", sp.getGiasp());
        values.put("SOLUONGSP", sp.getSoluong());
        values.put("ANHSP", sp.getSanphamPhoto());
        values.put("TENLOAISP", sp.getTentheloai());
        Log.e("Duong","Update sản phẩm");
        long row = this.mSQLiteDatabase.update("SANPHAM",values,"MASP = ?",new String[]{String.valueOf(sp.getMasp())});
        if (row <= 0){
            Log.e("manh1","Update thất bại");
            return  false;
        }
        Log.e("manhupdate","Thêm thành công vào database");
        return true;

    }

}
