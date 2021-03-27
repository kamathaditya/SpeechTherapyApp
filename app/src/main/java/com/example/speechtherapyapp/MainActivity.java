package com.example.speechtherapyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mathActivityButton;
    private Button grammarActivityButton;
    private Button comprehensionActivityButton;
    private Button voiceActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mathActivityButton = (Button) findViewById(R.id.mathActivityButton);
        grammarActivityButton = (Button) findViewById(R.id.grammarActivityButton);
        comprehensionActivityButton = (Button) findViewById(R.id.comprehensionActivityButton);
        voiceActivityButton = (Button) findViewById(R.id.voiceActivityButton);

        mathActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMathActivity();

            }
        });

        grammarActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGrammarActivity();

            }
        });


        comprehensionActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openComprehensionActivity();

            }
        });

        voiceActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openVoiceActivity();

            }
        });

    }

    public void openMathActivity(){
        Intent intent = new Intent (this, MathActivity.class);
        startActivity(intent);
    }

    public void openGrammarActivity(){
        Intent intent = new Intent (this, GrammarActivity.class);
        startActivity(intent);
    }

    public void openComprehensionActivity(){
        Intent intent = new Intent (this, ComprehensionActivity.class);
        startActivity(intent);
    }

    public void openVoiceActivity(){
        Intent intent = new Intent (this, VoiceActivity.class);
        startActivity(intent);
    }





}