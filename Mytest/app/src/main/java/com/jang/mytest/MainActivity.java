package com.jang.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle;
    EditText name;
    EditText tel;

    ImageView imgCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = (TextView)findViewById(R.id.txtTitle);
        name = (EditText)findViewById(R.id.name);
        tel = (EditText)findViewById(R.id.tel);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("버튼클릭", " 버튼클릭할");
                //txtTitle.setText("test");
                //name.getText();
                //txtTitle.setText(name.getText());
                Toast.makeText(getApplicationContext(),
                        "이름 : " + name.getText() + "\n" +
                                "전화번호 :"+ tel.getText(), Toast.LENGTH_SHORT).show();

                imgCenter.setImageResource(R.mipmap.woman);
            }
        });
    }
}
