package com.example.sportsworlddemo1;
//註冊頁面
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Register extends AppCompatActivity {
    EditText editUsername, editPassword, editPhone, editEmail,editHeight,editWeight;
    Button buttonRegister;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editPhone = findViewById(R.id.editPhone);
        editEmail = findViewById(R.id.editEmail);
        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);

        buttonRegister = findViewById(R.id.buttonRegister);
        textViewResult = findViewById(R.id.textViewResult);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();
                String height = editHeight.getText().toString().trim();
                String weight = editWeight.getText().toString().trim();


                if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty() || height.isEmpty() || weight.isEmpty())  {
                    textViewResult.setText("請填寫完整資訊");
                    return;
                }

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //模擬器 10.0.2.2
                            URL url = new URL("http://10.0.2.2/registerdemo1.php");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.setDoOutput(true);
                            connection.setDoInput(true);
                            connection.setUseCaches(false);
                            connection.connect();

                            String data = "username=" + URLEncoder.encode(username, "UTF-8")
                                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                                    + "&email=" + URLEncoder.encode(email, "UTF-8")
                                    + "&phone=" + URLEncoder.encode(phone, "UTF-8")
                                    + "&height=" + URLEncoder.encode(height, "UTF-8")
                                    + "&weight=" + URLEncoder.encode(weight, "UTF-8");

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
                                        if (result.trim().equals("註冊成功！")) {
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Intent intent = new Intent();
                                                    intent.setClass(Register.this, Login.class);
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
