package com.example.duan1_nhom3.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.adapter.ViewPager2Adapter;
import com.example.duan1_nhom3.fragmentAdmin.AoFragment;
import com.example.duan1_nhom3.fragmentAdmin.PhuKienFragment;
import com.example.duan1_nhom3.fragmentAdmin.QuanFragment;
import com.example.duan1_nhom3.pagetransformer.DepthPageTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SanPhamFragment extends Fragment {
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;


    public SanPhamFragment() {
    }

    public static SanPhamFragment newInstance() {
        SanPhamFragment fragment = new SanPhamFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_san_pham, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager2);
        bottomNavigationView = view.findViewById(R.id.btn_navigation);
        ViewPager2Adapter adapter = new ViewPager2Adapter(getActivity());
        viewPager2.setAdapter(adapter);
        viewPager2.setPageTransformer(new DepthPageTransformer());

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_ao).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_quan).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_phukien).setChecked(true);
                        break;
                }
            }
        });



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_ao:
                        viewPager2.setCurrentItem(0);


                        break;
                    case R.id.menu_quan:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.menu_phukien:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });


    }

}