package com.example.duan1_nhom3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1_nhom3.MainActivity;
import com.example.duan1_nhom3.Model.HoaDon;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.activity.GiohangActivity;
import com.example.duan1_nhom3.adapter.AdapterHoaDon;
import com.example.duan1_nhom3.dao.DaoHoaDon;

import java.util.ArrayList;
import java.util.List;

public class TrangThaiHoaDonFragment extends Fragment {
    private DaoHoaDon daoHoaDon;
    private AdapterHoaDon adapter;
    private List<HoaDon> list;
    private RecyclerView rcvTrangThai;

    public TrangThaiHoaDonFragment() {
        // Required empty public constructor
    }


    public static TrangThaiHoaDonFragment newInstance() {
        TrangThaiHoaDonFragment fragment = new TrangThaiHoaDonFragment();

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
        return inflater.inflate(R.layout.fragment_trang_thai_hoa_don, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvTrangThai = view.findViewById(R.id.rcv_trangthai);
        daoHoaDon = new DaoHoaDon(getContext());

        ArrayList<SanPham> listSanPham = ((MainActivity) requireActivity()).listChoose;
        HoaDon hoaDon = new HoaDon();
        hoaDon.setListSanPham(listSanPham);

        adapter = new AdapterHoaDon();
        rcvTrangThai.setAdapter(adapter);
    }
}