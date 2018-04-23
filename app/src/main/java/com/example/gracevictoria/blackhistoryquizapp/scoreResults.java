package com.example.gracevictoria.blackhistoryquizapp;

import java.util.ArrayList;

public class ScoreResults {
    //ArrayList<Question> questions;
    int correctAnswers;
    int number_Questions;

    public ScoreResults(ArrayList<Question> questions) {
        correctAnswers = 0;
        number_Questions = questions.size();
    }

    public ScoreResults(int correctAnswers, int number_Questions) {
        this.correctAnswers = correctAnswers;
        this.number_Questions = number_Questions;
    }


    public boolean checkAnswer(String answerChosen, String correctAnswer){
        if(answerChosen.equals(correctAnswer)){
            return true;
        }
        else{
            return false;
        }
    }

    public String outputScore(){
       String  output = "You received a " + Integer.toString(correctAnswers) +" out of "+ Integer.toString(number_Questions);
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
