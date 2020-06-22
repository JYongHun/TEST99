package com.jang.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //우리 눈에는 oncreate 함수만 있지만,
    // 실제로는 onCreate -> onStart -> onResume 안드로이가 실행시킴
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn;
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);//액티비티 띄우기
            }
        });

        Log.i("MyLife","1. onCreate 함수");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MyLife", "2. onStart 함수 호촐");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MyLife", "3. onResume 함수 호촐");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MyLife", "4. onPause 함수 호촐");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MyLife", "5. onStop 함수 호촐");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MyLife", "6. onStart 함수 호촐");
    }
}
