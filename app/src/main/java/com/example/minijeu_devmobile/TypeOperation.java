package com.example.minijeu_devmobile;

public enum TypeOperation {
    PLUS("+"),
    SUBSTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*");


    private String symbole;

    TypeOperation(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }
}
