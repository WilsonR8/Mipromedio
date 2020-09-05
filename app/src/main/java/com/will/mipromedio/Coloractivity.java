package com.will.mipromedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Coloractivity extends AppCompatActivity {
    private TextView bluebtn;
    private TextView whitebtn;
    private TextView blackbtn;
    private String colores;
    private ConstraintLayout bg2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloractivity);

        bluebtn=findViewById(R.id.bluebtn);
        whitebtn=findViewById(R.id.whitebtn);
        blackbtn=findViewById(R.id.blackbtn);
        bg2=findViewById(R.id.bg2);

        SharedPreferences otherpreference = getSharedPreferences("lockercolors",MODE_PRIVATE);
        colores= otherpreference.getString("loksea","nonaspri");

            if(colores.equals("azul")){
                bg2.setBackgroundColor(Color.rgb(22,226,245));
            }

            if(colores.equals("white")){
                bg2.setBackgroundColor(Color.rgb(255,255,255));
            }

            if(colores.equals("black")){
                bg2.setBackgroundColor(Color.rgb(000,000,000));
            }



        bluebtn.setOnClickListener(
                (v) -> {
                    Intent i= new Intent();
                    i.putExtra("colors","azul");
                    setResult(RESULT_OK,i);
                    finish();


                });

        whitebtn.setOnClickListener(
                (v) -> {
                    Intent w= new Intent();
                    w.putExtra("colors","white");
                    setResult(RESULT_OK,w);
                    finish();


                });

        blackbtn.setOnClickListener(
                (v) -> {
                    Intent b= new Intent();
                    b.putExtra("colors","black");
                    setResult(RESULT_OK,b);
                    finish();


                });





    }
}