package com.example.duan1_nhom3.fragmentAdmin;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.adapter.SanPhamAdapter;
import com.example.duan1_nhom3.adapter.Sanphamadapterfrg;
import com.example.duan1_nhom3.dao.DAOSanPham;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;


public class PhuKienFragment extends Fragment {
    RecyclerView recyclerViewphukien;

    List<SanPham> listsp;
   Sanphamadapterfrg adapter;
    Sanphamadapterfrg.Callback callback;

    public PhuKienFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_phu_kien, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewphukien = view.findViewById(R.id.rcv_phukien);
        TextInputEditText edt_timkiem = view.findViewById(R.id.findphukien);
        edt_timkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
        DAOSanPham daoSanPham = new DAOSanPham(getContext());
        listsp = daoSanPham.selectphukien();
        adapter = new Sanphamadapterfrg(listsp,callback);
        recyclerViewphukien.setAdapter(adapter);
    }


    private void filter(String text) {
        ArrayList<SanPham> filteredList = new ArrayList<>();
        for (SanPham sp: listsp){
            if (sp.getTensp().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(sp);
            }
        }
        adapter.filterList(filteredList);
    }


}