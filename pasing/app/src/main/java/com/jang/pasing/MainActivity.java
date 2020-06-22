package com.jang.pasing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String url = "https://jsonplaceholder.typicode.com/todos/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // volley 라이브러리의 RequestQueue 클래스를 객체로 생성한다
        RequestQueue rq = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int userId = response.getInt("userId");
                            int id = response.getInt("id");
                            String title = response.getString("title");
                            boolean completed = response.getBoolean("completed");
                            Log.i("PPAP", "AAAAA"+userId);
                            Log.i("PPAP", "AAAAA"+id);
                            Log.i("PPAP", "AAAAA"+title);
                            Log.i("PPAP", "AAAAA"+completed);
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
                //txt.setText("server eErOr!!");
                Log.i("Parsing", "error : " + error.toString());
            }
        });
        rq.add(jor);

//        RequestQueue rq = Volley.newRequestQueue(MainActivity.this);
//        Log.i("54125156asd", "12431");
//        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//                @Override
//                public void onResponse(JSONObject response) {
//
//                    try {
//                        int userId = response.getInt("userId");
//                        int id = response.getInt("id");
//                        String title = response.getString("title");
//                        boolean completed = response.getBoolean("completed");
//                        Log.i("PPAP", "AAAAA"+userId);
//                        Log.i("PPAP", "AAAAA"+id);
//                        Log.i("PPAP", "AAAAA"+title);
//                        Log.i("PPAP", "AAAAA"+completed);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            },new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Log.i("gsagsdagsdg", "ERROR" + error.toString());
//                }
//            });
//        rq.add(jor);


    }
}