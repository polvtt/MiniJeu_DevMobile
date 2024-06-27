package com.example.minijeu_devmobile.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.minijeu_devmobile.entities.Calcul;
import com.example.minijeu_devmobile.entities.Score;

public class ScoreDao extends BaseDao<Score>{

    public static String tableName = "scoreTable";
    public static String player = "player";
    public static String score = "score";

    public ScoreDao(DataBaseHelper helper) {
        super(helper);
    }

    protected String getTableName() {
        return tableName;
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
        values.put(player, entity.getPlayerName());
        values.put(String.valueOf(score), entity.getScoreParty());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Score score1 = new Score();
        Integer indexPlayerName = cursor.getColumnIndex(player);
        score1.setPlayerName(cursor.getString(indexPlayerName));
        Integer indexScoreParty = cursor.getColumnIndex(score);
        score1.setScore_party(cursor.getInt(indexScoreParty));
        return score1;
    }

}
