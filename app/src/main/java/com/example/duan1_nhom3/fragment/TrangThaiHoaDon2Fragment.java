package com.example.duan1_nhom3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1_nhom3.R;
public class TrangThaiHoaDon2Fragment extends Fragment {




    public TrangThaiHoaDon2Fragment() {
        // Required empty public constructor
    }


    public static TrangThaiHoaDon2Fragment newInstance() {
        TrangThaiHoaDon2Fragment fragment = new TrangThaiHoaDon2Fragment();

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
        return inflater.inflate(R.layout.fragment_trang_thai_hoa_don2, container, false);
    }
}