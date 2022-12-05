package com.example.duan1_nhom3.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME_KHACHHANG = "KHACHHANG";
    public static final String KEY_KHACHHANG_MAKH = "MAKHACHHANG";
    public static final String KEY_KHACHHANG_TAIKHOAN = "TAIKHOANKHACHHANG";
    public static final String KEY_KHACHHANG_HOTENKH = "HOTENKHACHHANG";
    public static final String KEY_KHACHHANG_NAM = "NAMSINHKHACHHANG";
    public static final String KEY_KHACHHANG_MATKHAUKH = "MATKHAUKHACHHANG";
    public static final String KEY_KHACHHANG_IMAGEKH = "IMAGEKHACHHANG";

    public static final String TABLE_NAME_HOADON = "HOADON";
    public static final String KEY_HOADON_MAHD = "MAHOADON";
    public static final String KEY_HOADON_TENSANPHAM = "TENSANPHAMHD";
    public static final String KEY_HOADON_TENKHACHHANG = "TENKHACHHANGHD";
    public static final String KEY_HOADON_GIASANPHAM = "GIASANPHAMHD";
    public static final String KEY_HOADON_IMAGESANPHAM = "IMAGESANPHAMHD";
    public static final String KEY_HOADON_SOLUONGSANPHAM = "SOLUONGSANPHAMHD";
    public static final String KEY_HOADON_NGAYMUASANPHAM = "NGAYMUASANPHAMHD";
    public static final String KEY_HOADON_NGAYDUDINHGIAOSANPHAM = "NGAYDUDINHGIAOSANPHAMHD";


    public MySqlHelper(Context context){
        super(context,"QuangLong",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql1 = "CREATE TABLE " + TABLE_NAME_KHACHHANG
                + "("
                + KEY_KHACHHANG_MAKH + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_KHACHHANG_HOTENKH + " TEXT NOT NULL ,"
                + KEY_KHACHHANG_TAIKHOAN + " TEXT NOT NULL ,"
                + KEY_KHACHHANG_NAM + " TEXT NOT NULL ,"
                + KEY_KHACHHANG_MATKHAUKH + " TEXT NOT NULL,"
                + KEY_KHACHHANG_IMAGEKH + " BLOB "
                + ")";
        sqLiteDatabase.execSQL(sql1);
        sql1  = "INSERT INTO " + TABLE_NAME_KHACHHANG + " VALUES ( null,'Bui Quang Long','buiquanglong','2002' ,'123456' , null)";
        sqLiteDatabase.execSQL(sql1);
        String sql3 = "CREATE TABLE LOAISP(MALSP INTEGER PRIMARY KEY AUTOINCREMENT,TENLOAISP TEXT NOT NULL )";
        sqLiteDatabase.execSQL(sql3);
        sql3 ="INSERT INTO LOAISP VALUES ( null ,'Quần nam'),( null ,'Áo nam'),( null ,'Quần nữ'),( null ,'Áo Nữ'),( null ,'Phụ kiện nam'),( null ,'Phụ kiện nữ')" ;
        sqLiteDatabase.execSQL(sql3);
        String sql2 = "CREATE TABLE SANPHAM(MASP INTEGER PRIMARY KEY AUTOINCREMENT,TENSP TEXT NOT NULL, GIASP TEXT NOT NULL, SOLUONGSP TEXT NOT NULL, ANHSP BLOB,MALSP INTERGER , TENLOAISP TEXT NOT NULL )";
        sqLiteDatabase.execSQL(sql2);
        String sql4 = "CREATE TABLE GIOHANG(MASP INTEGER PRIMARY KEY AUTOINCREMENT,TENSP TEXT NOT NULL, GIASP TEXT NOT NULL, SOLUONGSP TEXT NOT NULL, ANHSP BLOB,MALSP INTERGER , TENLOAISP TEXT NOT NULL )";
        sqLiteDatabase.execSQL(sql4);
        String sql5 = "CREATE TABLE HOADON(MAHD INTEGER PRIMARY KEY AUTOINCREMENT, TENSANPHAMHD TEXT NOT NULL, GIASANPHAMHD MONEY NOT NULL, SOLUONGSANPHAMHD INTEGER NOT NULL, NGAYMUASANPHAMHD DATE NOT NULL, NGAYDUDINHGIAOSANPHAMHD DATE NOT NULL, IMAGESANPHAMHD BLOB )";

//        String sql5 = "CREATE TABLE " + TABLE_NAME_HOADON
//                + "("
//                + KEY_HOADON_MAHD + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + KEY_HOADON_TENSANPHAM + " TEXT NOT NULL ,"
//                + KEY_HOADON_GIASANPHAM + " MONEY NOT NULL ,"
//                + KEY_HOADON_SOLUONGSANPHAM + " INTEGER NOT NULL ,"
//                + KEY_HOADON_NGAYMUASANPHAM + " DATE NOT NULL ,"
//                + KEY_HOADON_NGAYDUDINHGIAOSANPHAM + " DATE NOT NULL,"
//                + KEY_HOADON_IMAGESANPHAM + " BLOB "
//                + ")";
        sqLiteDatabase.execSQL(sql5);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
