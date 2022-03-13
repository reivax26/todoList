package com.xavier.pouyadoux.prog1.todolist;
import android.content.Context;

import java.util.UUID;

public class Tarea {


    private UUID mId;
    private String mTitulo;
    private Boolean mRealizada;


    public Tarea(Context context) {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitulo;
    }

    public void setTitle(String Titulo) {
        this.mTitulo = Titulo;
    }

    public boolean isRealizado() {
        return mRealizada;
    }

    public void setRealizado(Boolean mRealizada) {
        this.mRealizada = mRealizada;
    }

}
