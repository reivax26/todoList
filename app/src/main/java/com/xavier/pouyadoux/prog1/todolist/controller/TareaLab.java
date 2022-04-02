package com.xavier.pouyadoux.prog1.todolist.controller;

import androidx.appcompat.app.AppCompatActivity;

import com.xavier.pouyadoux.prog1.todolist.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class TareaLab extends AppCompatActivity {
    private static TareaLab sTareaLab;
    private MainActivity mainActivity;
    List<Tarea> mTareas;


    public static TareaLab get() {

        if (sTareaLab == null) {
            sTareaLab = new TareaLab();
        }
        return sTareaLab;
    }

    private TareaLab() {

        mTareas = new ArrayList<>();
        Tarea t1 = new Tarea("Sacar al perro",false);
        mTareas.add(t1);
        Tarea t2 = new Tarea("Comprar pan",false);
        mTareas.add(t2);
        Tarea t3 = new Tarea("Revisar correo de La Salle",false);
        mTareas.add(t3);
        Tarea t4 = new Tarea("Preparar reuniones del día",false);
        mTareas.add(t4);
        Tarea t5 = new Tarea("Hacer ejercicio",false);
        mTareas.add(t5);


    }

    public List<Tarea> getTarea() {


        return mTareas;
    }




}