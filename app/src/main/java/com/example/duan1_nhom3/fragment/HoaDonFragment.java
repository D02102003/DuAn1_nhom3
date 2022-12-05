package com.example.duan1_nhom3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.duan1_nhom3.MainActivity;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.activity.GiohangActivity;
import com.example.duan1_nhom3.adapter.ViewPager2Adapter;
import com.example.duan1_nhom3.adapter.ViewPager2Adapter2;
import com.example.duan1_nhom3.pagetransformer.DepthPageTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HoaDonFragment extends Fragment {
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    public static HoaDonFragment newInstance() {
        HoaDonFragment fragment = new HoaDonFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hoa_don, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager2);
        bottomNavigationView = view.findViewById(R.id.btn_navigation);
        ViewPager2Adapter2 adapter = new ViewPager2Adapter2(getActivity());
        viewPager2.setAdapter(adapter);
        viewPager2.setPageTransformer(new DepthPageTransformer());

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        //Hiện số lượng sản phẩm chọn
                        ArrayList<SanPham> listChoose = ((MainActivity) requireActivity()).listChoose;
                        Toast.makeText(getContext(), "Số lượng sản phẩm bạn chọn " + (listChoose != null ? listChoose.size() : 0), Toast.LENGTH_SHORT).show();
                        bottomNavigationView.getMenu().findItem(R.id.choxacnhan).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.danggiao).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.dagiaohang).setChecked(true);
                        break;

                }
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.choxacnhan:
                        viewPager2.setCurrentItem(0);


                        break;
                    case R.id.danggiao:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.dagiaohang:
                        viewPager2.setCurrentItem(2);
                        break;

                }
                return true;
            }
        });


    }
}