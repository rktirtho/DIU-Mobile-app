package com.tirtho.diu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView dateTimeDisplay, day, status;
    RelativeLayout statusBox;
    LinearLayout llNotice, llEvent;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    public static String token;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dateTimeDisplay = findViewById(R.id.date);
        day = findViewById(R.id.day);
        status = findViewById(R.id.status);
        statusBox = findViewById(R.id.status_box);

        llNotice = findViewById(R.id.llNotice);
        llEvent = findViewById(R.id.llEvent);


        llNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Notice.class));
            }
        });


        preferences = getSharedPreferences(LoginActivity.mySharedPreference, Context.MODE_PRIVATE);

        boolean isLogin = preferences.getBoolean(LoginActivity.isLogin, false);
        token = preferences.getString(LoginActivity.TOKEN, "miss");



        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                day.setText("Sunday");
                break;
            case 2:
                day.setText("Monday");
                break;
            case 3:
                day.setText("Tuesday");
                break;
            case 4:
                day.setText("Wednesday");
                break;
            case 5:
                day.setText("Thursday");
                break;
            case 6:
                day.setText("Friday");
                break;
            case 7:
                day.setText("Saturday");
                break;
        }


        if (calendar.get(Calendar.DAY_OF_WEEK) == 2) {
            statusBox.setBackgroundColor(Color.parseColor("#FD0000"));
            status.setText("Weekly Off Day");
        }

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        View parentLayout = findViewById(android.R.id.content);
        if (!isOnline()) {

            Snackbar.make(parentLayout, "You are offline", Snackbar.LENGTH_LONG)
                    .setAction("Turn On", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                        }
                    }).show();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


//        menu.getItem(R.id.action_profile).setIcon()
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(LoginActivity.isLogin, false);
            editor.commit();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            this.finish();

            return true;
        }
        if (id == R.id.action_profile) {
            startActivity(new Intent(MainActivity.this, Profile.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_class_routine) {
            startActivity(new Intent(MainActivity.this, ClassRoutine.class));
        } else if (id == R.id.nav_class_notice) {
            startActivity(new Intent(MainActivity.this, Notice.class));

        } else if (id == R.id.nav_account_details) {
            startActivity(new Intent(MainActivity.this, AccountDetails.class));
        } else if (id == R.id.nav_academic_result) {
            startActivity(new Intent(MainActivity.this, AcademicResult.class));
        } else if (id == R.id.nav_class_academic_calender) {
            startActivity(new Intent(MainActivity.this, AcademicCalendar.class));
        } else if (id == R.id.nav_administration) {
            startActivity(new Intent(MainActivity.this, Administration.class));
        }
//        else if (id == R.id.nav_faculity_members) {
//            startActivity(new Intent(MainActivity.this, FaculityMenber.class));
//        }
        else if (id == R.id.nav_student_comunity) {
            startActivity(new Intent(MainActivity.this, StudentsCommunity.class));
        } else if (id == R.id.nav_transport) {
            startActivity(new Intent(MainActivity.this, Transport.class));
        } else if (id == R.id.nav_photo_gallery) {
            startActivity(new Intent(MainActivity.this, Gallery.class));
        } else if (id == R.id.nav_class_academic_calender) {
            startActivity(new Intent(MainActivity.this, AcademicCalendar.class));
        } else if (id == R.id.nav_faq) {
            Toast.makeText(this, "Service is not available.", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_exam_guidline) {
            Toast.makeText(this, "Service is not available.", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_admission) {
            startActivity(new Intent(MainActivity.this, Admission.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(MainActivity.this, AboutUs.class));
        } else if (id == R.id.nav_rules) {
            startActivity(new Intent(MainActivity.this, RulesAndRegulation.class));
        } else if (id == R.id.nav_contact) {
            startActivity(new Intent(MainActivity.this, Contact.class));
        } else if (id == R.id.nav_dept) {
            startActivity(new Intent(MainActivity.this, Department.class));
        }else if (id == R.id.nav_library) {
            startActivity(new Intent(MainActivity.this, Library.class));
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}
