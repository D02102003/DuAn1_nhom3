package com.example.duan1_nhom3.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_nhom3.Model.HoaDon;
import com.example.duan1_nhom3.Model.Khachhang;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.Sanphamgiohang;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.activity.GiohangActivity;

import java.util.Calendar;
import java.util.List;

public class AdapterHoaDon extends RecyclerView.Adapter<AdapterHoaDon.ViewHolderHoaDon>{
    private Khachhang khachhang = new Khachhang();
    private List<HoaDon> list;
    public AdapterHoaDon(List<SanPham> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderHoaDon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_hoa_don,null);
        return new AdapterHoaDon.ViewHolderHoaDon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHoaDon holder, int position) {
        HoaDon gh = list.get(position);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        holder.tv_tenSP.setText(gh.getTenSanPhamHD());
        holder.tv_tenKH.setText(khachhang.getHoTenKH());
        holder.tv_giaSP.setText(gh.getGiaSanPhamHD() +"");
        holder.tv_ngayDatHang.setText(day +"" + month+ "" + year + "");
//        holder.tv_ngayHoanThanh.setText(day +"" + month+ "" + year + "");
        byte[] anh = list.get(position).getSanphamPhoto();
        Bitmap bitmap = BitmapFactory.decodeByteArray(anh, 0,anh.length);
        holder.imgSanPham.setImageBitmap(bitmap);
        Log.d("hieuadd", "Them thanh cong ");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolderHoaDon extends RecyclerView.ViewHolder{
        private ImageView imgSanPham;
        private TextView tv_tenSP,tv_giaSP,tv_tenKH,tv_ngayDatHang,tv_ngayHoanThanh;
        private Button btn_huyDon,btn_SuaDOn;
        public ViewHolderHoaDon(@NonNull View itemView) {
            super(itemView);
            imgSanPham = itemView.findViewById(R.id.imgSPHD);
            tv_tenSP = itemView.findViewById(R.id.tv_tenSPHD);
            tv_tenKH = itemView.findViewById(R.id.tv_tenKHHD);
            tv_giaSP = itemView.findViewById(R.id.tv_giaSPHD);
            tv_ngayDatHang = itemView.findViewById(R.id.tv_ngayDatHangSPHD);
            tv_ngayHoanThanh = itemView.findViewById(R.id.tv_ngayDuKienHoanThanhSPHD);
            btn_huyDon = itemView.findViewById(R.id.btnhuyDon);
            btn_SuaDOn = itemView.findViewById(R.id.btn_SuaDon);
            tv_ngayHoanThanh = itemView.findViewById(R.id.tv_ngayDuKienHoanThanhSPHD);

        }
    }
}
