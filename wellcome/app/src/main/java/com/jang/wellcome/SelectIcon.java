package com.jang.wellcome;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SelectIcon extends AppCompatActivity implements View.OnClickListener {

    Button btnM1;
    Button btnM2;
    Button btnR;
    ImageView img;
    boolean imgChk = false;
    String getString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_icon);

        getString = getIntent().getStringExtra("name");
//        int number = getIntent().getIntExtra("number",0);
//        boolean boo = getIntent().getBooleanExtra("boo",false);
//        String hello = getIntent().getStringExtra("str");


        Log.i("TESTETSET",getString);
        btnM1 = (Button)findViewById(R.id.btnM1);
        btnM2 = (Button)findViewById(R.id.btnM2);
        btnR = (Button)findViewById(R.id.btnR);
        img = (ImageView)findViewById(R.id.img);

        btnM1.setOnClickListener(this);
        btnM2.setOnClickListener(this);
        btnR.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v==btnM1) {
            imgChk = true;
            img.setImageResource(R.drawable.bunny);
        } else if (v == btnM2) {
            imgChk = true;
            img.setImageResource(R.drawable.turtle);
        } else if (v == btnR) {
            if (imgChk) {
                AlertDialog.Builder Builder = new AlertDialog.Builder(this);

                Builder.setTitle("회원가입 완료")
                        .setMessage("완료하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent intent = new Intent(SelectIcon.this, Result.class);
                                intent.putExtra("email",getString);
                                startActivityForResult(intent, 1);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                finish();
                            }
                        });

                AlertDialog dialog = Builder.create();    // 알림창 객체 생성
                dialog.show();    // 알림창 띄우기
            } else {
                Toast.makeText(SelectIcon.this,"이미지를 반드시 체크하세요",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
