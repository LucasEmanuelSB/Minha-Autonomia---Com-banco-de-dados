package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import com.emanuelsb.lucas.autonomiadeautomoveisapp.storage.BdHelper;
/**
 * Created by lucas on 27/05/2017.
 */

public class Abastecimento {

    private int dia;
    private int mes;
    private int ano;
    private int km;
    private int litros;
    private int posto;

    public Abastecimento(int dia, int mes, int ano, int km, int litros, int posto){

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.km = km;
        this.litros = litros;
        this.posto = posto;
    }

    public Abastecimento(){

    }

    public static void salvarNoBancoDeDados(Context context, Abastecimento aba) {
        BdHelper bdHelper = new BdHelper( context );
        SQLiteDatabase bd = bdHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("dia", aba.getDia());
        values.put("mes", aba.getMes());
        values.put("ano", aba.getAno());
        values.put("km", aba.getKm());
        values.put("litros", aba.getLitros());
        values.put("posto", aba.getPosto());

        bd.insert("minha_tabela", null, values);

    }

    public static ArrayList<Abastecimento> obtemLista(Context context) {
        ArrayList<Abastecimento> listaAbastecimento = new ArrayList<>();
        BdHelper bdHelper = new BdHelper(context);
        SQLiteDatabase db = bdHelper.getReadableDatabase();

        String[] projecao = {
                "dia",
                "mes",
                "ano",
                "km",
                "litros",
                "posto"};

        String orderBy = "id ASC";

        Cursor c = db.query(
                "minha_tabela",
                projecao,
                null,
                null,
                null,
                null,
                orderBy
        );

        if(c.moveToFirst()){
            do{
                Abastecimento aba = new Abastecimento();
                aba.setDia(c.getInt(0));
                aba.setMes(c.getInt(1));
                aba.setAno(c.getInt(2));
                aba.setKm(c.getInt(3));
                aba.setLitros(c.getInt(4));
                aba.setPosto(c.getInt(5));
                listaAbastecimento.add(aba);
            } while (c.moveToNext());
        }


        return listaAbastecimento;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }
}
