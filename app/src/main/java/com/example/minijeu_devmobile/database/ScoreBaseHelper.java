package com.example.minijeu_devmobile.database;

import android.content.Context;

import com.example.minijeu_devmobile.entities.Score;

public class ScoreBaseHelper extends DataBaseHelper{
    public ScoreBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + ScoreDao.tableName + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreDao.player + " VARCHAR NOT NULL," +
                ScoreDao.score + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS " + ScoreDao.tableName;
    }
}
