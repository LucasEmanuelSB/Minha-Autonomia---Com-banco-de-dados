package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by lucas on 27/05/2017.
 */

public class AbastecimentoAdapter extends RecyclerView.Adapter<AbastecimentoHolder> {

    private ArrayList<Abastecimento> listaAbastecimentos;
    private Context context;


    public AbastecimentoAdapter(ArrayList<Abastecimento> aba, Context context) {
        this.listaAbastecimentos = aba;
        this.context = context;
    }

    @Override
    public AbastecimentoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, null);
        AbastecimentoHolder rcv = new AbastecimentoHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(AbastecimentoHolder holder, int position) {
        Abastecimento atual = listaAbastecimentos.get(position);
        holder.renderizaNovoAbastecimento(atual);
    }

    @Override
    public int getItemCount() {
        return listaAbastecimentos.size();
    }

}
