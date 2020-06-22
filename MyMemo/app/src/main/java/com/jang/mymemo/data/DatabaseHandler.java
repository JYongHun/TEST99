package com.jang.mymemo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.jang.mymemo.model.Contact;
import com.jang.mymemo.util.Util;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        //x, 이름, null, 버전
        super(context, Util.DATABASE_NAME,null, Util.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //테이블 생성문
        String CREATE_CONCAT_TABLE = "CREATE TABLE contacts" +
                "(" + Util.KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                Util.KEY_NAME + " TEXT, " +
                Util.KEY_CONTENT + " TEXT)";


        // CREATE TABLE CONTACTS (
        // ID INTERGER NOT NULL AUTO_INCREMENT PRIMARY KEY
        // NAME TEXT
        // PHONE_NUMBER TEXT);

        //쿼리 실행
        db.execSQL(CREATE_CONCAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE " + Util.TABLE_NAME;
        db.execSQL(DROP_TABLE);

        //테이블 다시 생성
        onCreate(db);
    }

    //주소 저장하는 메소드 : 오버라이딩이 아니라, 우리가 만들어줘야 하는 메소드
    public void addContact(Contact contact) {
        // 1. 주소를 저장하기 위해서, wirtable db를 가져온다
        SQLiteDatabase db = this.getWritableDatabase();
        // 2. db에 저장하기 위해서는, ContentValues를 이용한다
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME,contact.getName());
        values.put(Util.KEY_CONTENT,contact.getContent());

        //3. db에 실제로 저장한다
        db.insert(Util.TABLE_NAME,null,values);
        db.close();
    }

    //주소 1개 가져오는 메소드 : 우리가 만들어줘야하는 메소드
    // SELECT * FROM contacts WHERE id = 21;
    public Contact getContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        //데이터를 셀렉트(조회) 할때는, Cursor 를 이용해야 한다
        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[] {"id", "name", "content"},
                Util.KEY_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        int selectedId = Integer.parseInt(cursor.getString(0));
        String selectedName = cursor.getString(1);
        String selectedContent = cursor.getString(2);

        //db에서 읽어온 데이터를 자바 클래스로 처리한다.
        Contact contact = new Contact();
        contact.setId(selectedId);
        contact.setName(selectedName);
        contact.setContent(selectedContent);

        return contact;
    }

    public ArrayList<Contact> getAllContacts() {
        //비어 있는 어레이 리스트를 먼저 한개 만든다.
        // 데이터베이스에 select (조회) 해서,
        // 여러개의 데이터를 루프돌면서 Contact 클래스에 정보를 하나씩 담고
        // 위의 빈 어레이리스트에 하나씩 추가를 시킨다.

        ArrayList<Contact> contactList = new ArrayList<>();

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAll,null);

        if (cursor.moveToFirst()) {
            do {
                int selectedId = Integer.parseInt(cursor.getString(0));
                String selectedName = cursor.getString(1);
                String selectedPhoneNumber = cursor.getString(2);

                //db에서 읽어온 데이터를 자바 클래스로 처리한다.
                Contact contact = new Contact();
                contact.setId(selectedId);
                contact.setName(selectedName);
                contact.setContent(selectedPhoneNumber);

                contactList.add(contact);

            }while (cursor.moveToNext());
        }
        return contactList;
    }

    public ArrayList<Contact> getAllContacts(String content) {
        //비어 있는 어레이 리스트를 먼저 한개 만든다.
        // 데이터베이스에 select (조회) 해서,
        // 여러개의 데이터를 루프돌면서 Contact 클래스에 정보를 하나씩 담고
        // 위의 빈 어레이리스트에 하나씩 추가를 시킨다.

        ArrayList<Contact> contactList = new ArrayList<>();

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME + " WHERE content LIKE '%"+content+"%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAll,null);

        if (cursor.moveToFirst()) {
            do {
                int selectedId = Integer.parseInt(cursor.getString(0));
                String selectedName = cursor.getString(1);
                String selectedPhoneNumber = cursor.getString(2);

                //db에서 읽어온 데이터를 자바 클래스로 처리한다.
                Contact contact = new Contact();
                contact.setId(selectedId);
                contact.setName(selectedName);
                contact.setContent(selectedPhoneNumber);

                contactList.add(contact);

            }while (cursor.moveToNext());
        }
        return contactList;
    }

    //데이터를 업데이트
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_CONTENT, contact.getContent());

        //데이터 베이스 업데이트
        //UPDATE contacts SET name = "홍길동", phone= "010-5124-1251"
        // WHERE 조건..
        int ret = db.update(Util.TABLE_NAME,
                values,
                Util.KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
        return ret;
    }

    //데이터 삭제
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,
                Util.KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    //테이블의 저장된 주소록 데이터의 전체 갯수를 리턴
    public int getCount() {

        String countQuery = "SELECT COUNT(*) FROM " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        db.close();

        return count;
    }
}
