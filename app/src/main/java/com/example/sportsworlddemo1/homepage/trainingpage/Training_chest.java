package com.example.sportsworlddemo1.homepage.trainingpage;
//菜單頁面--練胸
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.example.sportsworlddemo1.R;

public class Training_chest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_chest);
    }

    public void cal_Onclick(View view) {
        //0522
        Intent intent = new Intent();
        intent.setClass(Training_chest.this, Training_chestedit.class);
        startActivity(intent);
        //0522
    }
}
