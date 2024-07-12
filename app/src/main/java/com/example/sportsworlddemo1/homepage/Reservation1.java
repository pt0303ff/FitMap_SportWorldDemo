package com.example.sportsworlddemo1.homepage;
//預約頁面
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.reservationpage.Reservation2;

public class Reservation1 extends AppCompatActivity {
    ImageButton Ibtn1,Ibtn2,Ibtn3,Ibtn4,Ibtn5,setting;
    Button btn1,btn2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation1);
        //取得按鍵
        btn1 = findViewById(R.id.revise1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Reservation1.this, Reservation2.class);
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.reservation);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Reservation1.this, Reservation2.class);
                startActivity(intent);
            }
        });

        Ibtn2 = findViewById(R.id.btn_run);
        Ibtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Reservation1.this, Running.class);
                startActivity(intent);
            }
        });

        Ibtn3 = findViewById(R.id.btn_home);
        Ibtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Reservation1.this, Home.class);
                startActivity(intent);
            }
        });


        Ibtn4 = findViewById(R.id.btn_training);
        Ibtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Reservation1.this, Training.class);
                startActivity(intent);
            }
        });

        Ibtn5 = findViewById(R.id.btn_article);
        Ibtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Reservation1.this, Article_food.class);
                startActivity(intent);
            }
        });

        setting = (ImageButton) findViewById(R.id.app_icon7);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Reservation1.this,Setting.class);
                startActivity(intent);
            }
        });
    }
}
