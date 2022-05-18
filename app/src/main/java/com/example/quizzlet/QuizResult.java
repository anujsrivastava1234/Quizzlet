package com.example.quizzlet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton startNewQuiz=findViewById(R.id.startNewQuizBtn);
        final TextView correct=findViewById(R.id.correctAnswer);
        final TextView incorrect=findViewById(R.id.incorrectAnswer);

        final int getCorrectAnswer=getIntent().getIntExtra("correct",0);
        final int getIncorrectAnswer=getIntent().getIntExtra("incorrect",0);

        correct.setText(String.valueOf(getCorrectAnswer));
        incorrect.setText(String.valueOf(getIncorrectAnswer));

        startNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResult.this,landing_page.class));
                finish();
            }
        });
    }
}