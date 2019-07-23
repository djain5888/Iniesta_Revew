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
    public Toolbar toolbar;
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
        String a[]={"hello","123"};
        Spinner spinner = (Spinner) navigationView.getMenu().findItem(R.id.latest_news).getActionView();
        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,a));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"hello"+position,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.nav_share)
                {
                   //v.getItem(R.id.nav_share).setVisible(true);
                    if(check==true) {
                        v.findItem(R.id.nav_feedback).setVisible(true);
                        v.findItem(R.id.nav_contact_us).setVisible(true);
                        check=false;
                    }
                    else
                    {
                        check=true;
                        v.findItem(R.id.nav_feedback).setVisible(false);
                        v.findItem(R.id.nav_contact_us).setVisible(false);

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
