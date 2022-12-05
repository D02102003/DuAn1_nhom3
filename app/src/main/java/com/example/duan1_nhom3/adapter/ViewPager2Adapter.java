package com.example.duan1_nhom3.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1_nhom3.fragmentAdmin.AoFragment;
import com.example.duan1_nhom3.fragmentAdmin.PhuKienFragment;
import com.example.duan1_nhom3.fragmentAdmin.QuanFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AoFragment();
            case 1:
                return new QuanFragment();
            case 2:
                return new PhuKienFragment();
            default:
                return new AoFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
