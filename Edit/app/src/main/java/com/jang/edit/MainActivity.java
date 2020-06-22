package com.jang.edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        // Text가 바뀌고 동작할 코드
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Text가 바뀌기 전 동작할 코드
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Text가 바뀌고 동작할 코드
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 입력받은 값에 100을 곱한다
                int changeValue = Integer.parseInt(editText.getText().toString()) * 100;
                textView.setText(changeValue+""); // 위에서 얻은 변경된값을 textView에 표시한다
            }
        });
    }
}