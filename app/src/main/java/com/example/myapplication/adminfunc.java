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

public class adminfunc extends AppCompatActivity{

    DrawerLayout dl;
    NavigationView nv;
    Toolbar tar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminfunc);

        dl=findViewById(R.id.drawerlayout);
        nv=findViewById(R.id.nav1);
        tar=findViewById(R.id.tool);


        setSupportActionBar(tar);
        nv.bringToFront();
        nv.setItemBackgroundResource(R.drawable.menu_color);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,dl,tar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        dl.addDrawerListener(toggle);
        toggle.syncState();



        //off deafult closing animation




        //nav item operation drawer menu
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            private MenuItem previousMenuItem = null;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                if (previousMenuItem != null) {
                    // Uncheck the previously selected item
                    previousMenuItem.setChecked(false);
                }

                int id = menuItem.getItemId();

                if (id == R.id.item1) {

                        // Fragment not yet added, add it
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame, new Home_frag())
                                .commit();

                } else if (id == R.id.item2) {



                        // Fragment not yet added, add it
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame, new profile_frag())
                                .commit();


                }
                else if (id == R.id.item3) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame, new current_slotdetail())
                            .commit();


                }
                else if (id == R.id.item4) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame, new History_detail())
                            .commit();


                }
                else if (id == R.id.item5) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame, new Set_ruppes())
                            .commit();


                }

                else if (id == R.id.item6) {

                    // Fragment not yet added, add it
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame, new Qr_frag())
                            .commit();


                }
                else {


                        // Fragment not yet added, add it
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame, new logoutfrag())
                                .commit();

                }
                // Add more if-else blocks for other menu
                menuItem.setChecked(true);
                previousMenuItem = menuItem;

                dl.closeDrawer(GravityCompat.START);
                return true;

            }
        });

    }


    @Override
    public void onBackPressed() {

        if(dl.isDrawerOpen(GravityCompat.START))
        {
            dl.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        }




}
