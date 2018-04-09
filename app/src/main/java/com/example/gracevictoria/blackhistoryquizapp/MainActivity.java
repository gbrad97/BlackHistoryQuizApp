package com.example.gracevictoria.blackhistoryquizapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String ACTIVITY_TAG = "MainActivity";
    public Button startQuizBtn;
    private FragmentManager fragMgr;
    public static ArrayList<Question> questions;
    public static Question selectedQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startQuizBtn = findViewById(R.id.start_btn);
        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSubordinate(view);
            }
        });
    }
    public void goToSubordinate(View v ) {
        Intent myIntent = new Intent( this, SubActivity1.class );
        this.startActivity( myIntent );
    }

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

    protected void onStart( ) {
        super.onStart( );
        Log.w(ACTIVITY_TAG, "Inside MainActivity:onStart\n" );
    }

    protected void onRestart( ) {
        super.onRestart( );
        Log.w(ACTIVITY_TAG, "Inside MainActivity:onReStart\n" );
    }

    protected void onResume( ) {
        super.onResume( );
        Log.w(ACTIVITY_TAG, "Inside MainActivity:onResume\n" );
    }

    protected void onPause( ) {
        super.onPause( );
        Log.w(ACTIVITY_TAG, "Inside MainActivity:onPause\n" );
    }

    protected void onStop( ) {
        super.onStop( );
        Log.w(ACTIVITY_TAG, "Inside MainActivity:onStop\n" );
    }

    protected void onDestroy( ) {
        super.onDestroy( );
        Log.w(ACTIVITY_TAG, "Inside MainActivity:onDestroy\n" );
    }
}
