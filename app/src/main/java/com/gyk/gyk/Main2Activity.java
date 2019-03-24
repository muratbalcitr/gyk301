package com.gyk.gyk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("log1","onStart calisti");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("log1","onStop calisti");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("log1","onDestroy calisti");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("log1","onPause calisti");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("log1","onResume calisti");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("log1","onCreate calisti");
    }
}
