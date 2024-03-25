package com.example.atividade05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends Activity {
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Intent intent = getIntent();
        ListView list = (ListView) findViewById(R.id.list);

        ArrayList<String> names = new ArrayList<>();

        names.add("Nome 01");
        names.add("Nome 02");
        names.add("Nome 03");
        names.add("Nome 04");
        names.add("Nome 05");
        names.add(intent.getStringExtra("name"));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this,"Clicou em"+ names.get(i),Toast.LENGTH_SHORT).show();

            }
        });

        EditText search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (ListActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void onBack(View view){
        Intent main = new Intent(ListActivity.this,MainActivity.class);
        startActivity(main);
    }
}
