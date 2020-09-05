package com.will.mipromedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class mathactivity extends AppCompatActivity {

    private EditText pparcial1txt;
    private EditText pparcial2txt;
    private EditText quicestxt;
    private EditText parcial1txt;
    private EditText parcial2txt;
    private TextView mathbtn;
    private ConstraintLayout bg3;
    private String colores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathactivity);

        String username = getIntent().getExtras().getString("username");

        pparcial1txt=findViewById(R.id.pparcial1txt);
        pparcial2txt=findViewById(R.id.pparcial2txt);
        quicestxt=findViewById(R.id.quicestxt);
        parcial1txt=findViewById(R.id.parcial1txt);
        parcial2txt=findViewById(R.id.parcial2txt);
        mathbtn=findViewById(R.id.mathbtn);
        bg3=findViewById(R.id.bg3);

        SharedPreferences otherpreference = getSharedPreferences("lockercolors",MODE_PRIVATE);
        colores= otherpreference.getString("loksea","nonaspri");

        if(colores.equals("azul")){
            bg3.setBackgroundColor(Color.rgb(22,226,245));
        }

        if(colores.equals("white")){
            bg3.setBackgroundColor(Color.rgb(255,255,255));
        }

        if(colores.equals("black")){
            bg3.setBackgroundColor(Color.rgb(000,000,000));
        }



        mathbtn.setOnClickListener(
                (v) -> {
                    String o = pparcial1txt.getText().toString();
                    String t = pparcial2txt.getText().toString();
                    String th= quicestxt.getText().toString();
                    String f = parcial1txt.getText().toString();
                    String fv = parcial2txt.getText().toString();
                    Integer a= Integer.valueOf(o);
                    Integer b= Integer.valueOf(t);
                    Integer c= Integer.valueOf(th);
                    Integer d= Integer.valueOf(f);
                    Integer e= Integer.valueOf(fv);

                    int z= (a+b+c+d+e)/5;

                    String sum = Integer.toString(z);


                    SharedPreferences addpreferences = getSharedPreferences("lockercolors",MODE_PRIVATE);
                    addpreferences.edit().putString("loksea",colores).apply();
                    Intent i = new Intent(this,resultactivity.class);
                    i.putExtra("username",username);
                    i.putExtra("sum",sum);
                    startActivity(i);



                });





    }
}