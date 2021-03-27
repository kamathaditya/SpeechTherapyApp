package com.example.speechtherapyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CorrectAnswer extends AppCompatActivity {

    private Button mathNextQuestionButton;
    private int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);


        mathNextQuestionButton = (Button) findViewById(R.id.NextQuestionBtn);

        mathNextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMathActivity();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = getIntent();
        this.questionNumber = i.getIntExtra("Q", 0);
    }

    public void openMathActivity(){
        Intent intent = new Intent (this, MathActivity.class);
        questionNumber++;
        intent.putExtra("Q", questionNumber);
        startActivity(intent);
    }
}