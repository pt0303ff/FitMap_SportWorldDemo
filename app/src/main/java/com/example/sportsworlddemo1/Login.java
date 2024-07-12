package com.example.sportsworlddemo1;
//登入頁面
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.sportsworlddemo1.homepage.Home;
import com.example.sportsworlddemo1.homepage.Running;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Login extends AppCompatActivity{
    EditText editUsername, editPassword;
    Button buttonLogin;
    TextView textViewResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button nextPageLogin = findViewById(R.id.buttonLogin);
        Button nextPageRegister = findViewById(R.id.buttonregister);

        nextPageRegister.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(Login.this, Register.class);
            startActivity(intent);
        });


        editUsername = findViewById(R.id.l_editUsername);
        editPassword = findViewById(R.id.l_editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewResult = findViewById(R.id.textViewResult);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    textViewResult.setText("請填寫完整資訊");
                    return;
                }

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //模擬器 10.0.2.2
                            URL url = new URL("http://10.0.2.2/logindemo1.php");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.setDoOutput(true);
                            connection.setDoInput(true);
                            connection.setUseCaches(false);
                            connection.connect();

                            String data = "username=" + URLEncoder.encode(username, "UTF-8")
                                    + "&password=" + URLEncoder.encode(password, "UTF-8");

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
                                        if (result.trim().equals("登入成功 3秒後切換進入主頁")) {
                                            // 登入成功時切換頁面
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Intent intent = new Intent(Login.this, Home.class);
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
