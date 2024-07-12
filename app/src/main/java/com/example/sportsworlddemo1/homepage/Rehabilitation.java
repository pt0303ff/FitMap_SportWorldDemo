package com.example.sportsworlddemo1.homepage;
//復健首頁
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.rehabilitation.RehabilitationAnkle;

public class Rehabilitation extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rehabilitation);

        btn1 = findViewById(R.id.button7);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Rehabilitation.this, RehabilitationAnkle.class);
                startActivity(intent);
            }
        });
    }
}
