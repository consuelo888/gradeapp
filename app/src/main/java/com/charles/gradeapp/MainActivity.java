package com.charles.gradeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // Deklarasi field input
    private EditText editTextPresensi, editTextTugas, editTextUTS, editTextUAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi EditText
        editTextPresensi = findViewById(R.id.Presensi);
        editTextTugas = findViewById(R.id.Tugas);
        editTextUTS = findViewById(R.id.UTS);
        editTextUAS = findViewById(R.id.UAS);

        // Inisialisasi Button
        Button buttonHitung = findViewById(R.id.buttonHitung);

        // Set listener untuk button "Hitung Nilai Akhir"
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari EditText
                String presensi = editTextPresensi.getText().toString();
                String tugas = editTextTugas.getText().toString();
                String uts = editTextUTS.getText().toString();
                String uas = editTextUAS.getText().toString();

                // Validasi apakah semua field diisi
                if (presensi.isEmpty() || tugas.isEmpty() || uts.isEmpty() || uas.isEmpty()) {
                    // Jika ada field yang kosong
                    Toast.makeText(MainActivity.this, "Seluruh data wajib diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validasi apakah semua nilai adalah angka dan berada dalam rentang 10-100
                if (!isValidInput(presensi) || !isValidInput(tugas) || !isValidInput(uts) || !isValidInput(uas)) {
                    Toast.makeText(MainActivity.this, "Nilai tidak boleh lebih kecil dari 10 dan tidak boleh lebih besar dari 100", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Hitung nilai akhir
                double presensiValue = Double.parseDouble(presensi);
                double tugasValue = Double.parseDouble(tugas);
                double utsValue = Double.parseDouble(uts);
                double uasValue = Double.parseDouble(uas);

                // Kalkulasi nilai akhir berdasarkan rumus
                double nilaiAkhir = (0.1 * presensiValue) + (0.2 * tugasValue) + (0.3 * utsValue) + (0.4 * uasValue);

                // Kirim hasil ke Activity Result
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("nilaiAkhir", nilaiAkhir);
                startActivity(intent);
            }
        });
    }

    // Fungsi untuk validasi input agar hanya angka dan dalam rentang 10-100
    private boolean isValidInput(String input) {
        try {
            double value = Double.parseDouble(input);
            return value >= 10 && value <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}