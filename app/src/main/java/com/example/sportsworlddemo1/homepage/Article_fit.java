package com.example.sportsworlddemo1.homepage;
//文章瘦身類

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.homepage.articlepage.Fit2;

public class Article_fit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Fitness");
        setContentView(R.layout.article_fit);

        Button food = (Button) findViewById(R.id.food);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Article_fit.this, Article_food.class);
                startActivity(intent);
            }
        });

        Button fit1 = (Button) findViewById(R.id.fit1);

        fit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(Article_fit.this, Article_fit.class);
                startActivity(intent1);
            }
        });

        Button fit2 = (Button) findViewById(R.id.fit2);

        fit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(Article_fit.this, Fit2.class);
                startActivity(intent2);
            }
        });

        Button fit3 = (Button) findViewById(R.id.fit3);

        fit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                intent3.setClass(Article_fit.this, Article_fit.class);
                startActivity(intent3);
            }
        });

        Button fit4 = (Button) findViewById(R.id.fit4);

        fit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent();
                intent4.setClass(Article_fit.this, Article_fit.class);
                startActivity(intent4);
            }
        });

        Button fit5 = (Button) findViewById(R.id.fit5);

        fit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent();
                intent5.setClass(Article_fit.this, Article_fit.class);
                startActivity(intent5);
            }
        });
    }
}
