package com.example.paisesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.paisesapp.adapter.PaisesAdapter;
import com.example.paisesapp.model.Pais;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pais> listaPaises = new ArrayList<>();

        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setIdioma("PT-BR");
        pais.setQuantidadeDeHabitantes(200_000_000);
        listaPaises.add(pais);

        Pais pais1 = new Pais();
        pais1.setNome("China");
        pais1.setIdioma("人物");
        pais1.setQuantidadeDeHabitantes(1_000_000_000);
        listaPaises.add(pais1);

        Pais pais2 = new Pais();
        pais2.setNome("Estados Unidos");
        pais2.setIdioma("Inglês");
        pais2.setQuantidadeDeHabitantes(300_000_000);
        listaPaises.add(pais2);

        PaisesAdapter paisesAdapter = new PaisesAdapter(listaPaises);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.paises_recycle_view);
        recyclerView.setAdapter(paisesAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
