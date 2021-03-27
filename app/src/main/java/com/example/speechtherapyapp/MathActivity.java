package com.example.speechtherapyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.io.InputStream;


public class MathActivity extends AppCompatActivity {

    private EditText mathUserAnswer;
    private TextView mathQuestionDisplayed;
    private int questionNumber = 0;
    private Button checkButton;
    private Questions myQuestions;

    private static final String TAG = MathActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        myQuestions = new Questions();
        String contentFromDrive = null;

        myQuestions.populateQuestions(contentFromDrive);

        Log.d(TAG, "Qi.q = " + myQuestions.getQuestion(0));
        Log.d(TAG, "Qi.a = " + myQuestions.getAnswer(0));

        mathQuestionDisplayed = (EditText) findViewById(R.id.mQ);
        mathUserAnswer = (EditText) findViewById(R.id.mathAnswer);
        checkButton = (Button) findViewById(R.id.checkButton);

        mathUserAnswer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mathUserAnswer.setText("");
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mathAnswer = myQuestions.getAnswer(questionNumber);
                if (mathUserAnswer.getText().toString().equals(mathAnswer)) {
                    openCorrectAnswer();
                } else{
                    openIncorrectAnswer();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        questionNumber = intent.getIntExtra("Q", 0);

        String mathQuestion = myQuestions.getQuestion(questionNumber);
        mathQuestionDisplayed.setText(mathQuestion);
    }

    public void openCorrectAnswer(){
        Intent intent = new Intent (this, CorrectAnswer.class);
        intent.putExtra("Q", questionNumber);
        startActivity(intent);
    }

    public void openIncorrectAnswer(){
        Intent intent = new Intent (this, IncorrectAnswer.class);
        intent.putExtra("Q", questionNumber);
        startActivity(intent);
    }
}