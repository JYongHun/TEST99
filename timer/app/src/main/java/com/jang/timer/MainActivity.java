package com.jang.timer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView sc;
    EditText scInput;
    Button btnC;
    Button btnS;
    CountDownTimer countDT;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);
        sc = (TextView)findViewById(R.id.sc);
        scInput = (EditText)findViewById(R.id.scInput);
        btnC = (Button)findViewById(R.id.btnC);
        btnS = (Button)findViewById(R.id.btnS);



        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isRunning == true) {
                    Toast.makeText(MainActivity.this,"이미 실행중입니다",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (scInput.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this,"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                sc.setText(""+scInput.getText().toString());
                String temp1 = scInput.getText().toString() + "000";
                int temp2 = Integer.parseInt(temp1) + 1000;
                countDT = new CountDownTimer(temp2, 1000) {
                    public void onTick(long millisUntilFinished) {
                        isRunning = true;
                        Log.i("test",""+(((millisUntilFinished / 1000/60))));
                        if (millisUntilFinished / 1000 > 3600) {
                            sc.setText(millisUntilFinished / 1000/3600 +"시 " + (((millisUntilFinished / 1000/60)%60)) +"분 " + (millisUntilFinished / 1000)%60 + "초");
                        }else if (millisUntilFinished / 1000 > 60) {
                            sc.setText(millisUntilFinished / 1000/60 +"분 " + (millisUntilFinished / 1000)%60 + "초");
                        } else {
                            sc.setText(millisUntilFinished / 1000 +"초");
                        }
                    }

                    @Override
                    public void onFinish() {
                        isRunning = false;
                        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.alarm);
                        mediaPlayer.start();
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .repeat(5)
                                .playOn(img);
                    }
                }.start();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
                countDT.cancel();
                sc.setText("0초");
                scInput.setText("");
            }
        });





    }
}
