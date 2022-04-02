package com.xavier.pouyadoux.prog1.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xavier.pouyadoux.prog1.todolist.controller.EditarTarea;
import com.xavier.pouyadoux.prog1.todolist.controller.Persistencia;
import com.xavier.pouyadoux.prog1.todolist.controller.Tarea;
import com.xavier.pouyadoux.prog1.todolist.controller.TareaLab;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mTareaRecyclerView;
    List<Tarea> tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * API
         */
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonplacehoderAPI service = retrofit.create(JsonplacehoderAPI.class);

        service.getTodo("5").enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.d("MAIN", "TODO OK");
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.d("MAIN", "TODO KO");
            }
        */


        /**
         * boton para añadir nueva tarea
         */
        Button mButtonAddTarea = (Button) findViewById(R.id.Button_add);
        mButtonAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * llamada fragment activity
                 */
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.fragment_container);

                if (fragment == null) {
                    fragment = new ListFragment();
                    fm.beginTransaction()
                            .add(R.id.fragment_container, fragment)
                            .commit();
                }
            }

        });


        /**
         * mostrar activity main recycerview
         */
        mTareaRecyclerView = (RecyclerView) findViewById(R.id.tarea_recyclerView);
        mTareaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateUI();
    }


    private void updateUI() {
        TareaLab tareaLab = TareaLab.get();
        List<Tarea> tareas = tareaLab.getTarea();

        // leer


        TareaAdapter mAdapter = new TareaAdapter(tareas);
        mTareaRecyclerView.setAdapter(mAdapter);
    }


    // Adapter
    private class TareaAdapter extends RecyclerView.Adapter<TareaHolder> {
        private final List<Tarea> mTareas;


        public TareaAdapter(List<Tarea> tareas) {
            mTareas = tareas;

        }

        @NonNull
        @Override
        public TareaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new TareaHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(TareaHolder holder, int position) {
            Tarea tarea = mTareas.get(position);
            holder.bind(tarea);
        }

        @Override
        public int getItemCount() {
            return mTareas.size();
        }
    }

// holder
    private class TareaHolder extends RecyclerView.ViewHolder {
        private Tarea mTarea;
        private final TextView mTituloTextView;

        public TareaHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            mTituloTextView = (TextView) itemView.findViewById(R.id.Tarea_titulo);


            /**
             * Listener para marcar tarea realizada
             */
            itemView.findViewById(R.id.Button_estado).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mTarea.isRealizado()) {
                        mTituloTextView.setPaintFlags( mTituloTextView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                        mTarea.setRealizado(false);
                    } else {
                        mTituloTextView.setPaintFlags(mTituloTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        mTarea.setRealizado(true);
                    }

                }
            });

            /**
             * TextView button editar tarea
             */
            itemView.findViewById(R.id.Tarea_titulo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   EditarTituloTarea(getAdapterPosition());
                }
            });

        }

    /**
     * mostrar tareas y tacha las que estan realizadas
     * @param tarea
     */
    public void bind(Tarea tarea) {
            mTarea = tarea;
            if (tarea.isRealizado()){
                mTituloTextView.setText(mTarea.getTitle());
                mTituloTextView.setPaintFlags(mTituloTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                mTituloTextView.setText(mTarea.getTitle());
            }

        }
    }
    public void EditarTituloTarea(int id){
        Intent intent = new Intent(this , EditarTarea.class);
        intent.putExtra("UUIDTarea",id);
        startActivity(intent);
    }

}

