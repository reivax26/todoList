package com.xavier.pouyadoux.prog1.todolist.Api;

import com.xavier.pouyadoux.prog1.todolist.model.Todo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonplacehoderAPI {

        @GET("todos/{todoID}")
        Call<Todo> getTodo(@Path("todoID") String todoID);

}
