package com.example.ruchira.vresturant;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {


    FButton btnSignin,btnSignup;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignin=(FButton) findViewById(R.id.btnsignin);
        btnSignup=(FButton)findViewById(R.id.btnsignup);
        txtSlogan=findViewById(R.id.txtslogen);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/Narita-Monospace.otf");
        txtSlogan.setTypeface(typeface);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
