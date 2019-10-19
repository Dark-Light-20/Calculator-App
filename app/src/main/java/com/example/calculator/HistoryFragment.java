package com.example.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Map;

public class HistoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //getActivity().setTitle("History");
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.linear_history);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        Map<String, ?> expressions = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : expressions.entrySet()) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(25);
            textView.setText(entry.getValue().toString());
            linearLayout.addView(textView);
        }

        return view;
    }
}
