package com.xavier.pouyadoux.prog1.todolist.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.xavier.pouyadoux.prog1.todolist.MainActivity;
import com.xavier.pouyadoux.prog1.todolist.R;
import com.xavier.pouyadoux.prog1.todolist.controller.TareaLab;

public class EditarTarea extends AppCompatActivity {
    Bundle UUIDTareaModificar;
    int uuid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_tarea);

        UUIDTareaModificar = getIntent().getExtras();
        uuid = UUIDTareaModificar.getInt("UUIDTarea");

        System.out.println(uuid);

        Button mButtonSavechanges = (Button) findViewById(R.id.button_save_Changes);
        mButtonSavechanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                EditText text = (EditText)findViewById(R.id.Edit_titulo);
                String value = text.getText().toString();

                TareaLab tareaLab = TareaLab.get();
                tareaLab.getTarea().get(uuid).setTitle(value);

                VolverMainActivity();
                // canviar fragment
            }
        });
    }

    public void VolverMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
