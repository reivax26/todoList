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

        for (int i = 0; i < 2; i++) {
            Tarea tarea = new Tarea();
            tarea.setTitle("Tarea #" + i);
            tarea.setRealizado(i % 2 == 0);
            mTareas.add(tarea);
        }
    }

    public List<Tarea> getTarea() {
        return mTareas;
    }
}
