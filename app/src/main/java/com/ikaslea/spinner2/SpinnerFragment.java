package com.ikaslea.spinner2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SpinnerFragment extends Fragment {
    private Spinner GureSpinner;
    private TextView testua;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spinner, container, false);


        GureSpinner = view.findViewById(R.id.spinner);
        testua = view.findViewById(R.id.textView);


        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(
                getContext(),
                R.array.planets_array,
                android.R.layout.simple_spinner_dropdown_item
        );
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        GureSpinner.setAdapter(adaptador);
        GureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                testua.setText("Seleccionado: " + selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                testua.setText("");
            }
        });
        return view;
    }
}