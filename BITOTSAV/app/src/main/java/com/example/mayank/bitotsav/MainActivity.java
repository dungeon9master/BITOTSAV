package com.example.mayank.bitotsav;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import layout.HomeFragment;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager, viewPager2;
    RecyclerView recyclerViewInNavigationView;
    CircleIndicator circularIndicator;
    FragmentManager fragmentManager;
    LinearLayoutManager recyclerViewInNavigationViewLayoutManager;
    RecyclerViewInNavigationViewAdapter recyclerViewInNavigationViewAdapter;
    static int currentPage = 0;
    ImageView imageViewInNavHeader;
    static int currentPage2 = 0;
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    private ArrayList<Integer> XMENArray2 = new ArrayList<Integer>();
    int count = 0;
    int images[] = {R.drawable.sunidhi, R.drawable.nukkad, R.drawable.pronight, R.drawable.morningevent};
    int images2[] = {R.drawable.sherlock, R.drawable.friends, R.drawable.narcos, R.drawable.got, R.drawable.stranger};

    ImagesViewPagerAdapter imagesViewPagerAdapter;
    ImagesViewPagerAdapter2 imagesViewPagerAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        android.support.v4.app.Fragment fragment1 = new HomeFragment();
        FragmentTransaction fragmentTransaction1 = MainActivity.this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.group, fragment1);
        fragmentTransaction1.commit();

//        try {
//            Intent intent = getIntent();
//            intent.getStringExtra("fromPersonClass");
//            android.support.v4.app.Fragment fragment = new ContactsFragment();
//            FragmentTransaction fragmentTransaction = MainActivity.this.getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.group, fragment);
//            fragmentTransaction.commit();
//        } catch (Exception e) {
//
//        }
        init();
        callRecyclerViewInNavigationView();
        fragmentManager = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {

//                for (int i = 0; i < images2.length; i++)
//                    XMENArray2.add(images2[i]);
//                viewPager2 = (ViewPager) findViewById(R.id.imageViewPager2);
//                imagesViewPagerAdapter2 = new ImagesViewPagerAdapter2(MainActivity.this, images2);
//                viewPager2.setAdapter(imagesViewPagerAdapter2);
//                viewPager2.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View view, MotionEvent motionEvent) {
//                        return false;
//                    }
//                });
//                final Handler handler = new Handler();
//                final Runnable Update = new Runnable() {
//                    public void run() {
//                        if (currentPage2 == images2.length) {
//                            currentPage2 = 0;
//                        }
//                        viewPager2.setCurrentItem(currentPage2++, true);
//                    }
//                };
//                Timer swipeTimer = new Timer();
//                swipeTimer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        handler.post(Update);
//                    }
//                }, 2500, 5000);
//
//            }

                imageViewInNavHeader = (ImageView) findViewById(R.id.imageViewInNavHeader);

                imageViewInNavHeader = (ImageView)

                        findViewById(R.id.imageViewInNavHeader);

                if (count == 0)

                {
                    imageViewInNavHeader.setImageResource(R.drawable.sherlock);
                }

                if (count == 1)

                {

                    imageViewInNavHeader.setImageResource(R.drawable.friends);
                } else if (count == 2)

                {
                    imageViewInNavHeader.setImageResource(R.drawable.narcos);

                } else if (count == 3)

                {
                    imageViewInNavHeader.setImageResource(R.drawable.got);
                    count = -1;
                }

                count++;

            }
        };

        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //       navigationView.setNavigationItemSelectedListener(this);
    }


    private void callRecyclerViewInNavigationView() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        recyclerViewInNavigationView = (RecyclerView) findViewById(R.id.recyclerViewInNavigationView);
        recyclerViewInNavigationViewLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewInNavigationViewLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewInNavigationViewAdapter = new RecyclerViewInNavigationViewAdapter(MainActivity.this, drawer, viewPager, circularIndicator, recyclerViewInNavigationView);
        recyclerViewInNavigationView.setLayoutManager(recyclerViewInNavigationViewLayoutManager);
        recyclerViewInNavigationView.setAdapter(recyclerViewInNavigationViewAdapter);

    }

    private void init() {
        for (int i = 0; i < images.length; i++)
            XMENArray.add(images[i]);

        viewPager = (ViewPager) findViewById(R.id.imageViewPager);
        imagesViewPagerAdapter = new ImagesViewPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(imagesViewPagerAdapter);
        circularIndicator = (CircleIndicator) findViewById(R.id.circularIndicator);
        circularIndicator.setViewPager(viewPager);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
}
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

//   @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//        android.support.v4.app.Fragment fragment = null;
//        if (id == R.id.events) {
//            fragment = new EventFragment();
//        } else if (id == R.id.home) {
//
//        } else if (id == R.id.contacts) {
//            fragment = new ContactsFragment();
//
//        } else if (id == R.id.maps) {
//            fragment = new MapsFragment();
//
//        } else if (id == R.id.nav_send) {
//
//        }
//        if (fragment != null) {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.group, fragment);
//            viewPager.setVisibility(View.GONE);
//            circularIndicator.setVisibility(View.GONE);
//            fragmentTransaction.commit();
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
