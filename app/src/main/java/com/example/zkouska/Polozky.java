package com.example.zkouska;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polozky extends AppCompatActivity {

    ListView polozkylist;
    EditText nazevPolozky;
    Button addPolozka;
    public List<String> ListPolozek;
    ArrayAdapter<String> polozkyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polozky);




        polozkylist = findViewById(R.id.listpolozek);
        nazevPolozky = findViewById(R.id.addNazevPolozka);
        addPolozka = findViewById(R.id.pridatPolozku);

        ListPolozek = new ArrayList<>();
        polozkyAdapter = new ArrayAdapter<>(Polozky.this, android.R.layout.simple_list_item_1, ListPolozek);
        polozkylist.setAdapter(polozkyAdapter);

        polozkylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView text = (TextView) view;
                if(!text.getPaint().isStrikeThruText())
                {
                    text.setPaintFlags(text.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }else
                {
                    text.setPaintFlags(text.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
                polozkyAdapter.notifyDataSetChanged();
            }
        });

        polozkylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListPolozek.remove(position);
                polozkyAdapter.notifyDataSetChanged();
                return true;
            }
        });

        addPolozka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListPolozek.add(nazevPolozky.getText().toString());
                polozkyAdapter.notifyDataSetChanged();
            }
        });
    }
}