package com.example.speechtherapyapp;

public class QandA {
    private String question;
    private String answer;

    public QandA(String q, String a) {
        question = q;
        answer = a;
    }

    public String getQ() {
        return question;
    }

    public String getA() {
        return answer;
    }
}
