package com.xavier.pouyadoux.prog1.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    private Tarea ntarea;
    private EditText mTitleField;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ntarea = new Tarea();
    }

    public void verValor(View v) {
        EditText campoTexto = (EditText) v.findViewById(R.id.tarea_titulo);
        ntarea.setTitle(campoTexto.getText().toString());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tarea_fragment, container, false);


        /**
         * Volver al main Activity
         */
        Button mButtonAddTarea = (Button) v.findViewById(R.id.button);
        mButtonAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verValor(v);

                View rootView = inflater.inflate(R.layout.activity_main, container, false);
                context = rootView.getContext(); // Assign your rootView to context

                Intent myIntent = new Intent(context, MainActivity.class);
                startActivity(myIntent);


            }
        });


        mTitleField = (EditText) v.findViewById(R.id.tarea_titulo);
        mTitleField.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                ntarea.setTitle(s.toString());
                ntarea.setRealizado(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });


        return v;
    }
}
