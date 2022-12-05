package com.example.duan1_nhom3.Model;

import androidx.annotation.NonNull;

public class TheLoai {
    private int id_theloai;
    private String tentheloai;

    public TheLoai() {
    }

    public TheLoai(int id_theloai, String tentheloai) {
        this.id_theloai = id_theloai;
        this.tentheloai = tentheloai;
    }

    public int getId_theloai() {
        return id_theloai;
    }

    public void setId_theloai(int id_theloai) {
        this.id_theloai = id_theloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    @NonNull
    @Override
    public String toString(){
        return getTentheloai();
    }
}
