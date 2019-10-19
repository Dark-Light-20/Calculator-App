package com.example.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.Map;

public class CalculatorFragment extends Fragment implements View.OnClickListener {
    private View view;
    private double a = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_calculator,
                container, false);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

            Button button_sen = view.findViewById(R.id.button_sen);
            Button button_cos = view.findViewById(R.id.button_cos);
            Button button_tan = view.findViewById(R.id.button_tan);
            Button button_inv = view.findViewById(R.id.button_inv);
            Button button_par_left = view.findViewById(R.id.button_par_left);
            Button button_par_right = view.findViewById(R.id.button_par_right);
            Button button_A = view.findViewById(R.id.button_A);
            Button button_give_A = view.findViewById(R.id.button_give_A);
            Button button_exp = view.findViewById(R.id.button_exp);

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


        Button button0 = view.findViewById(R.id.button0);
        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        Button button4 = view.findViewById(R.id.button4);
        Button button5 = view.findViewById(R.id.button5);
        Button button6 = view.findViewById(R.id.button6);
        Button button7 = view.findViewById(R.id.button7);
        Button button8 = view.findViewById(R.id.button8);
        Button button9 = view.findViewById(R.id.button9);
        Button button_sum = view.findViewById(R.id.button_sum);
        Button button_less = view.findViewById(R.id.button_less);
        Button button_mul = view.findViewById(R.id.button_mul);
        Button button_div = view.findViewById(R.id.button_div);
        Button button_dot = view.findViewById(R.id.button_dot);
        Button button_eq = view.findViewById(R.id.button_eq);
        Button button_clear = view.findViewById(R.id.button_clear);
        Button button_C = view.findViewById(R.id.button_C);

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
        button_C.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        TextView text = view.findViewById(R.id.text_res);
        String res = text.getText().toString();

        switch (v.getId()){
            case R.id.button_eq:
                saveExpression(text);

                Expression expression = new Expression(res);
                text.setText(String.valueOf(expression.calculate()));
                return;

            case R.id.button_clear:
                text.setText("");
                break;

            case R.id.button_C:
                if(!text.getText().equals("")){
                    String text2 = text.getText().toString().substring(0, text.getText().toString().length()-1);
                    text.setText(text2);
                }
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
                Button button = view.findViewById(v.getId());
                res += button.getText().toString();
                text.setText(res);
                break;
        }
    }

    private void saveExpression(TextView text) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        Map<String, ?> expressions = sharedPreferences.getAll();
        int last = expressions.size();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("exp"+last, text.getText().toString());
        editor.commit();
    }
}
