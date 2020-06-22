package com.jang.contactmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.jang.contactmanager.data.DatabaseHandler;
import com.jang.contactmanager.model.Contact;

public class Add extends AppCompatActivity {

    EditText name;
    EditText phone;
    Button btnAdd;

    String getName;
    String getPhone;
    int getId;
    int getPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        //카드뷰 클릭하면 화면 넘어갈 수 있도록, 멤버 변수 셋팅

        getName = getIntent().getStringExtra("name");
        getPhone = getIntent().getStringExtra("phone");
        getId = getIntent().getIntExtra("id",-1);

        if (getId == -1) {
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseHandler db = new DatabaseHandler(Add.this);

                    if (name.getText().toString().trim().length() == 0 && phone.getText().toString().trim().length() == 0) {
                        Toast.makeText(Add.this,"입력해야지 저장가능", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Contact new_contact = new Contact();
                    new_contact.setName(name.getText().toString().trim());
                    new_contact.setPhoneNumber(phone.getText().toString().trim());

                    db.addContact(new_contact);

                    Toast.makeText(Add.this,"잘 저장되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        } else {
            name.setText(getName);
            phone.setText(getPhone);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (name.getText().toString().trim().length() == 0 && phone.getText().toString().trim().length() == 0) {
                        Toast.makeText(Add.this,"입력해야지 저장가능", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    DatabaseHandler db = new DatabaseHandler(Add.this);

                    Contact update_contact = new Contact();
                    update_contact.setName(name.getText().toString().trim());
                    update_contact.setPhoneNumber(phone.getText().toString().trim());
                    update_contact.setId(getId);

                    db.updateContact(update_contact);

                    Toast.makeText(Add.this, "잘 수정되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }
}
