package com.example.minijeu_devmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button boutonMain;
    private int score = 0;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boutonMain = findViewById(R.id.buttonToGame);
        boutonMain.setOnClickListener(view -> {
            Intent intent = new Intent(this,GameActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Amusez vous bien ;)",Toast.LENGTH_LONG).show();
        });
    }

    public void bonneReponse() {
        score++;
    }

    public int getScore() {
        return score;
    }
}