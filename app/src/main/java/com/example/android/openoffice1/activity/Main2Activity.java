package com.example.android.openoffice1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.openoffice1.AboutUsActivity;
import com.example.android.openoffice1.Main3Activity;
import com.example.android.openoffice1.Main4Activity;
import com.example.android.openoffice1.Main5Activity;
import com.example.android.openoffice1.Main6Activity;
import com.example.android.openoffice1.Main7Activity;
import com.example.android.openoffice1.PrivacyPolicyActivity;
import com.example.android.openoffice1.R;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
       {
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);


        //Navigation View Header
        navHeader = navigationView.getHeaderView(0);



      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

           public void goToCreate(View view){
               Intent intent5 = new Intent(this,Main3Activity.class);
               startActivity(intent5);
           }

           public void goToRead(View view){
               Intent intent6 = new Intent(this,Main4Activity.class);
               startActivity(intent6);
           }



           public void Update(View view) {
               Intent intent4 = new Intent(this,Main5Activity.class);
               startActivity(intent4);
           }

           public void goToDelete(View view) {
               Intent intent7 = new Intent(this, Main6Activity.class);
               startActivity(intent7);
           }
           public void goToShare(View view) {
               Intent intent8 = new Intent(this, Main7Activity.class);
               startActivity(intent8);
           }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }


        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home


        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            finish();
System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
   public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        }
         else if (id == R.id.nav_about_us) {
            startActivity(new Intent(Main2Activity.this, AboutUsActivity.class));
            drawer.closeDrawers();

        } else if (id == R.id.nav_privacy_policy) {
            startActivity(new Intent(Main2Activity.this, PrivacyPolicyActivity.class));
            drawer.closeDrawers();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
