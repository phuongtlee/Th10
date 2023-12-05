package com.example.phuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText hs1, hs2, hs3;
    private TextView tvGiai;
    private Button btnTinh, btnClose;

    float a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hs1 = findViewById(R.id.edit_a);
        hs2 = findViewById(R.id.edit_b);
        hs3 = findViewById(R.id.edit_c);

        tvGiai = findViewById(R.id.tv_nghiem_pt);

        btnClose = findViewById(R.id.btn_close);
        btnTinh = findViewById(R.id.btn_tinh);

        btnTinh.setOnClickListener(this);
        btnClose.setOnClickListener(this);
    }

    public void tinhBac2(float a, float b, float c){
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    tvGiai.setText("Phương trình vô số nghiệm");
                }
                else {
                    tvGiai.setText("Phương trình vô nghiệm");
                }
            }
            else {
                tvGiai.setText("Phuong trinh co nghiem la: " + -c/b);
            }
        }
        else {
            double Delta = (b * b) - (4 * a * c);
            if (Delta < 0) {
                tvGiai.setText("Phương trình vô nghiệm");
            }
            else if (Delta == 0) {
                tvGiai.setText("Phương trình có nghiệm kép x1 = x2 = " + (-b / (2 * a)));
            }
            else {
               tvGiai.setText("Phương trình có 2 nghiệm x1 = " + (-b + Math.sqrt(Delta)) / (2 * a) + " và x2= " + (-b - Math.sqrt(Delta)) / (2 * a));
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnTinh){
            try {
                a  = Float.parseFloat(hs1.getText().toString());
                b  = Float.parseFloat(hs2.getText().toString());
                c  = Float.parseFloat(hs3.getText().toString());
                tinhBac2(a,b,c);
            } catch (NumberFormatException e) {
                tvGiai.setText("Mời nhập số");
            }
        } else if (v == btnClose) {
            finish();
        }
    }
}