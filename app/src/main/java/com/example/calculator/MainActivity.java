package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import  org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    double a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportActionBar().hide();

            Button button_sen = findViewById(R.id.button_sen);
            Button button_cos = findViewById(R.id.button_cos);
            Button button_tan = findViewById(R.id.button_tan);
            Button button_inv = findViewById(R.id.button_inv);
            Button button_par_left = findViewById(R.id.button_par_left);
            Button button_par_right = findViewById(R.id.button_par_right);
            Button button_A = findViewById(R.id.button_A);
            Button button_give_A = findViewById(R.id.button_give_A);
            Button button_exp = findViewById(R.id.button_exp);

            button_sen.setOnClickListener(this);
            button_cos.setOnClickListener(this);
            button_tan.setOnClickListener(this);
            button_inv.setOnClickListener(this);
            button_par_left.setOnClickListener(this);
            button_par_right.setOnClickListener(this);
            button_A.setOnClickListener(this);
            button_give_A.setOnClickListener(this);
            button_exp.setOnClickListener(this);
        }

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
        Button button_clear = findViewById(R.id.button_clear);
        Button button_about = findViewById(R.id.button_about);

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
        button_clear.setOnClickListener(this);
        button_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView text = findViewById(R.id.text_res);
        String res = text.getText().toString();

        switch (v.getId()){
            case R.id.button_eq:
                Expression expression = new Expression(res);
                text.setText(String.valueOf(expression.calculate()));
                return;

            case R.id.button_clear:
                text.setText("");
                break;

            case R.id.button_about:
                Intent intent=new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.button_sen:
                text.setText(res+="sin(");
                break;

            case R.id.button_cos:
                text.setText(res+="cos(");
                break;

            case R.id.button_tan:
                text.setText(res+="tan(");
                break;

            case R.id.button_inv:
                text.setText(res+="(1/");
                break;

            case R.id.button_par_left:
                text.setText(res+="(");
                break;

            case R.id.button_par_right:
                text.setText(res+=")");
                break;

            case R.id.button_exp:
                text.setText(res+="^(");
                break;

            case R.id.button_give_A:
                if(!res.equals("")) a = Double.valueOf(res);
                else a = 0;
                break;

            case R.id.button_A:
                text.setText(res+=String.valueOf(a));
                break;

            default:
                Button button = findViewById(v.getId());
                res += button.getText().toString();
                text.setText(res);
                break;
        }
    }
}
