package com.gyk.gyk;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonListView, buttonImage, buttonVoice, buttonMap,btnLife;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonListView = findViewById(R.id.buttonListview);
        buttonImage = findViewById(R.id.buttonImage);
        buttonVoice = findViewById(R.id.buttonVoice);
        buttonMap = findViewById(R.id.buttonMap);
        btnLife=findViewById(R.id.btnLife);
        btnLife.setOnClickListener(this);
        buttonListView.setOnClickListener(this);
        buttonImage.setOnClickListener(this);
        buttonVoice.setOnClickListener(this);
        buttonMap.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonListview:
                startActivity(new Intent(MainActivity.this, CustomListViewActivity.class));
                break;
            case R.id.buttonImage:
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
                break;
            case R.id.buttonVoice:
                requestRecordPermissionGranted();
                break;
            case R.id.buttonMap:
                startActivity(new Intent(MainActivity.this, MapActivity.class));
                break;
            case R.id.btnLife:
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                break;
        }
    }

    public void requestRecordPermissionGranted(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO},
                    10);

        } else {
            requestWESPermissionGranted();
        }
    }
    public void requestWESPermissionGranted(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    11);

        } else {
            goToVoiceActivity();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestWESPermissionGranted();
            }else{
                //User denied Permission.
            }
        }
        if (requestCode == 11) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                goToVoiceActivity();
            }else{
                //User denied Permission.
            }
        }
    }

    public void goToVoiceActivity(){
        startActivity(new Intent(MainActivity.this, VoiceActivity.class));
    }
}
