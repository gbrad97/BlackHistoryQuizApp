package com.example.gracevictoria.blackhistoryquizapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by winstonparris on 3/29/18.
 */

public class SubActivity1 extends Activity {
    public static final String DA = "MainActivity";
    public Button returnToMainBtn;

    public void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        Log.w( DA, "Inside DataActivity:onCreate\n" );
        Question bc = new Question("black_history_questions_and_answer.csv");
        returnToMainBtn = findViewById(R.id.return_to_main_btn);
        returnToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMain(view);
            }
        });

        setContentView( R.layout.activity_sub1);
    }

    public void goBackToMain(View v ) {
        this.finish( );
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
