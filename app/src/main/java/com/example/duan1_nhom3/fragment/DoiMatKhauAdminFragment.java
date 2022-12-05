package com.example.duan1_nhom3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_nhom3.Model.Khachhang;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.dao.DaoKhachHang;

import java.util.List;

public class DoiMatKhauAdminFragment extends Fragment {

    private EditText edt_Matkhaucu;
    private EditText edt_Matkhaumoi;
    private EditText edt_NhaplaiMatkhau;
    private Button btn_Capnhap;

    private DaoKhachHang daoKhachHang;
    private List<Khachhang> khachhangs;
    public DoiMatKhauAdminFragment() {
        // Required empty public constructor
    }


    public static DoiMatKhauAdminFragment newInstance() {
        DoiMatKhauAdminFragment fragment = new DoiMatKhauAdminFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doi_mat_khau_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edt_Matkhaucu = view.findViewById(R.id.etPassword);
        edt_Matkhaumoi =view.findViewById(R.id.etPasswordnew1);
        edt_NhaplaiMatkhau = view.findViewById(R.id.etPasswordnew2);
        btn_Capnhap = view.findViewById(R.id.btnupdate);
        btn_Capnhap.setOnClickListener(v ->{
            daoKhachHang = new DaoKhachHang(getContext());
            khachhangs = daoKhachHang.getListKhachHang();
            int i =0;
            for (Khachhang nguoiDung: khachhangs) {
                if (nguoiDung.getMaKhauKH().equalsIgnoreCase(edt_Matkhaucu.getText().toString())) {
                    if (edt_NhaplaiMatkhau.getText().toString().equalsIgnoreCase(edt_Matkhaumoi.getText().toString())) {
                        nguoiDung.setMaKhauKH(edt_Matkhaumoi.getText().toString());
                        daoKhachHang.editKind(nguoiDung);
                        Toast.makeText(getContext(), "Đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Nhập lại mật khẩu không trùng mật khẩu mới", Toast.LENGTH_SHORT).show();
                    }
                    i=1;
                    break;
                }
            }
            if (i == 0) {
                Toast.makeText(getContext(),"Mật khẩu cũ không chính xác", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
