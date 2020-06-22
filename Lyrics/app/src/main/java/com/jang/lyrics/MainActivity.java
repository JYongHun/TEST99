package com.jang.lyrics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView singer;
    TextView sing;
    Button btn;
    TextView txt;

    String requestUrl = "https://api.lyrics.ovh/v1/";
    String temp;
    String iy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singer = (TextView)findViewById(R.id.singer);
        sing = (TextView)findViewById(R.id.sing);
        btn = (Button)findViewById(R.id.btn);
        txt = (TextView)findViewById(R.id.txt);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (singer.getText().toString().length() == 0 || sing.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this,"가수와 노래제목을 정확히 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                temp = requestUrl + singer.getText().toString() + "/" + sing.getText().toString();
                Log.i("song",temp);
                // volley 라이브러리의 RequestQueue 클래스를 객체로 생성한다
                RequestQueue rq = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, temp, null,
                        new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            iy = response.getString("lyrics");
                            txt.setText(iy);
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 서버가 문제가 생겨서 정상적으로 동작하지 않을때
                        // 이메소드가 호출됩니다.
                        // error 변수에 왜 에러가 났는지 데이터가 들어있음.
                        txt.setText("server eErOr!!");
                    }
                });
                rq.add(jor);

                temp = "";
            }
        });
    }
}
