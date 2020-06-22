package com.jang.pcal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText enPer;
    EditText enNum;
    TextView result;
    Button btn;
    float a;
    float b;
    float c;

    int d = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enNum = (EditText)findViewById(R.id.enNum);
        enPer = (EditText)findViewById(R.id.enPer);
        result = (TextView) findViewById(R.id.result);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (d != 5) {
                    d = d+1;
                    if (enNum.getText().length() == 0 || enPer.getText().length() == 0) {
                        Toast.makeText(getApplicationContext(),"입력하세요",Toast.LENGTH_SHORT).show();
                    } else {
                        a = Float.valueOf(enNum.getText().toString());
                        b = Float.valueOf(enPer.getText().toString());
                        c = a*b/100;


                        result.setText(""+c);
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("에러남 종료");
                    builder.setMessage("FBI OPEN UP");
                    builder.setPositiveButton("종료해", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    builder.show();


                }
            }
        });

    }
}
