package com.example.duan1_nhom3.adapter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_nhom3.MainActivity;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.Sanphamgiohang;
import com.example.duan1_nhom3.Model.TheLoai;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.dao.DAOSanPham;
import com.example.duan1_nhom3.dao.DAOSanPhamgh;
import com.example.duan1_nhom3.dao.DAOTheLoai;
import com.example.duan1_nhom3.fragment.KhoHangFragment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder> {

  private   List<SanPham> list;
  private   Callback callback;

   DAOSanPhamgh sp ;
    public SanPhamAdapter(List<SanPham> list, Callback callback) {
        this.list = list;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_phukien,null);
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
             holder.soluong.setText(sanPham.getSoluong());
            holder.lineItemSach.setOnLongClickListener(v ->{
            PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
            MenuInflater inflater = popupMenu.getMenuInflater();
            inflater.inflate(R.menu.menu_item_sanpham, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.item_xoa:
                            callback.xoaa(sanPham);
                            break;
                        case R.id.item_sua:
                            callback.dialogupdatesanpham(sanPham);
                            break;
                    }
                    return false;
                }
            });
            popupMenu.show();
            return false;
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
  TextView namesp,giasp,soluong;
  ImageView anhgupdate,anhhang;
        LinearLayout lineItemSach;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
       namesp = itemView.findViewById(R.id.tenSP);
       giasp = itemView.findViewById(R.id.giaGocSP);
       soluong=itemView.findViewById(R.id.soluongsv);
       anhhang = itemView.findViewById(R.id.imgSanPham);
       anhgupdate = itemView.findViewById(R.id.imggioHangSP);
       lineItemSach = itemView.findViewById(R.id.sanphamux);

        }
    }
    public  interface Callback{
        void xoaa(SanPham sanPham);
        void dialogupdatesanpham(SanPham sanPham);
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
