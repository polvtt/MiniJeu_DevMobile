package com.example.minijeu_devmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.minijeu_devmobile.entities.Calcul;

import java.util.Random;

public class GameActivity extends AppCompatActivity {


    private int score = 0;

    private static Random random = new Random();
    private static String[] operations = {"+", "-", "*"};

    private Button button0, button1, button2, button3, button4, button5,button6, button7, button8, button9;
    private Button buttonRetour, buttonSupprimer, buttonValider;

    private TextView textReponse;
    private Integer premierElement=0;
    private Integer deuxiemeElement=0;
    private Integer calculTotal=0;
    private String typeOperation=null;
    private TextView scoreTextView;
    private TextView calculTextView;
    private String currentCalcul;
    private TextView resultatTextView;
    private ImageView vie1;
    private ImageView vie2;
    private ImageView vie3;

    private int vies = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonRetour = findViewById(R.id.buttonRetour);
        buttonSupprimer = findViewById(R.id.button_supprimer);
        buttonValider = findViewById(R.id.button_valider);
        scoreTextView = findViewById(R.id.score);
        calculTextView = findViewById(R.id.calcul_text);
        resultatTextView = findViewById(R.id.resultat_text);
        vie1 = findViewById(R.id.vie1);
        vie2 = findViewById(R.id.vie2);
        vie3 = findViewById(R.id.vie3);

        genererNouveauCalcul();
        afficherResultat();

        textReponse = findViewById(R.id.text_reponse);
        button0.setOnClickListener(view -> appuieChiffre("0"));
        button1.setOnClickListener(view -> appuieChiffre("1"));
        button2.setOnClickListener(view -> appuieChiffre("2"));
        button3.setOnClickListener(view -> appuieChiffre("3"));
        button4.setOnClickListener(view -> appuieChiffre("4"));
        button5.setOnClickListener(view -> appuieChiffre("5"));
        button6.setOnClickListener(view -> appuieChiffre("6"));
        button7.setOnClickListener(view -> appuieChiffre("7"));
        button8.setOnClickListener(view -> appuieChiffre("8"));
        button9.setOnClickListener(view -> appuieChiffre("9"));
        buttonSupprimer.setOnClickListener(view -> clearReponse());
        buttonValider.setOnClickListener(view -> validerReponse());

        buttonRetour.setOnClickListener(view -> {
            resetJeu();
            Intent intent = new Intent(this,MainActivity.class);
            Toast.makeText(this,"",Toast.LENGTH_LONG).show();
            startActivity(intent);
        });

    }

    private void genererNouveauCalcul() {
        premierElement=genererNombreAleatoire(0,10);
        deuxiemeElement=genererNombreAleatoire(0,10);
        typeOperation=genererSymboleAleatoire();

        currentCalcul = premierElement + " " + typeOperation + " " + deuxiemeElement;

        if (resultatCalcul(currentCalcul) < 0) {
            genererNouveauCalcul();
        }
        calculTextView.setText(currentCalcul);
    }

    private void afficherResultat(){
        String resultat = resultatCalcul(currentCalcul) + "";
        resultatTextView.setText(resultat);
    }


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

    private void ajouteCharactere(String CharactereAAjouter){
        textReponse.setText(textReponse.getText() + CharactereAAjouter);
    }

    private void appuieChiffre(String chiffre){
        ajouteCharactere(chiffre);
        if(typeOperation==null){
            premierElement = 10*premierElement + Integer.parseInt(chiffre);
        }else{
            deuxiemeElement = 10*deuxiemeElement + Integer.parseInt(chiffre);
        }
    }



    public void bonneReponse() {
        score++;
        scoreTextView.setText(""+score);
    }

    public int getScore() {
        return score;
    }

    public void clearReponse(){
        textReponse.setText("");
    }

    public void validerReponse(){

        vie1 = findViewById(R.id.vie1);
        vie2 = findViewById(R.id.vie2);
        vie3 = findViewById(R.id.vie3);

        if(textReponse.getText().toString().equals(resultatTextView.getText().toString())){
            bonneReponse();
            genererNouveauCalcul();
            afficherResultat();
            clearReponse();
        }else if (textReponse.getText().toString().equals("")){
            Toast.makeText(this, "Veuillez entrer une réponse", Toast.LENGTH_SHORT).show();
        }else{
            clearReponse();
            vies--;
            mettreAJourVies();
            if (vies > 0) {
                Toast.makeText(this, "Incorrect ! Vies restantes : $vies", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Game Over ! Score final : $score", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, NameActivity.class);
                startActivity(intent);}
        }
    }

    private void mettreAJourVies() {
        switch (vies) {
            case 2:
                vie3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                vie2.setVisibility(View.INVISIBLE);
                break;
            case 0:
                vie1.setVisibility(View.INVISIBLE);
                break;
        }
    }


    private boolean resetJeu() {
        textReponse.setText("");
        premierElement = 0;
        deuxiemeElement = 0;
        calculTotal = 0;
        typeOperation = null;
        buttonValider.setEnabled(true);
        return true;
    }

}