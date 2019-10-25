package com.example.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Map;

public class HistoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //getActivity().setTitle("History");
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        ListView listView = view.findViewById(R.id.history_list);
        ArrayList<String> expressions_list = new ArrayList<>();

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        Map<String, ?> expressions = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : expressions.entrySet()) {
            expressions_list.add(entry.getValue().toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, expressions_list);
        listView.setAdapter(adapter);

        Button clear = view.findViewById(R.id.history_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(HistoryFragment.this).attach(HistoryFragment.this).commit();
            }
        });

        return view;
    }
}
