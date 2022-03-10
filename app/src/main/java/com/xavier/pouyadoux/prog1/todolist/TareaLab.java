package com.xavier.pouyadoux.prog1.todolist;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TareaLab {
    private static TareaLab sTareaLab;

    private List<Tareas> mTareas;

    public static TareaLab get (Context context) {

        if (sTareaLab == null) {
            sTareaLab = new TareaLab(context);
        }
        return sTareaLab;
    }

    private TareaLab(Context context) {
        mTareas = new ArrayList<>();

        for (int i = 0; i < 160; i++) {
            Tareas tareas = new Tareas();
            tareas.setTitle("Tarea #" + i);
            tareas.setRealizado(i % 2 == 0);
            mTareas.add(tareas);
        }
    }

    public List<Tareas> getTarea() {
        return mTareas;
    }
}
