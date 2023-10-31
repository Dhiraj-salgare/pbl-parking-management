package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class user_login extends AppCompatActivity {

    EditText username1,userpassword;
    public String username;
    public  String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        //intialised ID
        username1  = findViewById(R.id.userid);
        userpassword  = findViewById(R.id.userpassid);

    }


    public void sucess2(View view) {


        //fetching text from edit text

         username = username1.getText().toString();
         password = userpassword.getText().toString();


        Query query = FirebaseDatabase.getInstance().getReference("user")
                .orderByChild("email")
                .equalTo(username);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean emailAndPasswordMatch = false;

                for (DataSnapshot user1 : snapshot.getChildren()) {
                    String value = user1.child("password").getValue(String.class);

                    if (value.equals(password)) {
                        emailAndPasswordMatch = true;
                        Toast.makeText(user_login.this, "Login successfull", Toast.LENGTH_SHORT).show();
                        Intent ii = new Intent(user_login.this, userlogin_fun.class);
                        startActivity(ii);

                    } else {
                        Toast.makeText(user_login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
                if (emailAndPasswordMatch) {

                    Toast.makeText(user_login.this, "sucesss", Toast.LENGTH_SHORT).show();
                    // Email and password match in the database
                    // Do something here
                } else {
                    // No matching email and password found
                    Toast.makeText(user_login.this, "Wrong username", Toast.LENGTH_SHORT).show();
                }




        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
            });


    }
}