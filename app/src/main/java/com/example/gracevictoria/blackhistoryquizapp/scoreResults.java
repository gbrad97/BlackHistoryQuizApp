package com.example.gracevictoria.blackhistoryquizapp;

public class scoreResults {
    int correctAnswers;
    int number_Questions;


    public boolean checkAnswer(String answerChosen, String correctAnswer){
        if(answerChosen.equals(correctAnswer)){
            return true;
        }
        else{
            return false;
        }
    }

    public String outputScore(int correctAnswers, int number_Questions){
       String  output = "you got a " + Integer.toString(correctAnswers) +" out of "+ Integer.toString(number_Questions);
        return output;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getNumber_Questions() {
        return number_Questions;
    }

    public void setNumber_Questions(int number_Questions) {
        this.number_Questions = number_Questions;
    }
}
