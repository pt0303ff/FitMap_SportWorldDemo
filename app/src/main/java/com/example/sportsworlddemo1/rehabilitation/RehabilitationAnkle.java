package com.example.sportsworlddemo1.rehabilitation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.rehabilitation.anklepage.RehabilitationAnkleChessPress;
import com.example.sportsworlddemo1.rehabilitation.anklepage.RehabilitationAnklePullUp;

public class RehabilitationAnkle extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rehabilitation_ankle);

        btn1 = findViewById(R.id.button11);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RehabilitationAnkle.this, RehabilitationAnkleChessPress.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.button12);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RehabilitationAnkle.this, RehabilitationAnklePullUp.class);
                startActivity(intent);
            }
        });
    }
}
