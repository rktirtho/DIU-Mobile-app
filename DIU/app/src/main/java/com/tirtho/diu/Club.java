package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Club extends AppCompatActivity {

    TextView tvAbout, tvMission, tvVission, tvName, tvRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        tvAbout= findViewById(R.id.tv_about);
        tvMission =  findViewById(R.id.tv_mission);
        tvVission = findViewById(R.id.tv_vission);
        tvName = findViewById(R.id.tv_name);
        tvRegistration = findViewById(R.id.tv_registration);

        String clubName=getIntent().getStringExtra("name");
        tvName.setText(clubName);
        this.setTitle(clubName);

        switch (clubName){
            case "Computer \u0026 Programming Club":
                textSetter(getResources().getString(R.string.club_cpc_introduction)
                        ,getResources().getString(R.string.club_cpc_mission)
                        ,getResources().getString(R.string.club_cpc_vision)
                        ,getResources().getString(R.string.club_cpc_registration)
                )
                ;
                break;
            case "BASIS Student Forum":
                textSetter("No Data","No Data","No Data","No Data");
                break;
            case "Debating Club":
                textSetter("No Data","No Data","No Data","No Data");
                break;
                case "Bondhu Shova(DIU)":
                textSetter("No Data","No Data","No Data","No Data");
                break;

        }
    }

    void textSetter(String about, String mission, String vission,String registration){
        tvAbout.setText(about);
        tvMission.setText(mission);
        tvVission.setText(vission);
        tvRegistration.setText(registration);
    }
}
