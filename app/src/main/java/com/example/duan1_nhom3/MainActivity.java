package com.example.duan1_nhom3;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1_nhom3.Model.Khachhang;
import com.example.duan1_nhom3.Model.SanPham;
import com.example.duan1_nhom3.Model.TheLoai;
import com.example.duan1_nhom3.activity.GiohangActivity;
import com.example.duan1_nhom3.activity.LoginPeopleActivity;
import com.example.duan1_nhom3.dao.DAOSanPham;
import com.example.duan1_nhom3.dao.DAOTheLoai;
import com.example.duan1_nhom3.databinding.ActivityMainBinding;
import com.example.duan1_nhom3.fragment.DoanhThuFragment;
import com.example.duan1_nhom3.fragment.DoiMatKhauAdminFragment;
import com.example.duan1_nhom3.fragment.HoaDonFragment;
import com.example.duan1_nhom3.fragment.HomeFragment;
import com.example.duan1_nhom3.fragment.KhoHangFragment;
import com.example.duan1_nhom3.fragment.SanPhamFragment;
import com.example.duan1_nhom3.fragment.ThongKeFragment;
import com.example.duan1_nhom3.fragment.ThongTinAdminFragment;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private MaterialToolbar toolBar;
    private LinearLayout idHome;
    private LinearLayout idSanPham;
    private LinearLayout idThongKe;
    private LinearLayout idDoanhThu;
    private LinearLayout idDoiMatKhau;
    private LinearLayout idThoat;
    private LinearLayout idThongTin;
    private LinearLayout idKhoHang;
    private LinearLayout idHoaDon;
    final int REQUEST_CODE_GALLERY = 999;
    private Khachhang khachhang;
    Button chonanh2;
    CircleImageView idImagesanpham;
    public ArrayList<SanPham> listChoose = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolBar = (MaterialToolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("");
        DuoDrawerToggle drawerToggle = new DuoDrawerToggle(this, binding.drawer, toolBar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        binding.drawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        View contentview = binding.drawer.getContentView();
        View menuView = binding.drawer.getMenuView();
        idHome = (LinearLayout) menuView.findViewById(R.id.idHome);
        idSanPham = (LinearLayout) menuView.findViewById(R.id.idSanPham);
        idThongKe = (LinearLayout) menuView.findViewById(R.id.idThongKe);
        idDoanhThu = (LinearLayout) menuView.findViewById(R.id.idDoanhThu);
        idThongTin = menuView.findViewById(R.id.idThongTinAdmin);
        idDoiMatKhau = (LinearLayout) menuView.findViewById(R.id.idDoiMatKhau);
        idKhoHang = menuView.findViewById(R.id.idKhoHang);
        idThoat = (LinearLayout) menuView.findViewById(R.id.idLogout);
        idHoaDon = (LinearLayout) menuView.findViewById(R.id.idHoaDon) ;

        idHome.setOnClickListener(this);
        idSanPham.setOnClickListener(this);
        idThoat.setOnClickListener(this);
        idDoanhThu.setOnClickListener(this);
        idThongKe.setOnClickListener(this);
        idThongTin.setOnClickListener(this);
        idDoiMatKhau.setOnClickListener(this);
        idKhoHang.setOnClickListener(this);
        idHoaDon.setOnClickListener(this);
        replaceFragment(new HomeFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idHome:
                getSupportActionBar().setTitle("Home");
                HomeFragment homeFragment = new HomeFragment();
                replaceFragment(homeFragment);
                break;
            case R.id.idDoanhThu:
                getSupportActionBar().setTitle("Doanh thu");
                DoanhThuFragment doanhThuFragment = new DoanhThuFragment();
                replaceFragment(doanhThuFragment);
                break;
            case R.id.idDoiMatKhau:
                getSupportActionBar().setTitle("Đổi mật khẩu");
                DoiMatKhauAdminFragment doiMatKhauAdminFragment = new DoiMatKhauAdminFragment();
                replaceFragment(doiMatKhauAdminFragment);
                break;
            case R.id.idSanPham:
                getSupportActionBar().setTitle("Sản phẩm");
                SanPhamFragment sanPhamFragment = new SanPhamFragment();
                replaceFragment(sanPhamFragment);
                break;
            case R.id.idThongKe:
                getSupportActionBar().setTitle("Thống kê");
                ThongKeFragment thongKeFragment = new ThongKeFragment();
                replaceFragment(thongKeFragment);
                break;
            case R.id.idHoaDon:
                getSupportActionBar().setTitle("Hóa đơn");
                 HoaDonFragment homeFragment1 = new HoaDonFragment();
                 replaceFragment(homeFragment1);
break;
            case R.id.idThongTinAdmin:
                getSupportActionBar().setTitle("Thông tin tài khoản");
                ThongTinAdminFragment thongTinAdminFragment = new ThongTinAdminFragment();
                replaceFragment(thongTinAdminFragment);
                break;
            case R.id.idKhoHang:
                getSupportActionBar().setTitle("Kho hàng");
                KhoHangFragment khoHangFragment = new KhoHangFragment();
                replaceFragment(khoHangFragment);
                break;
            case R.id.idLogout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thoát");
                builder.setMessage("Bạn có muồn thoát ứng dụng không");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
        }
        binding.drawer.closeDrawer();
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);

    }

    public void showInfo() {
        int id = LoginPeopleActivity.id;
        Log.e("Login", String.valueOf(id));
        if (id != 1) {
            idDoanhThu.setVisibility(View.GONE);
            idThongKe.setVisibility(View.GONE);
            idKhoHang.setVisibility(View.GONE);
            idHoaDon.setVisibility(View.VISIBLE);
        } else {
            idHoaDon.setVisibility(View.GONE);
            idDoanhThu.setVisibility(View.VISIBLE);
            idThongKe.setVisibility(View.VISIBLE);
            idKhoHang.setVisibility(View.VISIBLE);
        }
        khachhang = (Khachhang) getIntent().getSerializableExtra("khachhang");
        if (khachhang.getTaiKhoanKH().equals("trantrunghieu")) {
            binding.idUser.setText(khachhang.getHoTenKH() + " (Chủ Tịch)");
            byte[] imageuuuu = khachhang.getKhachHangPhoto();
            if (imageuuuu != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageuuuu, 0, imageuuuu.length);
                binding.idImageUser.setImageBitmap(bitmap);
            }
        } else {
            binding.idUser.setText(khachhang.getHoTenKH());
            byte[] imageuuuu = khachhang.getKhachHangPhoto();
            if (imageuuuu != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageuuuu, 0, imageuuuu.length);
                binding.idImageUser.setImageBitmap(bitmap);
            }

        }
    }

    @Override
    protected void onResume () {
        super.onResume();
        showInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int id = LoginPeopleActivity.id;
        if(id != 1){
            getMenuInflater().inflate(R.menu.giohang, menu);
        }
        else getMenuInflater().inflate(R.menu.main_add, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.item_add:
                    dialogthem();
                    break;
                case R.id.item_giohang:
                    Intent intent =  new Intent(this, GiohangActivity.class);
                    intent.putParcelableArrayListExtra(GiohangActivity.LIST_CHOOSE, listChoose);
                    registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                        if (result.getResultCode() == GiohangActivity.RESULT_OK) {
                            if (result.getData() != null) {
                                listChoose = result.getData().getParcelableArrayListExtra(GiohangActivity.LIST_CHOOSE);
                            }
                        }
                    }).launch(intent);
            }

            return super.onOptionsItemSelected(item);
    }

    public void dialogthem() {
        final Dialog dialog = new Dialog(MainActivity.this, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.diolog_them_san_pham);

        EditText edtten = dialog.findViewById(R.id.tvNameSanPham);
        EditText edtgia = dialog.findViewById(R.id.tvGiaSanPham);
        EditText edtsoluong = dialog.findViewById(R.id.tv_soluong);
       Spinner spn_tenTheloai = dialog.findViewById(R.id.spSanPham);

         idImagesanpham = (CircleImageView) dialog.findViewById(R.id.idSP);
        idImagesanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pick=new Intent(Intent.ACTION_GET_CONTENT);
                pick.setType("image/*");
                Intent pho=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Intent chosser=Intent.createChooser(pick,"lua chon");
                chosser.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{pho});
                startActivityForResult(chosser,REQUEST_CODE_GALLERY);
            }
        });
   DAOTheLoai daoTheLoai = new DAOTheLoai(getBaseContext());
       ArrayAdapter<TheLoai> sachArrayAdapter = new ArrayAdapter<>(getBaseContext(), R.layout.spinner_text, daoTheLoai.getALL_theloai());
     spn_tenTheloai.setAdapter(sachArrayAdapter);
        dialog.findViewById(R.id.btnThemSanPham).setOnClickListener(v -> {
            DAOSanPham daoSanPham = new DAOSanPham(getApplicationContext());
            SanPham sach = new SanPham();

            sach.setTensp(edtten.getText().toString());
            sach.setGiasp(edtgia.getText().toString());
            sach.setSoluong(edtsoluong.getText().toString());
            byte[]anh = imageViewToByte(idImagesanpham);
            sach.setSanphamPhoto(anh);
            sach.setTentheloai(spn_tenTheloai.getSelectedItem().toString());

            Log.e("Long","Thêm sản phẩm thành công");
            daoSanPham.them_SanPham1(sach);


            Toast.makeText(this, "Đã thêm sản phẩm " + edtten.getText().toString(), Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        dialog.findViewById(R.id.btnXoaText).setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        Bitmap resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.8), (int) (bitmap.getHeight() * 0.8), true);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(this, "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                idImagesanpham.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    //check ấn nút xác nhận để sang hóa đơn fragment
    @Override
    protected void onStart() {
        super.onStart();
        if (GiohangActivity.changeHoaDon){
            GiohangActivity.changeHoaDon=false;
            getSupportActionBar().setTitle("Hóa đơn");
            HoaDonFragment homeFragment1 = new HoaDonFragment();
            replaceFragment(homeFragment1);
        }
    }
}

