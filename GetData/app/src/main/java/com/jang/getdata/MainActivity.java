package com.jang.getdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editData;
    TextView txtMsg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editData = findViewById(R.id.editData);
        txtMsg = findViewById(R.id.txtMsg);
        btn = findViewById(R.id.btn);


        //버튼 클릭하면, 에디트 텍스트의 내용을 가져와서 sharedPreferences 에 저장
        // SharedPreferences란 ? 안드로이드에서 제공하는 폰에 데이터 저장하는 방법
        SharedPreferences sp = getSharedPreferences("sp_prefs",MODE_PRIVATE);
        String value = sp.getString("msg",null);

        if(value != null) {
            txtMsg.setText(value);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editData.getText().toString().trim();
                SharedPreferences sp = getSharedPreferences("sp_prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("msg",data);
                editor.putInt("msg2",100);
                editor.apply();

            }
        });
    }
}
