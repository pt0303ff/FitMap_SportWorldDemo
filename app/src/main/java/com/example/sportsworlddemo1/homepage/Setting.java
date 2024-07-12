package com.example.sportsworlddemo1.homepage;
//設定頁面
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.Login;
import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.Repair;
import com.example.sportsworlddemo1.homepage.settingpage.Personal;
import com.example.sportsworlddemo1.homepage.settingpage.Record;

public class Setting extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5;
    ImageButton btn1,btn2,btn3,btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Setting.this, Personal.class);

                startActivity(intent);
            }
        });
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Record.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
                builder.setTitle("確認登出");
                builder.setMessage("確定要登出吗？");
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 用户点击了“是”，显示成功登出提示，然后跳转到登录页面
                        Toast.makeText(Setting.this, "成功登出", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Setting.this, Login.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 用户点击了“否”，关闭对话框
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Repair.class);
                startActivity(intent);
            }
        });

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Rehabilitation.class);
                startActivity(intent);
            }
        });
/*
        btn1 = findViewById(R.id.btn_reservation);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Setting.this, Reservation1.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.btn_run);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Setting.this, Running.class);
                startActivity(intent);
            }
        });

        btn3 = findViewById(R.id.btn_home);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Setting.this, Running.class);
                startActivity(intent);
            }
        });

        btn4 = findViewById(R.id.btn_training);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Setting.this, Training.class);
                startActivity(intent);
            }
        });

        btn5 = findViewById(R.id.btn_article);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Setting.this, Article_food.class);
                startActivity(intent);
            }
        });

 */
    }
}
