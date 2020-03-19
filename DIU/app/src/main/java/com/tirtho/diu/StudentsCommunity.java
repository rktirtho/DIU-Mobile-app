package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tirtho.com.tirtho.diu.custome.list.CustomClubList;
import com.tirtho.pojo.StudentCommunity;

import java.util.ArrayList;
import java.util.List;

public class StudentsCommunity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_community);
        listView = findViewById(R.id.lv_student_community);


        List<StudentCommunity> studentsCommunities = new ArrayList<>();
        studentsCommunities.add(new StudentCommunity(R.drawable.uni_logo, "Computer \u0026 Programming Club"));
        studentsCommunities.add(new StudentCommunity(R.drawable.uni_logo, "BASIS Student Forum"));
        studentsCommunities.add(new StudentCommunity(R.drawable.uni_logo, "Debating Club"));
        studentsCommunities.add(new StudentCommunity(R.drawable.uni_logo, "Bondhu Shova(DIU)"));

        CustomClubList clubList = new CustomClubList(this, R.layout.model_student_community,studentsCommunities);
        listView.setAdapter(clubList);


    }
}
