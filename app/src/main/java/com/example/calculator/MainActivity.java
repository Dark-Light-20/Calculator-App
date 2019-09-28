package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button_sum = findViewById(R.id.button_sum);
        Button button_less = findViewById(R.id.button_less);
        Button button_mul = findViewById(R.id.button_mul);
        Button button_div = findViewById(R.id.button_div);
        Button button_dot = findViewById(R.id.button_dot);
        Button button_eq = findViewById(R.id.button_eq);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_sum.setOnClickListener(this);
        button_less.setOnClickListener(this);
        button_mul.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_eq.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        TextView text = findViewById(R.id.text_res);

        String res = text.getText().toString();

        Button button = findViewById(v.getId());

        res += button.getText().toString();

        text.setText(res);
    }
}
