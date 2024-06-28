package com.example.minijeu_devmobile.entities;

public class Score extends BaseEntity{
    private String player_name;
    private Integer score_party;

    public Score(String playerName, int score) {
        super();
    }

    public Score() {

    }

    public void setPlayerName(String player_name){this.player_name = player_name;}

    public void setScore_party(Integer score_party){this.score_party = score_party;}

    public String getPlayerName() {
        return player_name;
    }

    public Integer getScoreParty() {
        return score_party;
    }


}
