package com.example.duan1_nhom3.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.activity.GiohangActivity;

import java.text.DecimalFormat;
import java.util.List;
import java.util.zip.Inflater;

public class GioHangAdapter  extends RecyclerView.Adapter<GioHangAdapter.ViewHolder>{

    private List<SanPham> list;
    private SanPhamAdapter.Callback callback;

    public GioHangAdapter(List<SanPham> list, SanPhamAdapter.Callback callback) {
        this.list = list;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_giohang,null);
        return new GioHangAdapter.ViewHolder(view) ;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SanPham sanPham = list.get(position);
        byte[] anh=list.get(position).getSanphamPhoto();
        Bitmap bitmap = BitmapFactory.decodeByteArray(anh, 0,anh.length);
        holder.anhhang.setImageBitmap(bitmap);
        holder.namesp.setText(sanPham.getTensp());
        holder.giasp.setText(numbercurrencyformat(sanPham.getGiasp()) +" ₫");
        holder.soluong.setText(sanPham.getSoluong());
//        for (int h= 0; h <=list.size() ; h++ ){
//            if(holder.chk.isChecked() == true){
//                l
//            }
//        }

        //check sản phẩm nào được chọn
        sanPham.setSelect(true);
        holder.chk.setChecked(true);
        holder.chk.setOnClickListener(v -> {
            if (holder.chk.isChecked()){
                sanPham.setSelect(true);
            }else {
                sanPham.setSelect(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView namesp,giasp,soluong;
        CheckBox chk;
        ImageView anhhang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namesp = itemView.findViewById(R.id.tv_nameGio);
            giasp = itemView.findViewById(R.id.tv_giaGio);
            soluong=itemView.findViewById(R.id.tv_soluongGio);
            anhhang = itemView.findViewById(R.id.sp1);
            chk = itemView.findViewById(R.id.chk_giohang);


        }
    }

    private String numbercurrencyformat(String number){
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        return decimalFormat.format(Integer.parseInt(number));
    }
}
