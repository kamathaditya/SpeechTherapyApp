package com.example.speechtherapyapp;

public class Questions {

    private QandA[] qandAArray;

    public Questions() {
        qandAArray = new QandA[4];
        qandAArray[0] = new QandA("2 * 1", "2");
        qandAArray[1] = new QandA("100 / 2", "50");
        qandAArray[2] = new QandA("17 - 8", "9");
        qandAArray[3] = new QandA("34 + 37", "71");
    }

    public String getQuestion(int n) {
        return qandAArray[n].getQ();
    }

    public String getAnswer(int n) {
        return qandAArray[n].getA();
    }

    public void populateQuestions(String questionsAnswers) {

    }
}
