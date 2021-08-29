package com.example.studentgradescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText marks1;
    EditText marks2;
    EditText marks3;
    EditText marks4;
    EditText marks5;
    Button button1;
    TextView tv1;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marks1 = findViewById(R.id.marks1);
        marks2 = findViewById(R.id.marks2);
        marks3 = findViewById(R.id.marks3);
        marks4 = findViewById(R.id.marks4);
        marks5 = findViewById(R.id.marks5);

        tv1 = findViewById(R.id.total);
        tv2 = findViewById(R.id.percent);
        tv3 = findViewById(R.id.Grade);
        button1 = findViewById(R.id.cal_button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (marks1.getText().toString().length() == 0 || marks2.getText().toString().length() == 0 || marks3.getText().toString().length() == 0 || marks4.getText().toString().length() == 0 || marks5.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter values", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(marks1.getText().toString()) > 100 || Integer.parseInt(marks2.getText().toString()) > 100 || Integer.parseInt(marks3.getText().toString()) > 100 || Integer.parseInt(marks4.getText().toString()) > 100 || Integer.parseInt(marks5.getText().toString()) > 100) {
                    Toast.makeText(getApplicationContext(), "Please enter values between 0 - 100", Toast.LENGTH_SHORT).show();
                } else {
                    marksCal();
                    Intent i = new Intent(MainActivity.this, Display_information.class);
                    i.putExtra("Total marks", tv1.getText().toString());
                    i.putExtra("Percentage", tv2.getText().toString());
                    i.putExtra("Grade", tv3.getText().toString());
                    startActivity(i);
                }
            }
        });
    }

    public void marksCal() {
        int m1, m2, m3, m4, m5, total;
        double percentage;
        m1 = Integer.parseInt(marks1.getText().toString());
        m2 = Integer.parseInt(marks2.getText().toString());
        m3 = Integer.parseInt(marks3.getText().toString());
        m4 = Integer.parseInt(marks4.getText().toString());
        m5 = Integer.parseInt(marks5.getText().toString());

        total = m1 + m2 + m3 + m4 + m5;

        tv1.setText(String.valueOf(total));

        percentage = (total * 100) / 500;
        tv2.setText(String.valueOf((percentage)) + "%");

        if (percentage > 90) {
            tv3.setText("O");
        } else if (percentage > 80) {
            tv3.setText("A+");
        } else if (percentage > 75) {
            tv3.setText("A");
        } else if (percentage > 70) {
            tv3.setText("B+");
        } else if (percentage > 65) {
            tv3.setText("C");
        } else {
            tv3.setText("F");
        }
    }
}