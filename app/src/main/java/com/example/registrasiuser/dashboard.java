package com.example.registrasiuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // Terima data dari intent
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String nama = intent.getStringExtra("nama");
        String alamat = intent.getStringExtra("alamat");
        String tanggalLahir = intent.getStringExtra("tanggalLahir");
        String jenisKelamin = intent.getStringExtra("jenisKelamin");

        // Inisialisasi tombol
        Button button = findViewById(R.id.buttonOpenBottomSheet);

        // Tambahkan event listener ke tombol
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan bottom sheet ketika tombol diklik
                showBottomSheet(email, password, nama, alamat, tanggalLahir, jenisKelamin);
            }
        });
    }

    private void showBottomSheet(String email, String password, String nama, String alamat, String tanggalLahir, String jenisKelamin) {
        // Inflate layout untuk bottom sheet
        View bottomSheetView = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_content, null);

        // Inisialisasi komponen UI di dalam bottom sheet
        TextView emailTextView = bottomSheetView.findViewById(R.id.emailTextView);
        TextView passwordTextView = bottomSheetView.findViewById(R.id.passwordTextView);
        TextView namaTextView = bottomSheetView.findViewById(R.id.namaTextView);
        TextView alamatTextView = bottomSheetView.findViewById(R.id.alamatTextView);
        TextView tanggalLahirTextView = bottomSheetView.findViewById(R.id.tanggalLahirTextView);
        TextView jenisKelaminTextView = bottomSheetView.findViewById(R.id.jenisKelaminTextView);

        // Set nilai data ke komponen UI di dalam bottom sheet
        emailTextView.setText("Email: " + email);
        passwordTextView.setText("Password: " + password);
        namaTextView.setText("Nama: " + nama);
        alamatTextView.setText("Alamat: " + alamat);
        tanggalLahirTextView.setText("Tanggal Lahir: " + tanggalLahir);
        jenisKelaminTextView.setText("Jenis Kelamin: " + jenisKelamin);

        // Buat dan tampilkan bottom sheet
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}
