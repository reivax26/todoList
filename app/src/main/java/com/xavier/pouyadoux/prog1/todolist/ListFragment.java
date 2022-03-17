package com.xavier.pouyadoux.prog1.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.List;

public class ListFragment extends Fragment {

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                View rootView = inflater.inflate(R.layout.activity_main, container, false);
                context = rootView.getContext(); // Assign your rootView to context

                EditText text = (EditText)v.findViewById(R.id.tarea_titulo);
                String value = text.getText().toString();

                Tarea tarea = new Tarea(value , false);

                TareaLab tareaLab = TareaLab.get();
                tareaLab.getTarea().add(tarea);

                Intent myIntent = new Intent(context, MainActivity.class);
                startActivity(myIntent);
                // canviar fragment
            }
        });


        return v;
    }
}
