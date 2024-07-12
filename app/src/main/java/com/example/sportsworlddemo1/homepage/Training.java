package com.example.sportsworlddemo1.homepage;
//菜單頁面
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;

import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.homepage.trainingpage.Training_chest;

public class Training extends AppCompatActivity {
    private ImageButton chest,back,leg,shoulder,core;
    ImageButton btn1,btn2,btn3,btn4,btn5,setting;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training);

        chest = (ImageButton) findViewById(R.id.btn_chest);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Training.this, Training_chest.class);
                startActivity(intent);
            }
        });
        back = (ImageButton) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Training.this,Training.class);
                startActivity(intent);
            }
        });
        shoulder = (ImageButton) findViewById(R.id.btn_shoulder);
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Training.this,Training.class);
                startActivity(intent);
            }
        });
        leg = (ImageButton) findViewById(R.id.btn_leg);
        leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Training.this,Training.class);
                startActivity(intent);
            }
        });
        core = (ImageButton) findViewById(R.id.btn_core);
        core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Training.this,Training.class);
                startActivity(intent);
            }
        });


        btn1 = findViewById(R.id.btn_reservation);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Training.this, Reservation1.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.btn_run);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Training.this, Running.class);
                startActivity(intent);
            }
        });

        btn3 = findViewById(R.id.btn_home);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Training.this, Home.class);
                startActivity(intent);
            }
        });

        btn5 = findViewById(R.id.btn_article);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Training.this, Article_food.class);
                startActivity(intent);
            }
        });

        setting = (ImageButton) findViewById(R.id.app_icon7);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Training.this,Setting.class);
                startActivity(intent);
            }
        });
    }
}
