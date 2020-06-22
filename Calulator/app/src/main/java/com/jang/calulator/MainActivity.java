package com.jang.calulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ing;
    TextView result;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;

    Button bP;
    Button bM;
    Button bG;
    Button bN;
    Button bR;
    Button bC;

    int all;
    int where;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ing = findViewById(R.id.ing);
        result = findViewById(R.id.result);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);

        bP = findViewById(R.id.bP);
        bM = findViewById(R.id.bM);
        bG = findViewById(R.id.bG);
        bN = findViewById(R.id.bN);
        bR = findViewById(R.id.bR);
        bC = findViewById(R.id.bC);

        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==b1){
                    ing.setText(ing.getText().toString()+1);
                }
                else if(v==b2){
                    ing.setText(ing.getText().toString()+2);
                }
                else if(v==b3){
                    ing.setText(ing.getText().toString()+3);
                }
                else if(v==b4){
                    ing.setText(ing.getText().toString()+4);
                }
                else if(v==b5){
                    ing.setText(ing.getText().toString()+5);
                }
                else if(v==b6){
                    ing.setText(ing.getText().toString()+6);
                }
                else if(v==b7){
                    ing.setText(ing.getText().toString()+7);
                }
                else if(v==b8){
                    ing.setText(ing.getText().toString()+8);
                }
                else if(v==b9){
                    ing.setText(ing.getText().toString()+9);
                }
                else if(v==b0){
                    ing.setText(ing.getText().toString()+0);
                }


                else if(v==bP){
                    // 더하기 부분
                    all = Integer.valueOf(ing.getText().toString().trim());
                    ing.setText("");
                    where =1;
                }

                else if(v==bM){
                    // 빼기 부분
                    all = Integer.valueOf(ing.getText().toString().trim());
                    ing.setText("");
                    where =2;
                }

                else if(v==bG){
                    // 곱하기 부분
                    all = Integer.valueOf(ing.getText().toString().trim());
                    ing.setText("");
                    where =3;
                }

                else if(v==bN){
                    // 나누기 부분
                    all = Integer.valueOf(ing.getText().toString().trim());
                    ing.setText("");
                    where =4;
                }



                //결과부분
                else if(v==bR) {

                    //더하기
                    if (where == 1) {
                        all = all + Integer.valueOf(ing.getText().toString().trim());
                        ing.setText(Integer.toString(all));
                    }
                    //빼기
                    else if (where == 2) {
                        all = all - Integer.valueOf(ing.getText().toString().trim());
                        ing.setText(Integer.toString(all));
                    }
                    //곱하기
                    else if (where == 3) {
                        all = all * Integer.valueOf(ing.getText().toString().trim());
                        ing.setText(Integer.toString(all));
                    }
                    //나누기
                    else if (where == 4) {
                        all = all / Integer.valueOf(ing.getText().toString().trim());
                        ing.setText(Integer.toString(all));
                    }
                }

                else if(v==bC){
                    ing.setText("");
                }
            }
        };

        b1.setOnClickListener(cl);
        b2.setOnClickListener(cl);
        b3.setOnClickListener(cl);
        b4.setOnClickListener(cl);
        b5.setOnClickListener(cl);
        b6.setOnClickListener(cl);
        b7.setOnClickListener(cl);
        b8.setOnClickListener(cl);
        b9.setOnClickListener(cl);
        b0.setOnClickListener(cl);
        bP.setOnClickListener(cl);
        bM.setOnClickListener(cl);
        bG.setOnClickListener(cl);
        bN.setOnClickListener(cl);
        bR.setOnClickListener(cl);
        bC.setOnClickListener(cl);

    }
}
