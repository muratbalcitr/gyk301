package com.gyk.gyk;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class VoiceActivity extends AppCompatActivity {

    private Button buttonRecord, buttonPlay, buttonStop;
    private MediaRecorder mediaRecorder;
    private String recordedFile;
    private final int MY_PERMISSIONS_RECORD_AUDIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        buttonRecord = findViewById(R.id.buttonRecord);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonStop = findViewById(R.id.buttonStop);

        buttonPlay.setEnabled(false);
        buttonStop.setEnabled(false);

        recordedFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, MY_PERMISSIONS_RECORD_AUDIO);
        } else {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);//çıkış formatı
            mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            mediaRecorder.setOutputFile(recordedFile);
        }
        buttonRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                    buttonRecord.setEnabled(false);
                    buttonPlay.setEnabled(false);
                    buttonStop.setEnabled(true);

                    //Toast.makeText(VoiceActivity.this,"kayt başladı",Toast.LENGTH_LONG).show();
                    Toast.makeText(VoiceActivity.this, "Kayıt başladı.", Toast.LENGTH_SHORT).show();
                } catch (IllegalStateException ise) {
                    ise.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
                buttonStop.setEnabled(false);
                buttonPlay.setEnabled(true);
                Toast.makeText(VoiceActivity.this, "Kayıt işlemi tamamlandı.", Toast.LENGTH_SHORT).show();
            }
        });


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(recordedFile);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Toast.makeText(VoiceActivity.this, "Ses çalınıyor.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
