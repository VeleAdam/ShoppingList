package com.example.zkouska;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity{

    ListView listview;
    Button addButton;
    //Button novySeznamButton;
    EditText GetNazev;


    String[] ListSeznamu = new String[] {
            "Lidl",
            "Albert",
            "UniHobby",
    };
     public List<String> ListElementsArrayList;
     ArrayAdapter<String> adapter;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listview = findViewById(R.id.listView1);
        addButton = findViewById(R.id.button1);
    //  novySeznamButton = findViewById(R.id.nsbutton);
        GetNazev = findViewById(R.id.addNazevText);



        ListElementsArrayList = new ArrayList<>(Arrays.asList(ListSeznamu));
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent seznam = new Intent(MainActivity.this, Polozky.class);
                startActivity(seznam);
            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListElementsArrayList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });


                //přidání seznamu
/*
        novySeznamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addObrazovka = new Intent(MainActivity.this, AddSeznamActivity.class);
                startActivity(addObrazovka);
            }
        });
*/
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListElementsArrayList.add(GetNazev.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });



    }



}