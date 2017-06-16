package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lucas on 27/05/2017.
 */

public class AbastecimentoHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private ImageView icone;
    private TextView data;
    private TextView valueKm;
    private TextView valueLitros;

    private Abastecimento objAbastecimento;

    public AbastecimentoHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();

        icone = (ImageView) itemView.findViewById(R.id.icone);
        data = (TextView) itemView.findViewById(R.id.data);
        valueKm = (TextView) itemView.findViewById(R.id.valueKm);
        valueLitros = (TextView) itemView.findViewById(R.id.valueLitros);
    }

    public void renderizaNovoAbastecimento(Abastecimento aba) {
        this.icone.setImageResource(aba.getPosto());
        this.data.setText(aba.getDia() + "/" + aba.getMes() + "/" + aba.getAno());
        this.valueKm.setText(Integer.toString(aba.getKm()));
        this.valueLitros.setText(Integer.toString(aba.getLitros()));
        objAbastecimento = aba;
    }

}


