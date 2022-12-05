package com.example.duan1_nhom3.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.duan1_nhom3.Model.Khachhang;
import com.example.duan1_nhom3.R;
import com.example.duan1_nhom3.dao.DaoKhachHang;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {
    final int REQUEST_CODE_GALLERY = 999;
    private MaterialToolbar toolBar;
    private CircleImageView idImageUser;
    private TextView createTaiKhoan;
    private TextView tvghichu;
    private TextInputLayout etHoten;
    private TextInputLayout etUsernameRegister;
    private TextInputLayout etPasswordRegister;
    private TextInputLayout etPassworRegisterdAgin;
    private TextInputLayout etNamSinh;
    private Button btDangKi;
    private LinearLayout ll1;
    private TextView textDangNhap;
    private ImageView imagetest;
    private DaoKhachHang mDaoKhachHang;
    private Button chonanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolBar = (MaterialToolbar) findViewById(R.id.tool_bar);
        initToolBar();
        chonanh = (Button) findViewById(R.id.chonanh);
        idImageUser = (CircleImageView) findViewById(R.id.idImageUser);
        createTaiKhoan = (TextView) findViewById(R.id.createTaiKhoan);
        tvghichu = (TextView) findViewById(R.id.tvghichu);
        etHoten =  findViewById(R.id.etHoten);
        etNamSinh =  findViewById(R.id.etNamSinh);
        etUsernameRegister = findViewById(R.id.etUsernameRegister);
        etPasswordRegister =  findViewById(R.id.etmatkhaumoi);
        etPassworRegisterdAgin =  findViewById(R.id.nhaplaimatkhaumoi);
        btDangKi = (Button) findViewById(R.id.btDangKi);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        textDangNhap = (TextView) findViewById(R.id.textDangNhap);
        mDaoKhachHang = new DaoKhachHang(this);

        chonanh.setOnClickListener(view -> {
            ActivityCompat.requestPermissions(
                    SignUpActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE_GALLERY
            );
        });

        btDangKi.setOnClickListener(view -> {
            String hoten = etHoten.getEditText().getText().toString();
            String namSinh = etNamSinh.getEditText().getText().toString();
            String user = etUsernameRegister.getEditText().getText().toString();
            String password = etPasswordRegister.getEditText().getText().toString();
            String dinhDangSaiVeHo = "((?=.*[a-zA-Z])(?=.*[0-9]).{1,20})";
            if (etUsernameRegister.getEditText().getText().toString().isEmpty() || etUsernameRegister.getEditText().getText().toString() == null) {
                tvghichu.setText("You Have Not Entered Your Username");
                tvghichu.setTextColor(Color.RED);
                return;
            } else if (etPasswordRegister.getEditText().getText().toString().isEmpty() || etPasswordRegister.getEditText().getText().toString() == null) {
                tvghichu.setText("You Have Not Entered Password");
                tvghichu.setTextColor(Color.RED);
                return;
            } else if (etPassworRegisterdAgin.getEditText().getText().toString().isEmpty() || etPassworRegisterdAgin.getEditText().getText().toString() == null) {
                tvghichu.setText("You Have Not Re-entered Password");
                tvghichu.setTextColor(Color.RED);
                return;
            } else if (etHoten.getEditText().getText().toString().isEmpty() || etHoten.getEditText().getText().toString() == null) {
                tvghichu.setText("You Have Not Entered Your Name");
                tvghichu.setTextColor(Color.RED);
                return;
            }

            else if (etNamSinh.getEditText().getText().toString().isEmpty() || etHoten.getEditText().getText().toString() == null) {
                tvghichu.setText("You Have Not Entered Your Name");
                tvghichu.setTextColor(Color.RED);
                return;
            }

            else if (etPasswordRegister.getEditText().getText().toString().equals(etPassworRegisterdAgin.getEditText().getText().toString()) == false) {
                tvghichu.setText("Re-enter Password Do Not Duplicate");
                tvghichu.setTextColor(Color.RED);
                etPasswordRegister.getEditText().setText("");
                etPassworRegisterdAgin.getEditText().setText("");
                return;
            } else if (imageViewToByte(idImageUser).length > 600000) {
                tvghichu.setText("Please choose an invalid photo again");
                Toast.makeText(this, "Your picture is too heavy, I give up", Toast.LENGTH_SHORT).show();
                tvghichu.setTextColor(Color.RED);
                return;
            } else if (etHoten.getEditText().getText().toString().matches("^[A-Z].*") == false) {
                etHoten.setError("First Name Must Capitalize");
                return;
            } else if (etHoten.getEditText().getText().toString().matches(dinhDangSaiVeHo) == true) {
                etHoten.setError("Name No number");
                return;
            } else if (etHoten.getEditText().getText().toString().length() < 5) {
                etHoten.setError("Username must be at least 5 . long");
                return;
            } else if (etHoten.getEditText().getText().toString().length() > 15) {
                etHoten.setError("Username must be up to 15 . in length");
                return;
            } else {
                Khachhang khachhang = new Khachhang(user, 0, password, hoten, namSinh,imageViewToByte(idImageUser));
                if (mDaoKhachHang.themKind(khachhang) == true) {
                    Toast.makeText(this, "More success!", Toast.LENGTH_SHORT).show();
                    this.onBackPressed();

                } else {
                    Toast.makeText(this, "More failure!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        Bitmap resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.8), (int) (bitmap.getHeight() * 0.8), true);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    private void initToolBar() {
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
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
                idImageUser.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}