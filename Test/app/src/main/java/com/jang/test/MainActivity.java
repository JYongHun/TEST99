package com.jang.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button);
        final EditText edtxt = (EditText)findViewById(R.id.editText);
        txt = (TextView)findViewById(R.id.age);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtxt.getText().toString().length() == 0) {
                    txt.setText("입력해이새기야");

                } else {
                    if (isNumber(edtxt.getText().toString())) {

                        int c = Calendar.getInstance().get(Calendar.YEAR);
                        int d = Integer.parseInt(edtxt.getText().toString());
                        int e = c - d;

                        txt.setText("계산한 나이는 : " + e);
                        //txt.setText(Calendar.getInstance().get(Calendar.YEAR));
                        edtxt.setText("");
                    } else {
                        txt.setText("숫자만입력해이새기야");
                    }
                }
            }
        });
    }

    public static boolean isNumber(String str) {
        boolean result = false;


        try {
            Double.parseDouble(str);
            result = true;
        } catch (Exception e) {
        }


        return result;
    }
}
