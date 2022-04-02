package com.xavier.pouyadoux.prog1.todolist.controller;

import java.util.UUID;

public class Tarea {


    private UUID mId;
    private String mTitulo;
    private Boolean mRealizada;


    public Tarea(String titulo , Boolean realizado) {
        mId = UUID.randomUUID();
        mTitulo = titulo;
        mRealizada = realizado;
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
