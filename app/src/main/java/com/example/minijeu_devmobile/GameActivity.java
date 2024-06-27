package com.example.minijeu_devmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.minijeu_devmobile.entities.Calcul;

public class GameActivity extends AppCompatActivity {
    private Button button0, button1, button2, button3, button4, button5,button6, button7, button8, button9, buttonRetour;

    private TextView textCalcul;
    private Integer premierElement=0;
    private Integer deuxiemeElement=0;
    private Integer calculTotal=0;
    private TypeOperation typeOperation=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        buttonRetour.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
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

        textCalcul = findViewById(R.id.text_calcul);
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
    }

    private void ajouteCharactere(String CharactereAAjouter){
        textCalcul.setText(textCalcul.getText() + CharactereAAjouter);
    }

    private void appuieChiffre(String chiffre){
        ajouteCharactere(chiffre);
        if(typeOperation==null){
            premierElement = 10*premierElement + Integer.parseInt(chiffre);
        }else{
            deuxiemeElement = 10*deuxiemeElement + Integer.parseInt(chiffre);
        }
    }

    private void appuieType(TypeOperation typeOperation){
        ajouteCharactere(typeOperation.getSymbole());
        this.typeOperation = typeOperation;
    }

    /** @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=  getMenuInflater();
        inflater.inflate(R.menu.monmenu,menu);
        MenuItem btn_vider = menu.findItem(R.id.btn_clear);
        btn_vider.setOnMenuItemClickListener(view -> vide());
        MenuItem btn_calculer = menu.findItem(R.id.btn_calculer);
        btn_calculer.setOnMenuItemClickListener(view ->
                calculer()
        );
        return super.onCreateOptionsMenu(menu);
    } **/

    private boolean calculer() {
        Calcul calcul = new Calcul();
        calcul.setPremierElement(premierElement);
        calcul.setDeuxiemeElement(deuxiemeElement);
        calcul.setSymbol(typeOperation.getSymbole());
        switch (typeOperation){
            case PLUS:
                calculTotal = premierElement + deuxiemeElement;
                premierElement = calculTotal;
                deuxiemeElement = 0;
                break;
            case SUBSTRACT:
                calculTotal = premierElement - deuxiemeElement;
                premierElement = calculTotal;
                deuxiemeElement = 0;
                break;
            case MULTIPLY:
                calculTotal = premierElement * deuxiemeElement;
                premierElement = calculTotal;
                deuxiemeElement = 0;
                break;
            case DIVIDE:
                calculTotal = premierElement / deuxiemeElement;
                premierElement = calculTotal;
                deuxiemeElement = 0;
                break;
        }
        calcul.setResultat(calculTotal);
        textCalcul.setText("");
        Toast.makeText(this,"Le resultat est : "+calculTotal,Toast.LENGTH_LONG).show();
        return true;
    }

    private boolean vide() {
        textCalcul.setText("");
        premierElement = 0;
        deuxiemeElement = 0;
        calculTotal = 0;
        typeOperation = null;
        return true;
    }



}