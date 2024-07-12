package com.example.sportsworlddemo1.rehabilitation.anklepage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.R;

public class RehabilitationAnkleChessPress extends AppCompatActivity {

    private void openVideoLink() {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=xQb63rOAF5c");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rehabilitation_ankle_chesspress);

        ImageButton Ibtn1 = findViewById(R.id.imageButton);
        Ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RehabilitationAnkleChessPress.this);
                builder.setMessage("即將前往影片連結，是否前往？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                openVideoLink();
                            }
                        })
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // 用户点击"否"，不执行任何操作
                            }
                        });
                builder.create().show();
            }
        });
    }
}
