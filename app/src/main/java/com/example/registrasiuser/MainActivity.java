package com.example.registrasiuser;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText datePickerEditText;
    private Calendar calendar;

    private String email, password, nama, alamat, tanggalLahir, jenisKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePickerEditText = findViewById(R.id.datePickerEditText);
        calendar = Calendar.getInstance();

        datePickerEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    public void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        datePickerEditText.setText(selectedDate);
                        tanggalLahir = selectedDate;
                    }
                }, year, month, dayOfMonth);

        datePickerDialog.show();
    }

    public void loginButtonClicked(View view) {
        // Mengambil data yang dimasukkan oleh pengguna
        EditText emailEditText = findViewById(R.id.Email);
        EditText passwordEditText = findViewById(R.id.Password);
        EditText namaEditText = findViewById(R.id.nama);
        EditText alamatEditText = findViewById(R.id.alamat);
        RadioGroup chooseRadioGroup = findViewById(R.id.Choose);

        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        nama = namaEditText.getText().toString();
        alamat = alamatEditText.getText().toString();

        // Mengambil jenis kelamin
        int selectedRadioButtonId = chooseRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId == R.id.radio_male) {
            jenisKelamin = "Pria";
        } else if (selectedRadioButtonId == R.id.radio_female) {
            jenisKelamin = "Wanita";
        }

        // Intent untuk memindahkan pengguna ke halaman dashboard
        Intent intent = new Intent(this, dashboard.class);
        // Menyertakan data yang dimasukkan oleh pengguna ke dalam intent
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("nama", nama);
        intent.putExtra("alamat", alamat);
        intent.putExtra("tanggalLahir", tanggalLahir);
        intent.putExtra("jenisKelamin", jenisKelamin);

        // Menjalankan intent
        startActivity(intent);
    }
}
