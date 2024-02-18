package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //ActionBarDrawerToggle drawerToggle;
    FragmentManager fragmentManager;
    Toolbar toolbar;

//ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        frameLayout=findViewById(R.id.frame_layout);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_drawer);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if(item.getItemId()==R.id.Home){
                replaceFragment(new HomeFragment());
            }
            else  if(item.getItemId()==R.id.Activity){
                replaceFragment(new activityFragment());
            }
            else  if(item.getItemId()==R.id.nutrition){
                replaceFragment(new reportsFragment());
            }
            else  if(item.getItemId()==R.id.progress){
                replaceFragment(new careFragment());
            }



            return false;
        });

fragmentManager=getSupportFragmentManager();
replaceFragment(new HomeFragment());


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.home){
                Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId()==R.id.healthTips){
                Toast.makeText(MainActivity.this, "Health Tips Selected", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId()==R.id.stories){
                Toast.makeText(MainActivity.this, "Stories Selected", Toast.LENGTH_SHORT).show();
            }
        else if(item.getItemId()==R.id.help){
            Toast.makeText(MainActivity.this, "Help Selected", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.policy){
            Toast.makeText(MainActivity.this, "Privacy Policy Selected", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,privacyActivity.class);
            startActivity(intent);
        }
            else if(item.getItemId()==R.id.about){
                Intent intent=new Intent(MainActivity.this, profileActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "About Selected", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId()==R.id.login){
                Toast.makeText(MainActivity.this, "Log In Selected", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId()==R.id.share){
                Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId()==R.id.rate_us){
                Toast.makeText(MainActivity.this, "Rate Us Selected", Toast.LENGTH_SHORT).show();
            }


        return false;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}