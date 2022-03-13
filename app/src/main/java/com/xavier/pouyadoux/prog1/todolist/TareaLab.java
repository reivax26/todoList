package com.xavier.pouyadoux.prog1.todolist;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TareaLab {
    private static TareaLab sTareaLab;

    private List<Tarea> mTareas;

    public static TareaLab get (Context context) {

        if (sTareaLab == null) {
            sTareaLab = new TareaLab(context);
        }
        return sTareaLab;
    }

    private TareaLab(Context context) {

        mTareas = new ArrayList<>();
        Tarea t1 = new Tarea(context); t1.setTitle("Sacar al perro"); t1.setRealizado(false);
        mTareas.add(t1);
        Tarea t2 = new Tarea(context); t2.setTitle("Comprar pan"); t2.setRealizado(false);
        mTareas.add(t2);
        Tarea t3 = new Tarea(context); t3.setTitle("Revisar correo de La Salle"); t3.setRealizado(false);
        mTareas.add(t3);
        Tarea t4 = new Tarea(context); t4.setTitle("Preparar reuniones del día"); t4.setRealizado(false);
        mTareas.add(t4);
        Tarea t5 = new Tarea(context); t5.setTitle("Hacer ejercicio"); t5.setRealizado(false);
        mTareas.add(t5);



    }

    public List<Tarea> getTarea() {
        return mTareas;
    }
}