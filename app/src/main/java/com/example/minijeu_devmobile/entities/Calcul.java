package com.example.minijeu_devmobile.entities;

public class Calcul extends BaseEntity{
    private Integer premierElement;
    private Integer deuxiemeElement;
    private String symbol;
    private Integer resultat;

    public Integer getPremierElement() {
        return premierElement;
    }

    public Integer getDeuxiemeElement() {
        return deuxiemeElement;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getResultat() {
        return resultat;
    }

    public void setPremierElement(Integer premierElement) {
        this.premierElement = premierElement;
    }

    public void setDeuxiemeElement(Integer deuxiemeElement) {
        this.deuxiemeElement = deuxiemeElement;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setResultat(Integer resultat) {
        this.resultat = resultat;
    }
}
