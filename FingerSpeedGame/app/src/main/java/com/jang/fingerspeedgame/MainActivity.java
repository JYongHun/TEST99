package com.jang.fingerspeedgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView time;
    TextView score;
    Button btn;
    TextView btn2;

    int sc = 0;

    boolean chk;
    boolean cht = true;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2 = (TextView)findViewById(R.id.btn2);

        loadActivity();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cht) {
                    cht = false;
                } else {
                    cht = true;
                }
            }
        });
    }
    private void loadActivity() {
        chk = true;

        time = (TextView)findViewById(R.id.time);
        score = (TextView)findViewById(R.id.score);
        btn = (Button)findViewById(R.id.btn);



        sc = 100;
        score.setText(""+sc);
        new CountDownTimer(50000, 1000) {

            public void onTick(long millisUntilFinished) {

                time.setText(""+millisUntilFinished / 1000);
                final long a = millisUntilFinished / 1000;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (chk) {
                            if (cht) {
                                sc = sc - 1;
                            } else {
                                sc = sc - 10;
                            }
                            score.setText("" + sc);
                            if (sc < 1) {
                                score.setText(""+0);
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setTitle("성공");
                                builder.setMessage("기록은 : " + a + "\n 다시 도전?");
                                builder.setPositiveButton("예",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(getApplicationContext(),"예를 선택했습니다.",Toast.LENGTH_LONG).show();
                                                loadActivity();
                                            }
                                        });
                                builder.setNegativeButton("아니오",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                finish();
                                            }
                                        });
                                builder.show();
                                cancel();
                                //btn.setEnabled(false);
                            }
                        }
                    }
                });
            }

            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("실패");
                builder.setMessage("다시 도전?");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"예를 선택했습니다.",Toast.LENGTH_LONG).show();
                                loadActivity();
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                builder.show();


                time.setText("done!");
                //btn.setEnabled(false);
                chk = false;
                Toast.makeText(MainActivity.this,"시간 종료",Toast.LENGTH_SHORT).show();
                builder.setCancelable(false);
            }
        }.start();
    }
}
