package com.xavier.pouyadoux.prog1.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mTareaRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButtonAddTarea = (Button) findViewById(R.id.Button_add);
        mButtonAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        mTareaRecyclerView = (RecyclerView) findViewById(R.id.tarea_recyclerView);
        mTareaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateUI();
    }


    private void updateUI() {
        TareaLab tareaLab = TareaLab.get(this);
        List<Tarea> tareas = tareaLab.getTarea();

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


    private class TareaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Tarea mTarea;

        private final TextView mTituloTextView;
        private Button mButtonEstado;

        public TareaHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.lista_tareas, parent, false));
            itemView.setOnClickListener(this);

            mTituloTextView = (TextView) itemView.findViewById(R.id.Tarea_titulo);
            mButtonEstado = (Button) itemView.findViewById(R.id.Button_estado);


        }

        public void bind(Tarea tarea) {
            mTarea = tarea;
            mTituloTextView.setText(mTarea.getTitle());
            //  mButtonEstado.setOnClickListener();

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,
                    mTarea.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }


}

