package com.example.gracevictoria.blackhistoryquizapp;

public class Body {
    private int id;
    private String questiontxt;
    private String correctAns;
    private String wrongAns1;
    private String wrongAns2;
    private String wrongAns3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestiontxt() {
        return questiontxt;
    }

    public void setQuestiontxt(String questiontxt) {
        this.questiontxt = questiontxt;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getWrongAns1() {
        return wrongAns1;
    }

    public void setWrongAns1(String wrongAns1) {
        this.wrongAns1 = wrongAns1;
    }

    public String getWrongAns2() {
        return wrongAns2;
    }

    public void setWrongAns2(String wrongAns2) {
        this.wrongAns2 = wrongAns2;
    }

    public String getWrongAns3() {
        return wrongAns3;
    }

    public void setWrongAns3(String wrongAns3) {
        this.wrongAns3 = wrongAns3;
    }



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
