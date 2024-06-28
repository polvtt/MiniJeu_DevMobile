package com.example.minijeu_devmobile;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minijeu_devmobile.database.BaseDao;
import com.example.minijeu_devmobile.database.ScoreBaseHelper;
import com.example.minijeu_devmobile.database.ScoreDao;
import com.example.minijeu_devmobile.entities.Score;


public class NameActivity extends AppCompatActivity {

    ScoreDao baseDAO;
    Button button_home;
    View playerNameInput;
    String player_name;
    Integer scoreFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_name);

        button_home = findViewById(R.id.button_home);
        playerNameInput = findViewById(R.id.text_inputPlayer);
        player_name = playerNameInput.toString();

        button_home.setOnClickListener(view ->{
            ajoutEnBase(player_name, scoreFinal);
            retourMenu();
            });
    }

    private void ajoutEnBase(String player_name, int score){
        Score resultat = new Score(player_name, score);
        baseDAO = new ScoreDao(new ScoreBaseHelper(this, "scoreTable", 1));
        baseDAO.create(resultat);
    }

    private void retourMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
