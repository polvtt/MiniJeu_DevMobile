package com.example.minijeu_devmobile;

import java.util.Random;


public class Utilitaire {
    private static Random random = new Random();
    private static String[] operations = {"+", "-", "*", "/"};

    public static int genererNombreAleatoire(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static String genererSymboleAleatoire() {
        int index = random.nextInt(operations.length);
        return operations[index];
    }

    public static int resultatCalcul(String calcul) {
        //reçoit en paramètre un calcul sous format string et séparé par des espaces
        String[] elements = calcul.split(" ");
        int num1 = Integer.parseInt(elements[0]);
        String operateur = elements[1];
        int num2 = Integer.parseInt(elements[2]);

        switch (operateur) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("Division par zéro !");
                }
            default:
                throw new IllegalArgumentException("Opérateur non valide !");
        }
    }

}
