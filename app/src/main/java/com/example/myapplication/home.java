package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void adlgn(View view) {
        Intent i=new Intent(home.this, Adminlogin.class);
        startActivity(i);
    }

    public void usreg(View view) {
        Intent i=new Intent(home.this, Register_user.class);
        startActivity(i);

    }

    public void uslgn(View view) {
        Intent i=new Intent(home.this, user_login.class);
        startActivity(i);
    }
}