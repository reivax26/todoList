package com.xavier.pouyadoux.prog1.todolist;

import java.util.Date;
import java.util.UUID;

public class Tareas {


    private UUID mId;
    private String mTitulo;
    private Date mDate;
    private boolean mRealizada;

    public Tareas() {
        mId = UUID.randomUUID();
        mDate = new Date();
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

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isRealizado() {
        return mRealizada;
    }

    public void setRealizado(boolean mRealizada) {
        this.mRealizada = mRealizada;
    }

}
