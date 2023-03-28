package com.example.datab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    EditText name,email;
    Button submit,data;
    String s;
    ArrayList<String>slist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.editTextTextPersonName2);
        email=(EditText) findViewById(R.id.editTextTextEmailAddress2);
        submit=(Button) findViewById(R.id.button3);
        data=(Button) findViewById(R.id.button4);


        DataHelper dataHelper=DataHelper.getDB(this);

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String n=name.getText().toString();
            String e=email.getText().toString();
            dataHelper.dataDao().addData(new Data(n,e));

        }
    });


        ArrayList<Data>list=(ArrayList<Data>) dataHelper.dataDao().getAll();
        for(int i=0;i<list.size();i++){
            s=(i+1)+" "+"Name:"+list.get(i).getName()+" "+"Email:"+list.get(i).getEmail();
            slist.add(i,s);
        }

    data.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Intent next;
            next=new Intent(MainActivity.this,MainActivity2.class);
            next.putExtra("list", slist);
            startActivity(next);


        }
    });





    }
}