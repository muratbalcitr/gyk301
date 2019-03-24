package com.gyk.gyk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        final EditText etLat = findViewById(R.id.etLat);
        final EditText etLong = findViewById(R.id.etLong);

        Button buttonMap = findViewById(R.id.buttonMap);

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lat = etLat.getText().toString();
                String lon = etLong.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+lat + ","+lon));
                startActivity(intent);
            }
        });
    }
}
