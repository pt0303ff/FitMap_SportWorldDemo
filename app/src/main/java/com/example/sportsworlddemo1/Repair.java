package com.example.sportsworlddemo1;
//設定頁面--報修
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportsworlddemo1.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Repair extends AppCompatActivity {
    EditText editNo, editDescription;
    Button buttonSubmit;
    TextView textViewResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repair);

        editNo = findViewById(R.id.r_id);
        editDescription = findViewById(R.id.r_description);
        buttonSubmit = findViewById(R.id.r_send);
        textViewResult = findViewById(R.id.r_textViewResult);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eNo = editNo.getText().toString().trim();
                String description = editDescription.getText().toString().trim();

                if (eNo.isEmpty() || description.isEmpty()) {
                    textViewResult.setText("請填寫完整資訊");
                    return;
                }

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL("http://10.0.2.2/repairdemo1.php");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.setDoOutput(true);
                            connection.setDoInput(true);
                            connection.setUseCaches(false);
                            connection.connect();

                            String data = "eNo=" + URLEncoder.encode(eNo, "UTF-8")
                                    + "&description=" + URLEncoder.encode(description, "UTF-8")
                                    ;

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
                                //TODO id重複 無法傳輸
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textViewResult.setText(result);
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
