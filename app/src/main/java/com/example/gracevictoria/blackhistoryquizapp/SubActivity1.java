package com.example.gracevictoria.blackhistoryquizapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by winstonparris on 3/29/18.
 */

public class SubActivity1 {
    public static final String DA = "MainActivity";

    public void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        Log.w( DA, "Inside DataActivity:onCreate\n" );
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
