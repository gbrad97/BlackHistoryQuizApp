package com.example.gracevictoria.blackhistoryquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;

import static com.example.gracevictoria.blackhistoryquizapp.MainActivity.ACTIVITY_TAG;

/**
 * Created by winstonparris on 3/29/18.
 */

public class SubActivity1 extends Activity {
    public static final String DA = "MainActivity";
    public TextView questionText;
    public RadioGroup answersRadioButtonGroup;
    public TextView textView;
    public RadioButton answer1RadioBtn;
    public RadioButton answer2RadioBtn;
    public RadioButton answer3RadioBtn;
    public RadioButton answer4RadioBtn;
    public Button returnToMainBtn;
    public Button nextQuestionBtn;
    public Button applybtn;
    public int questionID = 1;
    public static ArrayList<Question> questions;
    RadioButton radioButton;
    //TODO: uncomment when the Score Page is connected
    int correctAnswers;


    public void onCreate(Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        Log.w( DA, "Inside DataActivity:onCreate\n" );
        questions = readQuestionBankFromCSVFile();
        setContentView( R.layout.activity_sub1);
        answersRadioButtonGroup = findViewById(RadioGroup.generateViewId());
        textView = findViewById(R.id.text_view_selected);
        Log.w(DA, "About to find questionText");
        questionText = findViewById(R.id.question_Text);
        Log.w(DA, "questionText set");
        Log.w(DA, "About to set radio button group");
        answersRadioButtonGroup = findViewById(R.id.answers_radio_btn_group);
        Log.w(DA, "answerradioButtonGroup set");
        Log.w(DA, "About to find answer1radioBtn");
        answer1RadioBtn = findViewById(R.id.answer1_radio_btn);
        Log.w(DA, "answer1radioBtn set");
        Log.w(DA, "About to find answer2radioBtn");
        answer2RadioBtn = findViewById(R.id.answer2_radio_btn);
        Log.w(DA, "answer2radioBtn set");
        Log.w(DA, "About to find answer3radioBtn");
        answer3RadioBtn = findViewById(R.id.answer3_radio_btn);
        Log.w(DA, "answer3radioBtn set");
        Log.w(DA, "About to find answer4radioBtn");
        answer4RadioBtn = findViewById(R.id.answer4_radio_btn);
        Log.w(DA, "answer4radioBtn set");


        Log.w(DA, "About to create listener for return to main button");
        returnToMainBtn = findViewById(R.id.return_to_main_btn);
        Log.w(DA, "Created the button, now setting listener");
        setQuestionPage(questions, questionID);
        returnToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMain(view);
            }
        });

        Log.w(DA, "Set the listener");
        Log.w(DA, "About to check the answer");

        applybtn = findViewById(R.id.apply_answr);
        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = answersRadioButtonGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String selectedAnswer = radioButton.getText().toString();
                textView.setText("Your choice: " + selectedAnswer);
                textView.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                for(Question question : questions) {
                    checkAnswer(question, selectedAnswer);

                }

            }
        });

        nextQuestionBtn = findViewById(R.id.next_question_btn);
        nextQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionID++;
                setQuestionPage(questions, questionID);

                if (questionID == questions.size()) {
                    createScoreButton();
                    goToScorePage();
                }



            }
        });
    }




    //TODO get this working with the radio group before score results page
    /*
      public void checkButton() {
            int radioId = answersRadioButtonGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioId);
            radioButton.setOnClickListener(new OnCliC);
            /*
            Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
                        Toast.LENGTH_SHORT).show();


        }
    */


    private ArrayList<Question> readQuestionBankFromCSVFile() {
        ArrayList<Question> questions = new ArrayList<>();

        InputStream inStrm = getResources().openRawResource(R.raw.black_history_questions_and_answer);
        BufferedReader bReader = new BufferedReader(
                new InputStreamReader(inStrm, Charset.defaultCharset()));
        try {
            bReader.readLine();
            String line;
            while ((line = bReader.readLine()) != null) {
                Question b = new Question(line);
                questions.add(b);
            }
            bReader.close();
        } catch (IOException e) {
            Log.wtf(ACTIVITY_TAG, "could not find internal resource. pretty bad.");
            e.printStackTrace();
        }
        return questions;
    }



    // set Question page
    public void setQuestionPage(ArrayList<Question> questions, int id) {

        Log.w(DA, "About to set questions");
        Log.w(DA, String.valueOf(questions.size()));
        Log.w(DA, "About to set question text");
        Log.w(DA, questions.get(id - 1).getQuestionText());
        questionText.setText(questions.get(id - 1).getQuestionText());
        Log.w(DA, "question text set");
        ArrayList<String> shuffledAnswers = shuffleAnswers(questions.get(id - 1));
        Log.w(DA, "About to set answer1radioBtn text");
        answer1RadioBtn.setText(shuffledAnswers.get(0));
        answer1RadioBtn.setChecked(false);
        Log.w(DA, "answer1radioBtn text set");
        Log.w(DA, "About to set answer2radioBtn text");
        answer2RadioBtn.setText(shuffledAnswers.get(1));
        answer2RadioBtn.setChecked(false);
        Log.w(DA, "answer2radioBtn text set");
        Log.w(DA, "About to set answer3radioBtn text");
        answer3RadioBtn.setText(shuffledAnswers.get(2));
        answer3RadioBtn.setChecked(false);
        Log.w(DA, "answer3radioBtn text set");
        Log.w(DA, "About to set answer4radioBtn text");
        answer4RadioBtn.setText(shuffledAnswers.get(3));
        answer4RadioBtn.setChecked(false);
        Log.w(DA, "answer4radioBtn text set");


    }

    public ArrayList<String> shuffleAnswers(Question question) {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.add(question.getWrongAnswer1());
        answers.add(question.getWrongAnswer2());
        answers.add(question.getWrongAnswer3());
        Collections.shuffle(answers);
        return answers;
    }

    
    public void createScoreButton() {
        nextQuestionBtn.setText("Get Score");

    }

    //TODO: uncomment when the Score Page is connected

    public boolean checkAnswer(Question question, String selectedAnswer) {
        return selectedAnswer == question.getCorrectAnswer();
    }



    //TODO: uncomment when the Score Page is connected

    public void goToScorePage() {

        nextQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScoreActivity(view);
            }
        });
    }







    public void goBackToMain(View v ) {
        this.finish( );
    }


    //TODO: uncomment when the Score Page is connected

    public void startScoreActivity(View v) {
        Intent myIntent = new Intent(this, ResultsActivity.class);
        this.startActivity(myIntent);


    }


    protected void onStart( ) {
        super.onStart( );
        Log.w( DA, "Inside DataActivity:onStart\n" );
    }

    protected void onRestart( ) {
        super.onRestart( );
        Log.w( DA, "Inside DataActivity:onReStart\n" );
    }

    protected void onResume( ) {
        super.onResume( );
        Log.w( DA, "Inside DataActivity:onResume\n" );
    }

    protected void onPause( ) {
        super.onPause( );
        Log.w( DA, "Inside DataActivity:onPause\n" );
    }

    protected void onStop( ) {
        super.onStop( );
        Log.w( DA, "Inside DataActivity:onStop\n" );
    }

    protected void onDestroy( ) {
        super.onDestroy( );
        Log.w( DA, "Inside DataActivity:onDestroy\n" );
    }


}


