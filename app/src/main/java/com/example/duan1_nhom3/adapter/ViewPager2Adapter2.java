package com.example.duan1_nhom3.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1_nhom3.fragment.TrangThaiHoaDon1Fragment;
import com.example.duan1_nhom3.fragment.TrangThaiHoaDon2Fragment;
import com.example.duan1_nhom3.fragment.TrangThaiHoaDonFragment;

public class ViewPager2Adapter2 extends FragmentStateAdapter {
    public ViewPager2Adapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TrangThaiHoaDonFragment();
            case 1:
                return new TrangThaiHoaDon1Fragment();
            case 2:
                return new TrangThaiHoaDon2Fragment();
            default:
                return new TrangThaiHoaDonFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
