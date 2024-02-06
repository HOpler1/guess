package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    boolean gameFinished;

    int guess = 12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView1);
        etInput = findViewById(R.id.editText1);
        bControl = findViewById(R.id.button1);
        guess = (int)(Math.random()*100);
        gameFinished = false;


    }
    public void OnClick(View v){
        if (!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > guess){
                tvInfo.setText("Перелет!");
            }
            if (inp < guess){
                tvInfo.setText("Недолет!");
            }
            if (inp == guess) {
                tvInfo.setText("В точку!");
                bControl.setText("Сыграть еще");
                etInput.setText("");
                gameFinished = true;
            }
        } else {
            guess = (int) (Math.random() * 100);
            bControl.setText("Ввести значение:");
            tvInfo.setText("Попробуйте угадать число (1 - 100)");
            gameFinished = false;
        }

    }
}