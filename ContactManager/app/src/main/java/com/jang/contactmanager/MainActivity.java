package com.jang.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jang.contactmanager.adaptor.RecyclerViewAdapter;
import com.jang.contactmanager.data.DatabaseHandler;
import com.jang.contactmanager.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Contact> contactArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);

        //리사이클러뷰 연결하고 기본적인 셋팅
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true); //
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //데이터베이스에서 테이블에 저장된 데이터 읽어서 어레이리스트에 저장
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        contactArrayList = db.getAllContacts();

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);



        //데이터를 저장
//        Contact new_contact = new Contact();
//        new_contact.setName("Jeremy");
//        new_contact.setPhoneNumber("010-1223-4567");
//
//        db.addContact(new_contact);

        //저장된 데이터를불러오기
//        ArrayList<Contact> contactList = db.getAllContacts();
//        for(Contact contact : contactList) {
//            Log.i("myDB","저장된 주소록의 데이터 id : " + contact.getId() +
//                    "이름은 : " + contact.getName());
//        }
//
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Add.class);
                startActivity(i);
            }
        });
//
//        Log.i("count",""+db.getCount());


//        Contact contact = db.getContact(1);
//        Log.i("myDB","아이디2번데이터" + contact.getName());
//
//        db.deleteContact(contact);


    }

    public void onResume() {
        super.onResume();


        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true); //
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //데이터베이스에서 테이블에 저장된 데이터 읽어서 어레이리스트에 저장
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        contactArrayList = db.getAllContacts();

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

//        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
//        ArrayList<Contact> contactList = db.getAllContacts();
//        for(Contact contact : contactList) {
//            Log.i("myDB","저장된 주소록의 데이터 id : " + contact.getId() +
//                    "이름은 : " + contact.getName());
//        }
    }

    public void refresh() {


        //데이터베이스에서 테이블에 저장된 데이터 읽어서 어레이리스트에 저장
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        contactArrayList = db.getAllContacts();

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
