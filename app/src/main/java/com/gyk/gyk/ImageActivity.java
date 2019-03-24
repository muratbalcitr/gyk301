package com.gyk.gyk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class ImageActivity extends AppCompatActivity {

    // for photo
    ImageView imageView;

    // for video
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Button buttonPhoto = findViewById(R.id.btnPhoto);
        Button buttonVideo = findViewById(R.id.btnVideo);
        Button buttonPlay = findViewById(R.id.buttonPlay);

        imageView = findViewById(R.id.ivCamera);
        videoView = findViewById(R.id.videoView);

        // please stop there.. I am here now.

        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 21);
            }
        });

        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(intent, 22);
                }
            }
        });


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode==21){
                Bitmap bitmap = (Bitmap) data.getExtras().get(("data"));
                imageView.setImageBitmap(bitmap);
            }else if (requestCode == 22){
                Uri videoUri = data.getData();
                videoView.setVideoURI(videoUri);
            }
        }

    }
}
