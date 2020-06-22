package com.jang.wellcome;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        onBackPressed();

        String gI = getIntent().getStringExtra("email");
        Toast.makeText(getApplicationContext(),gI +"님 회원가입을 축하합니다",Toast.LENGTH_SHORT).show();
        tv = (TextView)findViewById(R.id.textView3);

        tv.setText(gI + "님 회원가입을 축하합니다.");
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //moveTaskToBack(true);
    }
}
