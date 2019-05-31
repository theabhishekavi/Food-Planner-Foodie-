package com.example.food_plannerfoodie;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.food_plannerfoodie.Fragment.BFPFragment;
import com.example.food_plannerfoodie.Fragment.BMIFragment;
import com.example.food_plannerfoodie.Fragment.BMRFragment;
import com.example.food_plannerfoodie.Fragment.DailyFoodIntakeFragment;
import com.example.food_plannerfoodie.Fragment.HomeFragment;
import com.example.food_plannerfoodie.Fragment.WhatsYourMotiveFragment;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame,
                new HomeFragment()).commit();

        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        drawerLayout.closeDrawers();
                        Fragment fragment = new HomeFragment();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_bmi:
                                fragment = new BMIFragment();
                                break;
                            case R.id.nav_bmr:
                                fragment = new BMRFragment();
                                break;
                            case R.id.nav_body_fat:
                                fragment = new BFPFragment();
                                break;
                            case R.id.nav_daily_food_intake:
                                fragment = new DailyFoodIntakeFragment();
                                break;
                            case R.id.nav_your_motive:
                                fragment = new WhatsYourMotiveFragment();
                                break;
                        }
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.content_frame,fragment)
                                .addToBackStack(null).commit();
                        return true;
                    }
                });


    }
}
