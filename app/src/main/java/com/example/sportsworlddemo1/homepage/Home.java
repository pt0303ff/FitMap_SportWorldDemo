package com.example.sportsworlddemo1.homepage;
//主頁
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.R;

import java.util.Calendar;

public class Home extends AppCompatActivity {

    ImageButton btn1,btn2,btn3,btn4,btn5,setting;
    private Button checkInButton;
    private TextView checkInStatusTextView;
    private CalendarView calendarView;
    private boolean isCheckedIn = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        //取得按鍵

        btn1 = findViewById(R.id.btn_reservation);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Home.this, Reservation1.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.btn_run);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Home.this, Running.class);
                startActivity(intent);
            }
        });

        btn4 = findViewById(R.id.btn_training);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Home.this, Training.class);
                startActivity(intent);
            }
        });

        btn5 = findViewById(R.id.btn_article);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Home.this, Article_food.class);
                startActivity(intent);
            }
        });

        setting = (ImageButton) findViewById(R.id.app_icon7);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Home.this,Setting.class);
                startActivity(intent);
            }
        });

        checkInButton = findViewById(R.id.button16);
        checkInStatusTextView = findViewById(R.id.textView23);
        calendarView = findViewById(R.id.calendarView);

        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        checkInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCheckedIn) {
                    // 进行签到操作
                    performCheckIn();
                } else {
                    Toast.makeText(Home.this, "你已经签过到了！", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 设置 CalendarView 显示今天日期
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // 在这里处理日期选择的事件
                // year: 选择的年份
                // month: 选择的月份 (注意：从 0 开始计数，所以实际月份需要加 1)
                // dayOfMonth: 选择的日期

                // 更新选择日期的签到状态
                updateCheckInStatus(year, month, dayOfMonth);

                // 使用你的行事历库或 API 获取选定日期的事件或提醒内容
                String eventContent = getEventContent(year, month + 1, dayOfMonth); // 示例：调用自定义方法获取事件内容

                // 在此处显示事件内容
                Toast.makeText(getApplicationContext(), eventContent, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void performCheckIn() {
        // 执行签到逻辑

        // 更新签到状态和文本显示
        isCheckedIn = true;
        checkInStatusTextView.setText("已签到");
        checkInStatusTextView.setTextColor(Color.GREEN);
    }

    private boolean isDateCheckedIn(int year, int month, int dayOfMonth) {
        // 这里是示例逻辑，你需要根据实际需求来实现

        // 假设已经保存了签到记录的年、月、日
        int savedYear = 2023;
        int savedMonth = 5; // 月份从0开始计数，5代表6月
        int savedDayOfMonth = 28;

        // 检查指定日期是否与保存的签到记录日期匹配
        return (year == savedYear && month == savedMonth && dayOfMonth == savedDayOfMonth);
    }

    private void updateCheckInStatus(int year, int month, int dayOfMonth) {
        // 根据选择日期更新签到状态

        // 检查选择日期是否是签到过的日期
        boolean isCheckIn = isDateCheckedIn(year, month, dayOfMonth);

        if (isCheckIn) {
            isCheckedIn = true;
            checkInStatusTextView.setText("已签到");
            checkInStatusTextView.setTextColor(Color.GREEN);

            // 设置选择日期的圆圈颜色为红色
            calendarView.setDateTextAppearance(calendarView.getDateTextAppearance() + R.style.CheckedInDate);
        } else {
            isCheckedIn = false;
            checkInStatusTextView.setText("未签到");
            checkInStatusTextView.setTextColor(Color.RED);

            // 设置选择日期的圆圈颜色为蓝色
            calendarView.setDateTextAppearance(calendarView.getDateTextAppearance() + R.style.DefaultDate);
        }
    }

    // 自定义方法：根据日期获取事件内容
    private String getEventContent(int year, int month, int dayOfMonth) {
        // 在这里实现具体的获取事件内容的逻辑
        // 可以使用行事历库、API、数据库等方式来获取事件内容

        // 示例：返回硬编码的事件内容
        return "日期：" + year + "-" + month + "-" + dayOfMonth + "\n事件内容：这是一个示例事件";

    }
}
