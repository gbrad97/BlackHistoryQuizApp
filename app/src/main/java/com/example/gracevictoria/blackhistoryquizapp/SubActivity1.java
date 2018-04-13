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

        super.onCreate(savedInstanceState);
        Log.w(DA, "Inside DataActivity:onCreate\n");

        returnToMainBtn = findViewById(R.id.return_to_main_btn);
        returnToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMain(view);
            }
        });

    }
   /* public void nextQuestion() {

        setContentView(R.layout.activity_sub1);
        @SuppressLint("WrongViewCast") final RadioButton question1 = (RadioButton) findViewById(R.id.question_Text);
        RadioButton answer1 = (RadioButton) findViewById(R.id.answer1_radio_btn);
        RadioButton answer2 = (RadioButton) findViewById(R.id.answer2_radio_btn);
        RadioButton answer3 = (RadioButton) findViewById(R.id.answer3_radio_btn);
        RadioButton answer4 = (RadioButton) findViewById(R.id.answer4_radio_btn);
        Button nxtbtn = new Button(this);
        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String x = MainActivity.questions.get(1).toString();
                question1.setText(x);
            }
        });
    }*/

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
