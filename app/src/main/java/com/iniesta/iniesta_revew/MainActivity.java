package com.iniesta.iniesta_revew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle t;
    boolean check=true;

    public DrawerLayout drawerLayout;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close );

        final Menu v=navigationView.getMenu();
        t=new ActionBarDrawerToggle(this, drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close );
        drawerLayout.addDrawerListener(t);
        t.syncState();ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.mobile_nav)
                {
                   //v.getItem(R.id.nav_share).setVisible(true);
                    if(check) {
                        v.findItem(R.id.mobile_nav_latest).setVisible(true);
                        v.findItem(R.id.mobile_nav_best).setVisible(true);
                        v.findItem(R.id.mobile_nav_top10).setVisible(true);
                        check=false;
                    }
                    else
                    {
                        check = true;
                        v.findItem(R.id.mobile_nav_latest).setVisible(false);
                        v.findItem(R.id.mobile_nav_best).setVisible(false);
                        v.findItem(R.id.mobile_nav_top10).setVisible(false);

                    }
                }
                if(menuItem.getItemId()==R.id.laptops_nav)
                {
                    //v.getItem(R.id.nav_share).setVisible(true);
                    if(check) {
                        v.findItem(R.id.laptops_nav_latest).setVisible(true);
                        v.findItem(R.id.laptops_nav_best).setVisible(true);
                        v.findItem(R.id.laptops_nav_top10).setVisible(true);
                        check=false;
                    }
                    else
                    {
                        check = true;
                        v.findItem(R.id.laptops_nav_latest).setVisible(false);
                        v.findItem(R.id.laptops_nav_best).setVisible(false);
                        v.findItem(R.id.laptops_nav_top10).setVisible(false);

                    }
                }
                if(menuItem.getItemId()==R.id.smart_home)
                {
                    //v.getItem(R.id.nav_share).setVisible(true);
                    if(check) {
                        v.findItem(R.id.tv_nav).setVisible(true);
                        v.findItem(R.id.washing_nav).setVisible(true);
                        v.findItem(R.id.refrigerator_nav).setVisible(true);
                        v.findItem(R.id.ac_nav).setVisible(true);
                        v.findItem(R.id.smart_nav).setVisible(true);
                        v.findItem(R.id.geyser_nav).setVisible(true);
                        v.findItem(R.id.water_nav).setVisible(true);
                        check=false;
                    }
                    else
                    {
                        check = true;
                        v.findItem(R.id.tv_nav).setVisible(false);
                        v.findItem(R.id.washing_nav).setVisible(false);
                        v.findItem(R.id.refrigerator_nav).setVisible(false);
                        v.findItem(R.id.ac_nav).setVisible(false);
                        v.findItem(R.id.smart_nav).setVisible(false);
                        v.findItem(R.id.geyser_nav).setVisible(false);
                        v.findItem(R.id.water_nav).setVisible(false);

                    }
                }
                if(menuItem.getItemId()==R.id.gadgets_nav)
                {
                    //v.getItem(R.id.nav_share).setVisible(true);
                    if(check) {
                        v.findItem(R.id.gaming_nav).setVisible(true);
                        v.findItem(R.id.speakers_nav).setVisible(true);
                        v.findItem(R.id.tablets_nav).setVisible(true);
                        v.findItem(R.id.cameras_nav).setVisible(true);
                        v.findItem(R.id.headphones_nav).setVisible(true);
                        v.findItem(R.id.printers_nav).setVisible(true);
                        check=false;
                    }
                    else
                    {
                        check = true;
                        v.findItem(R.id.gaming_nav).setVisible(false);
                        v.findItem(R.id.speakers_nav).setVisible(false);
                        v.findItem(R.id.tablets_nav).setVisible(false);
                        v.findItem(R.id.cameras_nav).setVisible(false);
                        v.findItem(R.id.headphones_nav).setVisible(false);
                        v.findItem(R.id.printers_nav).setVisible(false);

                    }
                }
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                return false;
            }

        });

        Fragment itemsFragment = new ItemsFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments_container, itemsFragment)
                .commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
