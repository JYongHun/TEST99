package com.jang.wellcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText pswd;
    EditText pswdChk;
    Button btn;
    Button login;
    String value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.email);
        pswd = (EditText)findViewById(R.id.pswd);
        pswdChk = (EditText)findViewById(R.id.pswdChk);
        btn = (Button)findViewById(R.id.btn);
        login = (Button)findViewById(R.id.login);

        SharedPreferences sp = getSharedPreferences("sp_prefs",MODE_PRIVATE);
        String value1 = sp.getString("email",null);
        value2 = sp.getString("pswd",null);

        if(value1 != null) {
            email.setText(value1);
        }

        if(value2 != null) {
            pswd.setText(value2);
            pswdChk.setText(value2);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value2.equals(pswd.getText().toString()) && value2.equals(pswdChk.getText().toString())) {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("pswd", pswd.getText().toString());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"비밀번호가 일치하지 않습ㄴ디ㅏ",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().contains("@")) {
                    Toast.makeText(MainActivity.this,"이메일을 올바르게 쓰시오",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pswd.getText().toString().isEmpty() || pswdChk.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                String a = pswd.getText().toString();
                String b = pswdChk.getText().toString();
                if (!(a.length() >= 6 && a.length() <= 12)) {
                    Toast.makeText(MainActivity.this, "비밀번호는 6자리 이상 12자리 이하로 입력받습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!a.equals(b)) {
                    Toast.makeText(MainActivity.this, "비밀번호를 확인하시오", Toast.LENGTH_SHORT).show();
                    return;
                }

                String data1 = email.getText().toString().trim();
                String data2 = pswd.getText().toString().trim();
                SharedPreferences sp = getSharedPreferences("sp_prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("email",data1);
                editor.putString("pswd",data2);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(),SelectIcon.class);
                intent.putExtra("name",email.getText().toString());
                intent.putExtra("boo",true);
                intent.putExtra("number",123);
                intent.putExtra("str","hello");
                startActivity(intent);
                finish();
            }
        });
    }
}
