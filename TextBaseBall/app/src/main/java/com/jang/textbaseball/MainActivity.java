package com.jang.textbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText num;
    Button btn;
    TextView chk;

    int a1;
    int a2;
    int a3;
    int a4;

//    int s1;
//    int s2;
//    int s3;
//    int s4;

    int st;
    int out;
    int ball;
    int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();

        a1 = random.nextInt(11);
        //lv = (ListView)findViewById(R.id.lv);
        num = (EditText)findViewById(R.id.num);
        btn = (Button)findViewById(R.id.btn);
        chk = (TextView)findViewById(R.id.chk);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt = cnt + 1;
                st = 0;
                ball = 0;
                out = 0;
                if (num.getText().length() != 4) {
                    Toast.makeText(getApplicationContext(),"4자입력", Toast.LENGTH_SHORT).show();
                }
                String[] data = num.getText().toString().split("");
                if (data[0].equals(Integer.toString(a1))) {
                    st = st + 1;
                }
                if (data[1].equals(Integer.toString(a2))) {
                    st = st + 1;
                }
                if (data[2].equals(Integer.toString(a3))) {
                    st = st + 1;
                }
                if (data[3].equals(Integer.toString(a4))) {
                    st = st + 1;
                }


                if (data[0].equals(Integer.toString(a2)) || data[0].equals(Integer.toString(a3)) || data[0].equals(Integer.toString(a4))) {
                    ball = ball + 1;
                }
                if (data[1].equals(Integer.toString(a1)) || data[1].equals(Integer.toString(a3)) || data[1].equals(Integer.toString(a4))) {
                    ball = ball + 1;
                }
                if (data[2].equals(Integer.toString(a1)) || data[2].equals(Integer.toString(a2)) || data[2].equals(Integer.toString(a4))) {
                    ball = ball + 1;
                }
                if (data[3].equals(Integer.toString(a1)) || data[3].equals(Integer.toString(a2)) || data[3].equals(Integer.toString(a3))) {
                    ball = ball + 1;
                }

                out = 4 - (st + ball);

//                for(int i=0;data.length>i;i++) {
//                    if(data[])
//                }
//
//                if (!data[0].equals(Integer.toString(a1)) || !data[0].equals(Integer.toString(a2)) || !data[0].equals(Integer.toString(a3)) || !data[0].equals(Integer.toString(a4))) {
//                    out = out + 1;
//                }
//                if (!data[1].equals(Integer.toString(a1)) || !data[1].equals(Integer.toString(a2)) || !data[1].equals(Integer.toString(a3)) || !data[1].equals(Integer.toString(a4))) {
//                    out = out + 1;
//                }
//                if (!data[2].equals(Integer.toString(a1)) || !data[2].equals(Integer.toString(a2)) || !data[2].equals(Integer.toString(a3)) || !data[2].equals(Integer.toString(a4))) {
//                    out = out + 1;
//                }
//                if (!data[3].equals(Integer.toString(a1)) || !data[3].equals(Integer.toString(a2)) || !data[3].equals(Integer.toString(a3)) || !data[3].equals(Integer.toString(a4))) {
//                    out = out + 1;
//                }

                //chk.setText();
                chk.setText(chk.getText().toString() +"\n 시도 : "+ cnt +"    S :" + st + ", B :" + ball + ", O :" + out + "   내번호:" + num.getText().toString());

                if (st == 4) {
                    chk.setText(chk.getText().toString() +"\n 성공");
                }
            }
        });

        while (true) {
            int temp;
            a1 = 1+random.nextInt(9);
            temp = 1+random.nextInt(9);
            if (a1 != temp) {
                a2 = temp;
            }

            temp = 1+random.nextInt(9);
            if (a1 != temp && a2 != temp) {
                a3 = temp;
            }

            temp = 1+random.nextInt(9);
            if (a1 != temp && a2 != temp && a3 != temp) {
                a4 = temp;
                return;
            }

        }
    }
}
