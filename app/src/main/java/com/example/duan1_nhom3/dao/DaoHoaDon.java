package com.example.duan1_nhom3.dao;

import static com.example.duan1_nhom3.database.MySqlHelper.KEY_HOADON_GIASANPHAM;
import static com.example.duan1_nhom3.database.MySqlHelper.KEY_HOADON_IMAGESANPHAM;
import static com.example.duan1_nhom3.database.MySqlHelper.KEY_HOADON_SOLUONGSANPHAM;
import static com.example.duan1_nhom3.database.MySqlHelper.KEY_HOADON_TENKHACHHANG;
import static com.example.duan1_nhom3.database.MySqlHelper.KEY_HOADON_TENSANPHAM;
import static com.example.duan1_nhom3.database.MySqlHelper.TABLE_NAME_HOADON;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_nhom3.Model.HoaDon;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.Sanphamgiohang;
import com.example.duan1_nhom3.database.MySqlHelper;

import java.util.ArrayList;
import java.util.List;

public class DaoHoaDon {
    MySqlHelper mySqlHelper;
    SQLiteDatabase sqLiteDatabase;
    public DaoHoaDon(Context context){
        mySqlHelper = new MySqlHelper(context);
    }

    public boolean them_HoaDon(SanPham sp){
        sqLiteDatabase= mySqlHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_HOADON_TENSANPHAM, sp.getTensp());
        values.put(KEY_HOADON_GIASANPHAM, sp.getGiasp());
        values.put(KEY_HOADON_SOLUONGSANPHAM, sp.getSoluong());
        values.put(KEY_HOADON_IMAGESANPHAM, sp.getSanphamPhoto());
        Log.e("Duong","Thêm sản phẩm");
        long row = this.sqLiteDatabase.insert(TABLE_NAME_HOADON,null,values);
        if (row <= 0){
            Log.e("manh1","Thêm thất bại");
            return  false;
        }
        Log.e("manh","Thêm thành công vào database");
        return true;

    }
    public List<HoaDon> selectAll(){
        List<HoaDon> list= new ArrayList<>();
        sqLiteDatabase = mySqlHelper.getReadableDatabase();
        String select = "select * from " + TABLE_NAME_HOADON;
        Cursor c = sqLiteDatabase.rawQuery(select, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            HoaDon obj= new HoaDon();
            obj.setMaHD(c.getInt(0));
            obj.setTenSanPhamHD(c.getString(1));
            obj.setTenKH(c.getString(2));
            obj.setGiaSanPhamHD(c.getInt(3));
            obj.setSoLuongHD(c.getInt(4));
            obj.setNgayMua(c.getString(5));
            obj.setNgayDuKien(c.getString(6));
            obj.setSanphamPhoto(c.getBlob(7));
            list.add(obj);
            c.moveToNext();
        }

        c.close();
        return list;
    }
}
