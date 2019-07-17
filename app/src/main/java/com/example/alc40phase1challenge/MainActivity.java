package com.example.alc40phase1challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alc_btn;
    private Button profile_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alc_btn = (Button) findViewById(R.id.bnAboutAlc);
        profile_btn = (Button) findViewById(R.id.bnMyProfile);

        alc_btn.setOnClickListener(this);
        profile_btn.setOnClickListener(this);
    }





    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bnAboutAlc:
                startActivity(new Intent(MainActivity.this, ActivityB.class));
                break;
            case R.id.bnMyProfile:
                startActivity(new Intent(MainActivity.this, ActivityC.class));
                break;

                default:
                    break;


        }

    }
}
