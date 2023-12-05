package com.example.phuongtrinhbac2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private static final int MY_REQUEST_CODE = 1;
    private TextView tvPhuongtrinh;
    private Button btnInput, btnResult, btnExit;
    private Intent receivedIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvPhuongtrinh = findViewById(R.id.tv_phuong_trinh);
        btnExit = findViewById(R.id.btn_exit);
        btnResult = findViewById(R.id.btn_result);
        btnInput = findViewById(R.id.btn_input);

        btnInput.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnResult.setOnClickListener(this);

        btnResult.setEnabled(false);

    }


    @Override
    public void onClick(View v) {
        if (v == btnExit){
            finish();
        } else if (v == btnInput){
            Intent input = new Intent(this, HeSo.class);
            startActivityForResult(input, MY_REQUEST_CODE);
        } else if (v == btnResult) {

            Number receivedNumber = (Number) receivedIntent.getSerializableExtra("key_number");

            float receivedDataA = receivedNumber.getA();
            float receivedDataB=  receivedNumber.getB();
            float receivedDataC=  receivedNumber.getC();

            float delta = (receivedDataB * receivedDataB) - (4 * receivedDataA * receivedDataC);

            // Tính các nghiệm
            float x1, x2;

            if (delta > 0) {
                x1 = (float) ((-receivedDataB + Math.sqrt(delta)) / (2 * receivedDataA));
                x2 = (float) ((-receivedDataB - Math.sqrt(delta)) / (2 * receivedDataA));
            } else if (delta == 0) {
                x1 = x2 = -receivedDataB / (2 * receivedDataA);
            } else {
                x1 = x2 = Float.NaN;
            }
            Intent resultIntent = new Intent(this, GiaiPhuongTrinh.class);
            resultIntent.putExtra("result_x1", x1);
            resultIntent.putExtra("result_x2", x2);
            startActivity(resultIntent);
            }
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String resultText = null;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE && resultCode == RESULT_OK){
            receivedIntent = data;
            if (data != null) {
                Number receivedNumber = (Number) data.getSerializableExtra("key_number");
                float receivedDataA = receivedNumber.getA();
                float receivedDataB=  receivedNumber.getB();
                float receivedDataC=  receivedNumber.getC();

                if (receivedDataB < 0 && receivedDataC < 0) {
                    resultText = receivedDataA + "x^2" + " - " + (-receivedDataB) + "x" + " - " + (-receivedDataC) + " = 0";
                }else if (receivedDataB < 0){
                    resultText = receivedDataA + "x^2" + " - " + (-receivedDataB) + "x" + " + " + receivedDataC + " = 0";
                } else if (receivedDataC < 0) {
                    resultText = receivedDataA + "x^2" + " + " + receivedDataB + "x" + " - " + (-receivedDataC)+ " = 0";
                } else {
                    resultText = receivedDataA + "x^2" + " + " + receivedDataB + "x" + " + " + receivedDataC+ " = 0";
                }
                tvPhuongtrinh.setText(resultText);
                btnResult.setEnabled(true);
            }
        }
    }
}