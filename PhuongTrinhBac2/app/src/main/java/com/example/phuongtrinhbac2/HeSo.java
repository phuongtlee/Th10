package com.example.phuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HeSo extends AppCompatActivity implements View.OnClickListener {

    private EditText edA, edB, edC;
    private Button btnSubmit;

    float a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_he_so);

        edA = findViewById(R.id.ed_a);
        edB = findViewById(R.id.ed_b);
        edC = findViewById(R.id.ed_c);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String numberStringA = edA.getText().toString();
        String numberStringB = edB.getText().toString();
        String numberStringC = edC.getText().toString();
        a = Float.parseFloat(numberStringA);
        b = Float.parseFloat(numberStringB);
        c = Float.parseFloat(numberStringC);

        Number number = new Number(a, b, c);

        Intent intent = new Intent();
        intent.putExtra("key_number", number);

        setResult(RESULT_OK, intent);

        finish();
    }
}