package com.example.sportsworlddemo1.homepage.trainingpage;
//菜單頁面--練胸編輯
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sportsworlddemo1.R;

import java.util.ArrayList;
public class Training_chestedit extends AppCompatActivity {

    EditText editText;
    Button addButton, deleteButton;
    LinearLayout rootView;
    ArrayList<String> sss = new ArrayList<String>();
    ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_chestedit);

        editText = findViewById(R.id.newsport); // 初始化editText
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        rootView = findViewById(R.id.rootView);

        addButton.setOnClickListener(addClickListener);
        deleteButton.setOnClickListener(deleteClickListener);

        // 下拉式選單
        Spinner spinner = findViewById(R.id.spinner1);
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sss) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                String item = getItem(position);
                String numberedItem = (position + 1) + ". " + item; // 加入编号
                textView.setText(numberedItem);
                return textView;
            }
        };
        spinner.setAdapter(spinnerAdapter);
    }

    private View.OnClickListener addClickListener = new View.OnClickListener() {
        int counter = 1; // 编号计数器

        @Override
        public void onClick(View v) {
            String value = editText.getText().toString();
            if (value.isEmpty()) {
                Toast.makeText(Training_chestedit.this, "請輸入數值", Toast.LENGTH_SHORT).show();
                return;
            }

            sss.add(value);
            spinnerAdapter.notifyDataSetChanged();

            String numberedValue = counter + ". " + value; // 加入编号
            counter++;

            TextView textView = new TextView(Training_chestedit.this);
            textView.setText(numberedValue);
            textView.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.gravity = Gravity.CENTER;
            textView.setLayoutParams(params);

            rootView.addView(textView);
        }
    };

    private View.OnClickListener deleteClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (sss.isEmpty()) {
                Toast.makeText(Training_chestedit.this, "沒有可刪除的數值", Toast.LENGTH_SHORT).show();
                return;
            }

            sss.remove(sss.size() - 1);
            spinnerAdapter.notifyDataSetChanged();

            rootView.removeViewAt(rootView.getChildCount() - 1);
        }
    };
}
