package com.example.atividade05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToList(View view){
        EditText textAdd = (EditText) findViewById(R.id.addName);
        String name = textAdd.getText().toString();
        if(!name.isEmpty()){
            Intent main = new Intent(MainActivity.this,ListActivity.class);
            main.putExtra("name",name);
            startActivity(main);
        }
    }
}