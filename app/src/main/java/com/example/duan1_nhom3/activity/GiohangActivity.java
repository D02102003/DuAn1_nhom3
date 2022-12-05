package com.example.duan1_nhom3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_nhom3.Model.HoaDon;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.Sanphamgiohang;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.adapter.GioHangAdapter;
import com.example.duan1_nhom3.adapter.SanPhamAdapter;
import com.example.duan1_nhom3.dao.DAOSanPhamgh;
import com.example.duan1_nhom3.dao.DaoHoaDon;
import com.example.duan1_nhom3.fragment.HoaDonFragment;

import java.util.ArrayList;
import java.util.List;

public class GiohangActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int RESULT_OK = 1;
    public static final String LIST_CHOOSE = "LIST_CHOOSE";

    RecyclerView recyclerView;
    DAOSanPhamgh daoSanPhamgh;
    DaoHoaDon daoHoaDon;
    List<SanPham> list;
    GioHangAdapter adapter;
    SanPhamAdapter.Callback callback;
    ImageView imgNext, imgPre;
    TextView tvSLGH;
    Button btnAdd;

    public static boolean changeHoaDon = false;//check ấn xác nhận từ giỏ hàng
    public static List<SanPham> listChoose = new ArrayList<>();//nhận sản phẩm được chọn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        anhxa();
        daoSanPhamgh = new DAOSanPhamgh(getApplicationContext());
        list = daoSanPhamgh.selectAll();

        ArrayList<SanPham> listChoose = getIntent().getParcelableArrayListExtra(LIST_CHOOSE);
        for (SanPham spChose : listChoose) {
            for (SanPham sp : list) {
                if (spChose.getMasp() == sp.getMasp()) {
                    sp.setSelect(true);
                    break;
                }
            }
        }

        adapter = new GioHangAdapter(list, callback);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void anhxa() {
        recyclerView = findViewById(R.id.lv_giohang);
        imgNext = findViewById(R.id.imgNext);
        imgPre = findViewById(R.id.imgPre);
        tvSLGH = findViewById(R.id.tv_soluongGio);
        btnAdd = findViewById(R.id.btAddHoaDon);
        btnAdd.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btAddHoaDon:
                ArrayList<SanPham> listChoose = new ArrayList<>();
                for (SanPham sp : list) {
                    if (sp.isSelect()) {
                        listChoose.add(sp);
//                        List<HoaDon> listhd = new ArrayList<>();
//                        listhd.add(sp);
//                        daoHoaDon = new DaoHoaDon(this);

                    } else {
                        listChoose.remove(sp);
                    }
                }
                Intent data = new Intent();
                data.putParcelableArrayListExtra(LIST_CHOOSE, listChoose);
                setResult(RESULT_OK, data);
                changeHoaDon = true;
                finish();
                break;
        }
    }
}