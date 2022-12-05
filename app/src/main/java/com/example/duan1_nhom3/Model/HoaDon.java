package com.example.duan1_nhom3.Model;

import java.util.ArrayList;
import java.util.List;

public class HoaDon {
    private int maHD;
    private int idKH;
    private String tenKH;
    private float giaSanPhamHD;
    private int soLuongHD;
    private String ngayMua;
    private String ngayDuKien;
    private byte[] sanphamPhoto;
    private ArrayList<SanPham> listSanPham;

    public HoaDon() {
    }

    public HoaDon(int maHD, String tenSanPhamHD, int idKH, String tenKH, float giaSanPhamHD, int soLuongHD, String ngayMua, String ngayDuKien, byte[] sanphamPhoto, ArrayList<SanPham> listSanPham) {
        this.maHD = maHD;
        this.tenSanPhamHD = tenSanPhamHD;
        this.idKH = idKH;
        this.tenKH = tenKH;
        this.giaSanPhamHD = giaSanPhamHD;
        this.soLuongHD = soLuongHD;
        this.ngayMua = ngayMua;
        this.ngayDuKien = ngayDuKien;
        this.sanphamPhoto = sanphamPhoto;
        this.listSanPham = listSanPham;
    }

    public HoaDon(int maHD, String tenSanPhamHD, int idKH, String tenKH, float giaSanPhamHD, int soLuongHD, String ngayMua, String ngayDuKien, byte[] sanphamPhoto) {
        this.maHD = maHD;
        this.tenSanPhamHD = tenSanPhamHD;
        this.idKH = idKH;
        this.tenKH = tenKH;
        this.giaSanPhamHD = giaSanPhamHD;
        this.soLuongHD = soLuongHD;
        this.ngayMua = ngayMua;
        this.ngayDuKien = ngayDuKien;
        this.sanphamPhoto = sanphamPhoto;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getTenSanPhamHD() {
        return tenSanPhamHD;
    }

    public void setTenSanPhamHD(String tenSanPhamHD) {
        this.tenSanPhamHD = tenSanPhamHD;
    }

    public float getGiaSanPhamHD() {
        return giaSanPhamHD;
    }

    public void setGiaSanPhamHD(float giaSanPhamHD) {
        this.giaSanPhamHD = giaSanPhamHD;
    }

    public int getSoLuongHD() {
        return soLuongHD;
    }

    public void setSoLuongHD(int soLuongHD) {
        this.soLuongHD = soLuongHD;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getNgayDuKien() {
        return ngayDuKien;
    }

    public void setNgayDuKien(String ngayDuKien) {
        this.ngayDuKien = ngayDuKien;
    }

    public byte[] getSanphamPhoto() {
        return sanphamPhoto;
    }

    public void setSanphamPhoto(byte[] sanphamPhoto) {
        this.sanphamPhoto = sanphamPhoto;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }
}
