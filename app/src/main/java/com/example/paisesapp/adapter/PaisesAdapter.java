package com.example.paisesapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paisesapp.R;
import com.example.paisesapp.interfaces.PaisesListener;
import com.example.paisesapp.model.Pais;

import java.io.Serializable;
import java.util.List;

public class PaisesAdapter extends RecyclerView.Adapter<PaisesAdapter.ViewHolder> {



    private List<Pais> listaPaises;
    private PaisesListener paisesListener;

    public PaisesAdapter(List<Pais> listaPaises, PaisesListener paisesListener){

        this.listaPaises = listaPaises;
        this.paisesListener = paisesListener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pais_celula,viewGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Pais pais = listaPaises.get(i);
        viewHolder.setupPais(pais);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paisesListener.onPaisClickado(pais);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView bandeiraImageView;
        private TextView nomeTextView;
        private TextView populacaoTextView;
        private TextView idiomaTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bandeiraImageView = itemView.findViewById(R.id.bandeira_image_view);
            nomeTextView = itemView.findViewById(R.id.nome_pais_text_view);
            populacaoTextView = itemView.findViewById(R.id.populacao_text_view);
            idiomaTextView = itemView.findViewById(R.id.idioma_text_view);
        }

        public void setupPais(Pais pais){

            nomeTextView.setText(pais.getNome());
            populacaoTextView.setText("pop. "+pais.getQuantidadeDeHabitantes());
            idiomaTextView.setText(pais.getIdioma());

        }

    }


}
