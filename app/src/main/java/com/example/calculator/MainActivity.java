package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private CalculatorFragment calculatorFragment = new CalculatorFragment();
    private AboutFragment aboutFragment = new AboutFragment();
    private HistoryFragment historyFragment = new HistoryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawe_open, R.string.navigation_drawe_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    calculatorFragment).commit();
            navigationView.setCheckedItem(R.id.calc_item);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.calc_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        calculatorFragment).commit();
                getSupportActionBar().setTitle(getString(R.string.app_name));
                break;

            case R.id.history_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        historyFragment).commit();
                getSupportActionBar().setTitle(getString(R.string.history));
                break;

            case R.id.about_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        aboutFragment).commit();
                getSupportActionBar().setTitle(getString(R.string.about_btn));
                break;
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
