package com.emanuelsb.lucas.autonomiadeautomoveisapp.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 6109896 on 13/06/2017.
 */

public class BdHelper extends SQLiteOpenHelper {


    public static final int VERSAO = 1;
    public static final String NOME_BD = "meu_bd";

    public BdHelper(Context context){

        super(context, NOME_BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE minha_tabela (" +
                "id integer primary key," +
                "dia int," +
                "mes int," +
                "ano int," +
                "km int," +
                "litros int," +
                "posto int" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //se atualizar a estrutura, lembrar de atualizar o método onCreate
        if(newVersion == 2 && oldVersion == 1){
            db.execSQL("ALTER TABLE minha_tabela ADD COLUMN nova_coluna int;");
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == 1 && oldVersion == 2){
            db.execSQL("ALTER TABLE minha_tabela DROP COLUMN nova_coluna;");
        }
    }




}