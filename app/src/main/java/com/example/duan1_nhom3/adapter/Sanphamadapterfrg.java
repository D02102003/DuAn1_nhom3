package com.example.duan1_nhom3.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.Sanphamgiohang;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.dao.DAOSanPham;
import com.example.duan1_nhom3.dao.DAOSanPhamgh;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Sanphamadapterfrg extends RecyclerView.Adapter<Sanphamadapterfrg.ViewHolder> {

    private   List<SanPham> list;
    private   Callback callback;
    DAOSanPhamgh sp ;
    public Sanphamadapterfrg(List<SanPham> list, Callback callback) {
        this.list = list;
        this.callback = callback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ao,null);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SanPham sanPham = list.get(position);
        byte[] anh=list.get(position).getSanphamPhoto();
        Bitmap bitmap = BitmapFactory.decodeByteArray(anh, 0,anh.length);
        holder.anhhang.setImageBitmap(bitmap);
        holder.namesp.setText(sanPham.getTensp());
        holder.giasp.setText(sanPham.getGiasp());

        holder.anhgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = new DAOSanPhamgh(v.getContext());
                SanPham spgh = new SanPham();
                spgh.setMasp(sanPham.getMasp());
                spgh.setTensp(sanPham.getTensp());
                spgh.setGiasp(sanPham.getGiasp());
                spgh.setSoluong(sanPham.getSoluong());
                spgh.setSanphamPhoto(sanPham.getSanphamPhoto());
                spgh.setId_theloai(sanPham.getId_theloai());
                spgh.setTentheloai(sanPham.getTentheloai());
                sp.them_SanPham2(spgh);
                Toast.makeText(v.getContext(), "Thêm thành công vào giỏ hàng !", Toast.LENGTH_SHORT).show();

            }
        });
    }







    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView namesp,giasp,soluong;
        ImageView anhgiohang,anhhang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namesp = itemView.findViewById(R.id.tenSPfrg);
            giasp = itemView.findViewById(R.id.giaGocSPfrg);

            anhhang = itemView.findViewById(R.id.imgSanPhamfrg);
            anhgiohang = itemView.findViewById(R.id.imggioHangSPfrg);
        }
    }
    public  interface Callback{
        void xoa(SanPham nguoiDung);
        void sua(SanPham nguoiDung);
    }

    public void filterList(ArrayList<SanPham> filteredList) {
        list = filteredList;
        notifyDataSetChanged();
    }
    private String numbercurrencyformat(String number){
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        return decimalFormat.format(Integer.parseInt(number));
    }
}
