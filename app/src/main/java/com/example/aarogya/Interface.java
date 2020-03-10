package com.example.aarogya;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.aarogya.HomeFragment;
import com.example.aarogya.NotificationFragment;
import com.example.aarogya.ProfileFragment;
import com.example.aarogya.ServicesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Interface extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inter);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));
    }
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.nav_services:
                            openFragment(ServicesFragment.newInstance("", ""));
                            return true;
                        case R.id.nav_notifications:
                            openFragment(NotificationFragment.newInstance("", ""));

                        case R.id.nav_profile:
                            openFragment(ProfileFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

    public void bloodClicked(View view) {
        Intent e = new Intent(Interface.this, Blood.class);
        startActivity(e);
    }

    public void appointmentsClicked(View view) {
        Intent f = new Intent(Interface.this, appoinment.class);
        startActivity(f);


        }

        public void specialistClicked (View view) {
            Intent g = new Intent(Interface.this, Specialist.class);
            startActivity(g);
        }

        public void treatmentClicked (View view){
                Intent g = new Intent(Interface.this, Treatment.class);
                startActivity(g);
        }

        public void emergenClick (View view)
        {
            Intent h = new Intent(Interface.this, Emergency.class);
            startActivity(h);
        }

    }
