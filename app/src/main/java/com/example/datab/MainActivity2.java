package com.example.datab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    ArrayList<String>list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView= findViewById(R.id.list);
//        Intent intent=getIntent();
//        ArrayList<Data> list = (ArrayList<Data>) intent.getSerializableExtra("list");
//        ArrayAdapter<Data>adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,list);
//        listView.setAdapter(adapter);


        list = (ArrayList<String>) getIntent().getSerializableExtra("list");

        ArrayAdapter<String>adapter=new ArrayAdapter<>(getApplicationContext(), R.layout.individual_list,R.id.textView,list);
        listView.setAdapter(adapter);

    }
}