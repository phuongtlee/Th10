package com.example.phuongtrinhbac2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GiaiPhuongTrinh extends AppCompatActivity implements View.OnClickListener {

    private TextView tvGiaiPhuongTrinh;
    private Button btnBack;

    String resultText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_phuong_trinh);

        tvGiaiPhuongTrinh = findViewById(R.id.tv_result_all);
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(this);

        float x1 = getIntent().getFloatExtra("result_x1", 0.0f);
        float x2 = getIntent().getFloatExtra("result_x2", 0.0f);

        // Hiển thị kết quả trên TextView
        if (Float.isNaN(x1) && Float.isNaN(x2)){
            resultText = "Phương trình vô nghiệm";
        } else {
            resultText = "Nghiệm 1 (x1): " + x1 + "\n";
            resultText += "Nghiệm 2 (x2): " + x2;
        }
        tvGiaiPhuongTrinh.setText(resultText);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}