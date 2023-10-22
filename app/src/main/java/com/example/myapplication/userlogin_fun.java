package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class userlogin_fun extends AppCompatActivity{

    DrawerLayout dl2;
    NavigationView nv2;
    Toolbar tar2;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin_fun);

        dl2=findViewById(R.id.drawerlayout2);
        nv2=findViewById(R.id.nav2);
        tar2=findViewById(R.id.tool2);


        setSupportActionBar(tar2);
        nv2.bringToFront();
        nv2.setItemBackgroundResource(R.drawable.menu_color);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,dl2,tar2,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        dl2.addDrawerListener(toggle);
        toggle.syncState();



        //off deafult closing animation




        //nav item operation drawer menu
        nv2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            private MenuItem previousMenuItem = null;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                if (previousMenuItem != null) {
                    // Uncheck the previously selected item
                    previousMenuItem.setChecked(false);
                }

                int id = menuItem.getItemId();

                if (id == R.id.item11) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame2, new user_home())
                            .commit();

                } else if (id == R.id.item22) {



                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame2, new user_profile())
                            .commit();


                }
                else if (id == R.id.item33) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame2, new user_bookslot())
                            .commit();


                }
                else if (id == R.id.item44) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame2, new user_bill())
                            .commit();


                }
                else if (id == R.id.item55) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame2, new user_generateQr())
                            .commit();


                }


                else {


                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame2, new user_logout())
                            .commit();

                }
                // Add more if-else blocks for other menu
                menuItem.setChecked(true);
                previousMenuItem = menuItem;

                dl2.closeDrawer(GravityCompat.START);
                return true;

            }
        });

    }


    @Override
    public void onBackPressed() {

        if(dl2.isDrawerOpen(GravityCompat.START))
        {
            dl2.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }




}
