package com.example.duan1_nhom3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.duan1_nhom3.R;


public class DoanhThuFragment extends Fragment {


    public DoanhThuFragment() {
        // Required empty public constructor
    }

    public static DoanhThuFragment newInstance() {
        DoanhThuFragment fragment = new DoanhThuFragment();

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
        return inflater.inflate(R.layout.fragment_doanh_thu, container, false);
    }
}