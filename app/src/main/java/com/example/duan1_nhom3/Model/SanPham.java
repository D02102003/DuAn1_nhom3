package com.example.duan1_nhom3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class SanPham implements Parcelable {
    private int masp;
    private String tensp;
    private String giasp;
    private String soluong;
    private int id_theloai;
    private String tentheloai;
    private byte[] sanphamPhoto;
    private boolean select;

    public SanPham() {
    }

    public SanPham(int masp, String tensp, String giasp, String soluong, int id_theloai, String tentheloai, byte[] sanphamPhoto) {
        this.masp = masp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.soluong = soluong;
        this.id_theloai = id_theloai;
        this.tentheloai = tentheloai;
        this.sanphamPhoto = sanphamPhoto;
    }

    protected SanPham(Parcel in) {
        masp = in.readInt();
        tensp = in.readString();
        giasp = in.readString();
        soluong = in.readString();
        id_theloai = in.readInt();
        tentheloai = in.readString();
        sanphamPhoto = in.createByteArray();
        select = in.readByte() != 0;
    }

    public static final Creator<SanPham> CREATOR = new Creator<SanPham>() {
        @Override
        public SanPham createFromParcel(Parcel in) {
            return new SanPham(in);
        }

        @Override
        public SanPham[] newArray(int size) {
            return new SanPham[size];
        }
    };

    public byte[] getSanphamPhoto() {
        return sanphamPhoto;
    }

    public void setSanphamPhoto(byte[] sanphamPhoto) {
        this.sanphamPhoto = sanphamPhoto;
    }

    public int getMasp() {
        return masp;
    }

    public int getId_theloai() {
        return id_theloai;
    }

    public void setId_theloai(int id_theloai) {
        this.id_theloai = id_theloai;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }


    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(masp);
        parcel.writeString(tensp);
        parcel.writeString(giasp);
        parcel.writeString(soluong);
        parcel.writeInt(id_theloai);
        parcel.writeString(tentheloai);
        parcel.writeByteArray(sanphamPhoto);
        parcel.writeByte((byte) (select ? 1 : 0));
    }
}
