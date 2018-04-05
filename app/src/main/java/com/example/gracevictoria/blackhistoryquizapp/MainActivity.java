package com.example.gracevictoria.blackhistoryquizapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String ACTIVITY_TAG = "MainActivity";
    private FragmentManager fragMgr;
    public static ArrayList<Body> questions;
    public static Body selectedBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToSubordinate(View v ) {
        Intent myIntent = new Intent( this, SubActivity1.class );
        this.startActivity( myIntent );
    }

    private ArrayList<Body> readQuestionBankFromCSVfile() {
        ArrayList<Body> bodies = new ArrayList<>();

        InputStream inStrm = getResources().openRawResource(R.raw.black_history_questions_and_answer);
        BufferedReader bReader = new BufferedReader(
                new InputStreamReader(inStrm, Charset.defaultCharset()));
        try {
            bReader.readLine();
            String line;
            while ((line = bReader.readLine()) != null) {
                Body b = new Body(line);
                bodies.add(b);
            }
            bReader.close();
        } catch (IOException e) {
            Log.wtf(ACTIVITY_TAG, "could not find internal resource. pretty bad.");
            e.printStackTrace();
        }

        return bodies;
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
