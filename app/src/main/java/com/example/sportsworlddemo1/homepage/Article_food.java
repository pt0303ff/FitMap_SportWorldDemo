package com.example.sportsworlddemo1.homepage;
//文章食物類
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.homepage.articlepage.Food2;

public class Article_food extends AppCompatActivity{
    ImageButton btn1,btn2,btn3,btn4,btn5,setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Food");
        setContentView(R.layout.article_food);

        Button fitness = (Button) findViewById(R.id.fitness);

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Article_food.this, Article_fit.class);
                startActivity(intent);


            }
        });

        Button food1 = (Button) findViewById(R.id.food1);
        food1.setText("链接文章的文字");
        food1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.im.tku.edu.tw/tw/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);



            }
        });

        Button food2 = (Button) findViewById(R.id.food2);

        food2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(Article_food.this, Food2.class);
                startActivity(intent2);


            }
        });

        Button food3 = (Button) findViewById(R.id.food3);

        food3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                intent3.setClass(Article_food.this, Article_food.class);
                startActivity(intent3);


            }
        });

        Button food4 = (Button) findViewById(R.id.food4);

        food4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent();
                intent4.setClass(Article_food.this, Article_food.class);
                startActivity(intent4);


            }
        });

        Button food5 = (Button) findViewById(R.id.food5);

        food5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent();
                intent5.setClass(Article_food.this, Article_food.class);
                startActivity(intent5);


            }
        });

        btn1 = findViewById(R.id.btn_reservation);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Article_food.this, Reservation1.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.btn_run);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Article_food.this, Running.class);
                startActivity(intent);
            }
        });

        btn3 = findViewById(R.id.btn_home);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Article_food.this, Running.class);
                startActivity(intent);
            }
        });

        btn4 = findViewById(R.id.btn_training);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Article_food.this, Training.class);
                startActivity(intent);
            }
        });

        setting = (ImageButton) findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Article_food.this,Setting.class);
                startActivity(intent);
            }
        });


    }
}
