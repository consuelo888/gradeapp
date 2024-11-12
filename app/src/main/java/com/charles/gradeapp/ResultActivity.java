package com.charles.gradeapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Inisialisasi TextView
        textViewHasil = findViewById(R.id.textViewHasil);

        // Ambil nilai akhir dari Intent
        double nilaiAkhir = getIntent().getDoubleExtra("nilaiAkhir", 0);

        // Tampilkan hasil
        textViewHasil.setText("Nilai Akhir Anda: " + nilaiAkhir);
    }
}