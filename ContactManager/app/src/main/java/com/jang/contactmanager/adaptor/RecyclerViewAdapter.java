package com.jang.contactmanager.adaptor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jang.contactmanager.Add;
import com.jang.contactmanager.MainActivity;
import com.jang.contactmanager.R;
import com.jang.contactmanager.data.DatabaseHandler;
import com.jang.contactmanager.model.Contact;

import java.util.ArrayList;


//마지막으로 어갭터에 우리가 만든 뷰홀더를 연결합니다.
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //멥버변수 셋팅
    Context context;
    ArrayList<Contact> contactList;

    //1. 생성자 만들기
    public RecyclerViewAdapter (Context context, ArrayList<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row, parent, false);
        // 리턴에 위에서 생성한 뷰를 뷰홀더에 담아서 리턴한다.
        return new ViewHolder(view);
    }

    // 리스트에 있는 데이터를 화면에ㅐ 있는 뷰에 표시하는 메소드
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        String name = contact.getName();
        String phone = contact.getPhoneNumber();
        int id = contact.getId();

        ((ViewHolder)holder).txtName.setText(name);
        ((ViewHolder)holder).txtPhone.setText(phone);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    //xml 화면에 있는 구성요소 (텍스트뷰, 이미지뷰, 등) 를 여기서 연결한다.
    public class ViewHolder extends RecyclerView.ViewHolder {
        //멥버변수
        public TextView txtName;
        public TextView txtPhone;
        public ImageView imgDelete;
        // 카드뷰 클릭하면 화면 넘어갈 수 있도록 멤버변수 셋팅
        public CardView cardView;

        public Contact conTemp;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            cardView = itemView.findViewById(R.id.cardView);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  .get() 괄호안 index getAdpterPsition() 으로 확인가능;
                    conTemp = contactList.get(getAdapterPosition());

                    Intent i = new Intent(context, Add.class);
                    i.putExtra("name",txtName.getText().toString());
                    i.putExtra("phone",txtPhone.getText().toString());
                    i.putExtra("id",conTemp.getId());
                    context.startActivity(i);
                    //Toast.makeText(context, ""+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    conTemp = contactList.get(getAdapterPosition());

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("삭제").setMessage("당신은 진짜 삭제?");

                    builder.setPositiveButton("삭제하다", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int id)
                        {
                            DatabaseHandler db = new DatabaseHandler(context);
                            Contact contact = db.getContact(conTemp.getId());
                            db.deleteContact(contact);


                            Toast.makeText(context, "삭제되었습니다", Toast.LENGTH_SHORT).show();

                            //방법1 데이터셋이 바꼈다는 것을 알려주는 메소드 실행
//                            contactList = db.getAllContacts();
//                            notifyDataSetChanged();
                            //방법2
                            ((MainActivity)context).refresh();


                        }
                    });

                    builder.setNegativeButton("취소다", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int id)
                        {
                            Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });


        }
    }
}
