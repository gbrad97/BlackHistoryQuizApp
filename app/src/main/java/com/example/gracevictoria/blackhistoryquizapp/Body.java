package com.example.gracevictoria.blackhistoryquizapp;

public class Body {
    private int id;
    private String questiontxt;
    private String correctAns;
    private String wrongAns1;
    private String wrongAns2;
    private String wrongAns3;

    public Body(String data) {
        String[] tokens = data.split(",");
        id = Integer.parseInt(tokens[0]);
        questiontxt = tokens[1];
        correctAns = tokens[2];
        wrongAns1 = tokens[3];
        wrongAns2 = tokens[4];
        wrongAns3 = tokens[5];

    }

}
