package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class VisualizarAbastecimento extends AppCompatActivity {

    private AbastecimentoAdapter abastecimentoAdapter;
    private RecyclerView rvAbastecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_abastecimento);

        rvAbastecimento = (RecyclerView) findViewById(R.id.rvAbastecimento);
        rvAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        abastecimentoAdapter = new AbastecimentoAdapter(Abastecimento.obtemLista(VisualizarAbastecimento.this),VisualizarAbastecimento.this);
        rvAbastecimento.setAdapter(abastecimentoAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        if(abastecimentoAdapter != null) {
            abastecimentoAdapter.notifyDataSetChanged();
        }
    }


}