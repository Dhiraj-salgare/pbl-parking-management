package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.UUID;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_user extends AppCompatActivity {

    Button reg;
    EditText name1,email1,password1,vehical1,contact1,confpassword1;
    DatabaseReference database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://parking-management-20465-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        //intialised ID

        name1 = findViewById(R.id.nameid);
        email1 = findViewById(R.id.emailid);
        password1= findViewById(R.id.passid);
        vehical1 = findViewById(R.id.vehicleid);
        contact1 = findViewById(R.id.contactid);
        confpassword1 = findViewById(R.id.confpassid);
        reg = findViewById(R.id.regid);




        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // creating UUID
                UUID uuid1 = UUID.randomUUID();
                String uuid = uuid1.toString();

                // Fetching data from edittext

                String name = name1.getText().toString();
                String email = email1.getText().toString();
                String contact = contact1.getText().toString();
                String password = password1.getText().toString();
                String vehical = vehical1.getText().toString();
                String confpassword = confpassword1.getText().toString();


                if(email.isEmpty() || password.isEmpty() || contact.isEmpty() || name.isEmpty() || vehical.isEmpty())
                {
                    Toast.makeText(Register_user.this, "enter the name and email", Toast.LENGTH_SHORT).show();
                }else if(password.equals(confpassword))
                {
                    database.child("user").child(uuid).child("name").setValue(name);
                    database.child("user").child(uuid).child("email").setValue(email);
                    database.child("user").child(uuid).child("phone").setValue(contact);
                    database.child("user").child(uuid).child("password").setValue(password);
                    database.child("user").child(uuid).child("vehicalNo").setValue(vehical);
                    Toast.makeText(Register_user.this, "User registration successfull", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(Register_user.this, home.class);
                    startActivity(intent);

                }else
                {
                    Toast.makeText(Register_user.this, "password does not match", Toast.LENGTH_SHORT).show();
                }





            }
        });


    }
}