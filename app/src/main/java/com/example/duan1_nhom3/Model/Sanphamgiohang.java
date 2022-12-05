package com.example.duan1_nhom3.Model;

public class Sanphamgiohang {
    private int masp;
    private String tensp;
    private String giasp;
    private String soluong;
    private int id_theloai;
    private String tentheloai;
    private byte[] sanphamPhoto;

    public Sanphamgiohang() {
    }

    public Sanphamgiohang(int masp, String tensp, String giasp, String soluong, int id_theloai, String tentheloai, byte[] sanphamPhoto) {
        this.masp = masp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.soluong = soluong;
        this.id_theloai = id_theloai;
        this.tentheloai = tentheloai;
        this.sanphamPhoto = sanphamPhoto;
    }

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
}
