package com.aurelion.tawfiqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText login,pass;
    Button btnLogin,btnNew;
    Realm realm;
    MyApplication context;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = (MyApplication) this.getApplicationContext();
        login = findViewById(R.id.txtLogin);
        pass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnNew = findViewById(R.id.btnNew);

        btnLogin.setOnClickListener(this);
        btnNew.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnLogin:
                int id = context.login(login.getText().toString(),pass.getText().toString());
                if(id!=-1){
                    Intent i = new Intent(MainActivity.this,AllUsers.class);
                    startActivity(i);
                }else{
                    System.out.println("error login");
                    Toast.makeText(getApplicationContext(),"erroo",Toast.LENGTH_LONG);
                }

                break;
            case R.id.btnNew:
                context.ajouter(login.getText().toString(),pass.getText().toString());
                System.out.println("good");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}