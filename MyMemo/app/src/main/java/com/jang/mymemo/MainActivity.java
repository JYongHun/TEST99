package com.jang.mymemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jang.mymemo.adaptor.RecyclerViewAdapter;
import com.jang.mymemo.data.DatabaseHandler;
import com.jang.mymemo.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnMemo;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Contact> contactArrayList;

    EditText searchTxt;
    ImageView searchBtn;
    ImageView searchDel;

    RequestQueue requestQueue;
    ArrayList<Contact> contactList;

    public static final String URL = "http://dummy.restapiexample.com/api/v1/employees"; // 상수는 무조건 대문자
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        //JsonObejectRequest
        // http 프로토콜의 get 메소드 설정
        // 요청할 URL
        // 요청할때 필요한 json
        // 서버로부터 정상적 응답시
        // 서버로부투 응답 에러발생시
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        String value = response.getString("status");

                        JSONArray jArray3 = response.getJSONArray("data");
                        for (int i = 0; i<jArray3.length();i++) {
                            JSONObject object3 = jArray3.getJSONObject(i);
                            int id = object3.getInt("id");
                            String employee_name = object3.getString("employee_name");
                            String employee_salary = object3.getString("employee_salary");
                            String employee_age = object3.getString("employee_age");
                            String profile_image = object3.getString("profile_image");
                            Contact contact = new Contact();
                            contact.setId(id);
                            contact.setName(employee_name);
                            contact.setContent(employee_age);
                            contactList.add(contact);
                        }




                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //Log.i("empppppppppppppp", "result" + response.toString());
                    //Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        requestQueue.add(jsonObjectRequest);




        // volley 라이브러리의 RequestQueue 클래스를 객체로 생성한다
//        RequestQueue rq = Volley.newRequestQueue(MainActivity.this);
//        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, URL, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            String userId = response.getString("status");
//                            String id = response.getString("success");
//                            String title = response.getString("data");
//                            Log.i("PPAP", "AAAAA"+userId);
//                            Log.i("PPAP", "AAAAA"+id);
//                            Log.i("PPAP", "AAAAA"+title);
//                        }catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // 서버가 문제가 생겨서 정상적으로 동작하지 않을때
//                // 이메소드가 호출됩니다.
//                // error 변수에 왜 에러가 났는지 데이터가 들어있음.
//                //txt.setText("server eErOr!!");
//                Log.i("Parsing", "error : " + error.toString());
//            }
//        });
//        rq.add(jor);



        btnMemo = (Button)findViewById(R.id.btnMemo);

        searchTxt = (EditText)findViewById(R.id.searchTxt);
        searchBtn = (ImageView)findViewById(R.id.searchBtn);
        searchDel = (ImageView)findViewById(R.id.searchDel);

        searchDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTxt.setText("");
            }
        });

        //리사이클러뷰 연결하고 기본적인 셋팅
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true); //
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //데이터베이스에서 테이블에 저장된 데이터 읽어서 어레이리스트에 저장
//        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
//        contactArrayList = db.getAllContacts();
//
//        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
//        recyclerView.setAdapter(recyclerViewAdapter);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });

        btnMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddMemo.class);
                startActivity(i);
            }
        });



        // Text가 바뀌고 동작할 코드
//        searchTxt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // Text가 바뀌기 전 동작할 코드
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // Text가 바뀌고 동작할 코드
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                DatabaseHandler db = new DatabaseHandler(MainActivity.this);
//                contactArrayList = db.getAllContacts(searchTxt.getText().toString().trim());
//
//                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
//                recyclerView.setAdapter(recyclerViewAdapter);
//            }
//        });
    }

    public void onResume() {
        super.onResume();


//        recyclerView = findViewById(R.id.recylerView);
//        recyclerView.setHasFixedSize(true); //
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//
//        //데이터베이스에서 테이블에 저장된 데이터 읽어서 어레이리스트에 저장
//        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
//        contactArrayList = db.getAllContacts();
//
//        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
//        recyclerView.setAdapter(recyclerViewAdapter);

//        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
//        ArrayList<Contact> contactList = db.getAllContacts();
//        for(Contact contact : contactList) {
//            Log.i("myDB","저장된 주소록의 데이터 id : " + contact.getId() +
//                    "이름은 : " + contact.getName());
//        }
    }

    public void refresh() {


        //데이터베이스에서 테이블에 저장된 데이터 읽어서 어레이리스트에 저장
//        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
//        contactArrayList = db.getAllContacts();
//
//        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
//        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
