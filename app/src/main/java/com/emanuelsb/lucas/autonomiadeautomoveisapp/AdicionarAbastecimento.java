package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdicionarAbastecimento extends AppCompatActivity {

    private EditText campoKm;
    private EditText campoLitros;

    private EditText campoDia;
    private EditText campoMes;
    private EditText campoAno;

    private Spinner spinnerPosto;

    private Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        campoKm = (EditText) findViewById(R.id.campoKm);
        campoLitros = (EditText) findViewById(R.id.campoLitros);
        campoDia = (EditText) findViewById(R.id.campoDia);
        campoMes = (EditText) findViewById(R.id.campoMes);
        campoAno = (EditText) findViewById(R.id.campoAno);
        spinnerPosto = (Spinner) findViewById(R.id.spinnerPosto);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.postos, android.R.layout.simple_spinner_item);
        spinnerPosto.setAdapter(adapter);
        confirmar = (Button) findViewById(R.id.confirmar);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abastecimento aba = new Abastecimento();
                int kmValido = Integer.parseInt(campoKm.getText().toString());
                if (Abastecimento.obtemLista(AdicionarAbastecimento.this).size() != 0 && kmValido < (Abastecimento.obtemLista(AdicionarAbastecimento.this).get(Abastecimento.obtemLista(AdicionarAbastecimento.this).size()-1).getKm())) {
                    Toast.makeText(getApplicationContext(), "Inválido! Quilometragem menor que a anterior!", Toast.LENGTH_SHORT).show();
                }else {
                    aba.setDia(Integer.parseInt(campoDia.getText().toString()));
                    aba.setMes(Integer.parseInt(campoMes.getText().toString()));
                    aba.setAno(Integer.parseInt(campoAno.getText().toString()));
                    aba.setKm(Integer.parseInt(campoKm.getText().toString()));
                    aba.setLitros(Integer.parseInt(campoLitros.getText().toString()));

                    if(spinnerPosto.getSelectedItem().toString().equals("Texaco")){
                        aba.setPosto(R.drawable.logo_texaco);
                    } else if(spinnerPosto.getSelectedItem().toString().equals("Shell")){
                        aba.setPosto(R.drawable.logo_shell);
                    } else if(spinnerPosto.getSelectedItem().toString().equals("Petrobras")){
                        aba.setPosto(R.drawable.logo_petrobras);
                    } else if(spinnerPosto.getSelectedItem().toString().equals("Ipiranga")){
                        aba.setPosto(R.drawable.logo_ipiranga);
                    } else {
                        aba.setPosto(R.drawable.outros);
                    }

                    Abastecimento.salvarNoBancoDeDados(AdicionarAbastecimento.this, aba);
                    finish();
                }
            }
        });
    }

}
