package com.aurelion.tawfiqapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditUser extends AppCompatActivity implements View.OnClickListener {

    Button del,edit;
    EditText log,pas;
    MyApplication context;
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        context = (MyApplication)this.getApplicationContext();
        Intent intent =getIntent();
        ID = intent.getIntExtra("id",-1);
        del = findViewById(R.id.btnDelete);
        edit = findViewById(R.id.btnEdit);
        log = findViewById(R.id.txtLogin2);
        pas = findViewById(R.id.txtPass2);
        del.setOnClickListener(this);
        edit.setOnClickListener(this);
        User u = context.getUser(ID);
        log.setText(u.getLogin());
        pas.setText(u.getPass());

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnDelete:
                    context.deleteUser(ID);
                break;
            case R.id.btnEdit:
                context.updateUser(ID,log.getText().toString(),pas.getText().toString());
                break;
        }
    }
}