package com.will.mipromedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class resultactivity extends AppCompatActivity {

    private TextView mathagainbtn;
    private TextView notetxt;
    private TextView avaragetxt;
    private String colores;
    private ConstraintLayout bg4;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultactivity);

        String username = getIntent().getExtras().getString("username");
        String sum = getIntent().getExtras().getString("sum");


        mathagainbtn=findViewById(R.id.mathagainbtn);
        notetxt=findViewById(R.id.notetxt);
        avaragetxt=findViewById(R.id.avaragetxt);
        bg4=findViewById(R.id.bg4);

        SharedPreferences otherpreference = getSharedPreferences("lockercolors",MODE_PRIVATE);
        colores= otherpreference.getString("loksea","nonaspri");

        if(colores.equals("azul")){
            bg4.setBackgroundColor(Color.rgb(22,226,245));
        }

        if(colores.equals("white")){
            bg4.setBackgroundColor(Color.rgb(255,255,255));
        }

        if(colores.equals("black")){
            bg4.setBackgroundColor(Color.rgb(000,000,000));
        }


        notetxt.setText("Hola"+" "+username+" "+",tu promedio es");
        avaragetxt.setText(sum);


        mathagainbtn.setOnClickListener(
                (v) -> {


                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                });

    }
}