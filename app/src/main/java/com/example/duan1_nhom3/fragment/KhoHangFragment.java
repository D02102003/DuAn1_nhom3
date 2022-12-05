package com.example.duan1_nhom3.fragment;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1_nhom3.MainActivity;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.TheLoai;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.adapter.SanPhamAdapter;
import com.example.duan1_nhom3.dao.DAOSanPham;
import com.example.duan1_nhom3.dao.DAOTheLoai;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class KhoHangFragment extends Fragment implements SanPhamAdapter.Callback{

RecyclerView recyclerView;
DAOSanPham daoSanPham;
List<SanPham> listsp;
SanPhamAdapter adapter;
SanPhamAdapter.Callback callback;
    CircleImageView idImagesanpham;
    final int REQUEST_CODE_GALLERY = 999;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_kho_hang, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcv_Sanpham);

        daoSanPham = new DAOSanPham(getContext());
        listsp = daoSanPham.selectAll();
        adapter = new SanPhamAdapter(listsp,callback);
        recyclerView.setAdapter(adapter);

    }


    @Override
  public void xoaa(SanPham sanPham) {

    }

    @Override
    public void dialogupdatesanpham(SanPham sanPham) {
        final Dialog dialog1 = new Dialog(getContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog1.setContentView(R.layout.dialog_suasanpham);
        Log.e("Long","Bắt đầu sửa sản phẩm");
        EditText edtten = dialog1.findViewById(R.id.tvNameSanPhamsua);
        EditText edtgia = dialog1.findViewById(R.id.tvGiaSanPhamsua);
        EditText edtsoluong = dialog1.findViewById(R.id.tv_soluongsua);
        Spinner spn_tenTheloai = dialog1.findViewById(R.id.spSanPham);

        edtten.setText(sanPham.getTensp());
        edtgia.setText(sanPham.getGiasp());
        edtsoluong.setText(sanPham.getSoluong());
        DAOTheLoai daoTheLoai = new DAOTheLoai(getContext());
        ArrayAdapter<TheLoai> sachArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_text, daoTheLoai.getALL_theloai());
        spn_tenTheloai.setAdapter(sachArrayAdapter);
        dialog1.findViewById(R.id.btnThemSanPhamsua).setOnClickListener(v -> {
            DAOSanPham daoSanPham = new DAOSanPham(getContext());
            SanPham sach = new SanPham();
            Log.e("Long","Lưu sản phẩm sửa");
            sach.setTensp(edtten.getText().toString());
            sach.setGiasp(edtgia.getText().toString());
            sach.setSoluong(edtsoluong.getText().toString());


            sach.setTentheloai(spn_tenTheloai.getSelectedItem().toString());

            Log.e("Long","Thêm sản phẩm thành công");
            daoSanPham.updatesanpham(sach);


            Toast.makeText(getContext(), "Đã thêm sản phẩm " + edtten.getText().toString(), Toast.LENGTH_SHORT).show();
            dialog1.dismiss();
        });
        dialog1.findViewById(R.id.btnXoaText).setOnClickListener(v -> {
            dialog1.dismiss();
        });

      dialog1.show();



    }
}