package com.example.sportsworlddemo1.reservationpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sportsworlddemo1.Login;
import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.Register;
import com.example.sportsworlddemo1.homepage.Reservation1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Reservation4 extends AppCompatActivity{
    Button btn1,btn2;
    EditText studentName,studentId,equipment1,eNo1,date1,time1;

    TextView textViewResult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation4);

        //在onCreate方法中初始化textViewResult
        textViewResult = findViewById(R.id.textViewResult);

        //取得按鍵
        btn1 = findViewById(R.id.Back);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Reservation4.this, Reservation3.class);
                startActivity(intent);
            }
        });
        //輸入值
        Bundle bundle = getIntent().getExtras();
        String e1 = bundle.getString("姓名" );
        TextView result1 = (TextView)findViewById(R.id.UserIDText3);
        result1.setText(e1);

        String e2 = bundle.getString("學號" );
        TextView result2 = (TextView)findViewById(R.id.UserIDText5);
        result2.setText(e2);

        String e3 = bundle.getString("器材" );
        TextView result3 = (TextView)findViewById(R.id.UserIDText7);
        result3.setText(e3);
        String e4 = bundle.getString("編號" );
        TextView result4 = (TextView)findViewById(R.id.UserIDText9);
        result4.setText(e4);

        //0522
        String d1 = bundle.getString("日期" );
        TextView result5 = (TextView)findViewById(R.id.UserIDText11);
        result5.setText(d1);
        //0522
        if (bundle != null) {
            String mSpn = bundle.getString("spinner");
            String mSpn1 = bundle.getString("spinner1");
            TextView result6 = (TextView)findViewById(R.id.UserIDText2);
            result6.setText(mSpn + " ~ " + mSpn1);
        }

        studentName=findViewById(R.id.UserIDText3);
        studentId = findViewById(R.id.UserIDText5);
        equipment1 = findViewById(R.id.UserIDText7);
        eNo1 = findViewById(R.id.UserIDText9);
        date1 = findViewById(R.id.UserIDText11);
        time1 = findViewById(R.id.UserIDText2);

        btn2 = findViewById(R.id.Confirm);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sname = studentName.getText().toString().trim();
                String sId = studentId.getText().toString().trim();
                String equipment = equipment1.getText().toString().trim();
                String eNo = eNo1.getText().toString().trim();
                String date = date1.getText().toString().trim();
                String time = time1.getText().toString().trim();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //模擬器 10.0.2.2
                            URL url = new URL("http://10.0.2.2/reservationdemo1.php");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.setDoOutput(true);
                            connection.setDoInput(true);
                            connection.setUseCaches(false);
                            connection.connect();

                            String data = "sname=" + URLEncoder.encode(sname, "UTF-8")
                                    + "&sId=" + URLEncoder.encode(sId, "UTF-8")
                                    + "&equipment=" + URLEncoder.encode(equipment, "UTF-8")
                                    + "&eNo=" + URLEncoder.encode(eNo, "UTF-8")
                                    + "&date=" + URLEncoder.encode(date, "UTF-8")
                                    + "&time=" + URLEncoder.encode(time, "UTF-8");

                            connection.getOutputStream().write(data.getBytes());

                            int responseCode = connection.getResponseCode();
                            if (responseCode == HttpURLConnection.HTTP_OK) {
                                InputStream inputStream = connection.getInputStream();
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
                                String box = "";
                                String line = null;
                                while ((line = bufferedReader.readLine()) != null) {
                                    box += line + "\n";
                                }
                                inputStream.close();
                                final String result = box;
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        textViewResult.setText(result);
                                        if (result.trim().equals("預約登記完成")) {
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Intent intent = new Intent();
                                                    intent.setClass(Reservation4.this, Reservation1.class);
                                                    startActivity(intent);
                                                }
                                            }, 3000);
                                        }
                                    }
                                });
                            } else {
                                throw new Exception("HTTP response code: " + responseCode);
                            }
                        } catch (Exception e) {
                            final String error = e.toString();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textViewResult.setText(error);
                                }
                            });
                        }
                    }
                });
                thread.start();
            }
        });

    }
}
