package com.example.sportsworlddemo1.homepage.settingpage;
//設定頁面--個人
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.Login;
import com.example.sportsworlddemo1.R;
import com.example.sportsworlddemo1.Register;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Personal extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_personal);

        EditText editUsername, editPassword, editPhone, editEmail;
        Button UpdateButton;
        TextView Result;

        editUsername = findViewById(R.id.editText1);
        editPassword = findViewById(R.id.editText3);
        editPhone = findViewById(R.id.editText2);
        editEmail = findViewById(R.id.editText4);

        UpdateButton = findViewById(R.id.UpdateButton);
        Result = findViewById(R.id.result);
        //editUsername.setEnabled(false); // 设置为不可编辑

        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();



                if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty())  {
                    Result.setText("請填寫完整資訊");
                    return;
                }

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //模擬器 10.0.2.2
                            URL url = new URL("http://10.0.2.2/personaldemo1.php");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.setDoOutput(true);
                            connection.setDoInput(true);
                            connection.setUseCaches(false);
                            connection.connect();

                            String data = "username=" + URLEncoder.encode(username, "UTF-8")
                                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                                    + "&email=" + URLEncoder.encode(email, "UTF-8")
                                    + "&phone=" + URLEncoder.encode(phone, "UTF-8");


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
                                        Result.setText(result);
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
                                    Result.setText(error);
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