package com.example.convid_19selfscreeningtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HivActivity extends AppCompatActivity {

    Button mHivCloseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiv);

        mHivCloseBtn = findViewById(R.id.hivCloseBtn);


        mHivCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hivIntent = new Intent(HivActivity.this, MainActivity.class);
                startActivity(hivIntent);
                finish();
            }
        });

    }
}
