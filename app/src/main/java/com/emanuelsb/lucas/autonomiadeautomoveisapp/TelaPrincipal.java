package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    private Button add;

    private Button vizual;

    private TextView autonomia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        add = (Button) findViewById(R.id.add);
        vizual = (Button) findViewById(R.id.vizual);
        autonomia = (TextView) findViewById(R.id.autonomia);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdicionarAbastecimento.class));
            }
        });

        vizual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VisualizarAbastecimento.class));
            }
        });

    }

    public String atualizaAutonomia () {
        int autonomiaAtualizada = 0;
        if(Abastecimento.obtemLista(TelaPrincipal.this).size() == 1) {
            int km = Abastecimento.obtemLista(TelaPrincipal.this).get(Abastecimento.obtemLista(TelaPrincipal.this).size()).getKm();
            int litros = Abastecimento.obtemLista(TelaPrincipal.this).get(Abastecimento.obtemLista(TelaPrincipal.this).size()).getLitros();
            autonomiaAtualizada = km/litros;
            return Integer.toString(autonomiaAtualizada);
        } else if(Abastecimento.obtemLista(TelaPrincipal.this).size() >= 2) {
            int finalKm = Abastecimento.obtemLista(TelaPrincipal.this).get(Abastecimento.obtemLista(TelaPrincipal.this).size() - 1).getKm();
            int inicialKm = Abastecimento.obtemLista(TelaPrincipal.this).get(Abastecimento.obtemLista(TelaPrincipal.this).size() - 2).getKm();
            int litrosTotais = Abastecimento.obtemLista(TelaPrincipal.this).get(Abastecimento.obtemLista(TelaPrincipal.this).size() - 2).getLitros();
            autonomiaAtualizada = (finalKm - inicialKm) / litrosTotais;
            return Integer.toString(autonomiaAtualizada);
        }else{
            return "0";
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        autonomia.setText(atualizaAutonomia());
    }

}
