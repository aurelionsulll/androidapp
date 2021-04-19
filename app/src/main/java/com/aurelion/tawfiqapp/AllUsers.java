package com.aurelion.tawfiqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class AllUsers extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;
    Realm realm;
    List<User> users;
    MyApplication context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        context = (MyApplication) this.getApplicationContext();
        realm = Realm.getDefaultInstance();
        list = findViewById(R.id.usersList);
        users = new ArrayList<>();
        users.addAll(context.getUsers());
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
//        list.setOnItemClickListener();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(AllUsers.this, EditUser.class);
        intent.putExtra("id", users.get(position).getId());
        startActivity(intent);

    }
}
