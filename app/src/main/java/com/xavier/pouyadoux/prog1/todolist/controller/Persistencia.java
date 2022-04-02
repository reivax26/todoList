package com.xavier.pouyadoux.prog1.todolist.controller;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Persistencia extends AppCompatActivity {

    public static void guardarDatos(List<Tarea> tareas, Activity activity) {

        Gson g = new Gson();

        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String tareasjson = g.toJson(tareas);

        editor.putString("tarea", tareasjson);
        editor.apply();
    }

    public void leerDatos(List<Tarea> tareas) {

        SharedPreferences preferences = getSharedPreferences("shared preferences" , MODE_PRIVATE);

        Gson g = new Gson();

        String tareasjson = preferences.getString("tarea list\"", null);

        Type type = new TypeToken<List<Tarea>>() {}.getType();
        tareas = g.fromJson(tareasjson,type);

    }
}
