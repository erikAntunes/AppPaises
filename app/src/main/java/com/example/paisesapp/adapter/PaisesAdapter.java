package com.example.paisesapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paisesapp.R;
import com.example.paisesapp.model.Pais;

import java.util.List;

public class PaisesAdapter extends RecyclerView.Adapter<PaisesAdapter.ViewHolder> {



    private List<Pais> listaPaises;

    public PaisesAdapter(List<Pais> listaPaises){
        this.listaPaises = listaPaises;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pais_celula,viewGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Pais pais = listaPaises.get(i);
        viewHolder.setupPais(pais);

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
