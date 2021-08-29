package com.example.studentgradescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Display_information extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_information);
        t1 = findViewById(R.id.display_toal_marks);
        t2 = findViewById(R.id.display_Percentage);
        t3 = findViewById(R.id.display_Grade);
        t4 = findViewById(R.id.verdict);
        b1 = findViewById(R.id.goback);

        t1.setText(getIntent().getExtras().getString("Total marks"));
        t2.setText(getIntent().getExtras().getString("Percentage"));
        t3.setText(getIntent().getExtras().getString("Grade"));

        String x = getIntent().getExtras().getString("Grade");
        if (x.equals("F")) {
            t4.setText("FAIL");
        } else {
            t4.setText("Pass. Congratulations!");
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Display_information.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}