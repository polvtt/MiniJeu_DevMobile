package com.example.minijeu_devmobile.database;


import android.content.ContentValues;
import android.database.Cursor;

import com.example.minijeu_devmobile.entities.Calcul;

public class CalculDao extends BaseDao<Calcul>{

    public static String tableName = "calcul";
    public static String premierElement = "premierElement";
    public static String deuxiemeElement = "deuxiemeElement";
    public static String symbol = "symbol";
    public static String resultat = "resultat";

    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return tableName;
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(premierElement, entity.getPremierElement());
        values.put(deuxiemeElement, entity.getDeuxiemeElement());
        values.put(symbol, entity.getSymbol());
        values.put(resultat, entity.getResultat());
    }
    @Override
    protected Calcul getEntity(Cursor cursor) {
        Calcul calcul = new Calcul();
        Integer indexPremierElement = cursor.getColumnIndex(premierElement);
        calcul.setPremierElement(cursor.getInt(indexPremierElement));
        Integer indexDeuxiemeElement = cursor.getColumnIndex(deuxiemeElement);
        calcul.setDeuxiemeElement(cursor.getInt(indexDeuxiemeElement));
        Integer indexSymbol = cursor.getColumnIndex(symbol);
        calcul.setSymbol(cursor.getString(indexSymbol));
        Integer indexResultat = cursor.getColumnIndex(resultat);
        calcul.setResultat(cursor.getInt(indexResultat));
        return calcul;
    }
}
