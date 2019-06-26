package com.example.paisesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.paisesapp.adapter.PaisesAdapter;
import com.example.paisesapp.interfaces.PaisesListener;
import com.example.paisesapp.model.Pais;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PaisesListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pais> listaPaises = new ArrayList<>();

        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setIdioma("Português");
        pais.setBandeira("https://static.significados.com.br/foto/brasil-6f.jpg");
        pais.setQuantidadeDeHabitantes(200_000_000);
        listaPaises.add(pais);

        Pais pais1 = new Pais();
        pais1.setNome("China");
        pais1.setIdioma("人物");
        pais1.setBandeira("https://static.significados.com.br/foto/china.jpg");
        pais1.setQuantidadeDeHabitantes(1_000_000_000);
        listaPaises.add(pais1);

        Pais pais2 = new Pais();
        pais2.setNome("Estados Unidos");
        pais2.setIdioma("Inglês");
        pais2.setBandeira("https://static.significados.com.br/foto/estados-unidos.jpg");
        pais2.setQuantidadeDeHabitantes(300_000_000);
        listaPaises.add(pais2);

        PaisesAdapter paisesAdapter = new PaisesAdapter(listaPaises,this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.paises_recycle_view);
        recyclerView.setAdapter(paisesAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onPaisClickado(Pais pais) {
        Intent intent = new Intent(this, PaisDetalheActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("PAIS",pais);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
