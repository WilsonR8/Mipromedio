package com.will.mipromedio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView configbtn;
    private EditText nametxt;
    private TextView nextbtn;
    private ConstraintLayout bg;
    String colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        configbtn = findViewById(R.id.configbtn);
        nametxt = findViewById(R.id.nametxt);
        nextbtn = findViewById(R.id.nextbtn);
        bg= findViewById(R.id.bg);


        nextbtn.setOnClickListener(
                (v) -> {
                    String username = nametxt.getText().toString();
                    SharedPreferences morepreferences = getSharedPreferences("lockercolors",MODE_PRIVATE);
                    morepreferences.edit().putString("loksea",colores).apply();

                    Intent i = new Intent(this,mathactivity.class);
                    i.putExtra("username",username);
                    startActivity(i);



                });

        configbtn.setOnClickListener(
                (v) -> {

                    SharedPreferences preferences = getSharedPreferences("lockercolors",MODE_PRIVATE);
                    preferences.edit().putString("loksea",colores).apply();
                    Intent i = new Intent(this,Coloractivity.class);
                    startActivityForResult(i,10);



                });








    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(10, resultCode, data);

        if(requestCode==10 && resultCode==RESULT_OK){
            colores=data.getExtras().getString("colors");
            if(colores.equals("azul")){
                bg.setBackgroundColor(Color.rgb(22,226,245));
            }
        }

        if(requestCode==10 && resultCode==RESULT_OK){
            colores=data.getExtras().getString("colors");
            if(colores.equals("white")){
                bg.setBackgroundColor(Color.rgb(255,255,255));
            }
        }

        if(requestCode==10 && resultCode==RESULT_OK){
            colores=data.getExtras().getString("colors");
            if(colores.equals("black")){
                bg.setBackgroundColor(Color.rgb(000,000,000));
            }
        }



    };
}