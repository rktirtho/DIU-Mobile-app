package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tirtho.com.tirtho.diu.custome.list.NoticeAdepter;

import java.util.ArrayList;
import java.util.List;

public class Notice extends AppCompatActivity {

    ListView noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        noticeList = findViewById(R.id.noticeList);

        List<com.tirtho.pojo.Notice> notices = new ArrayList<>();
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","21\nMAR"));
        notices.add(new com.tirtho.pojo.Notice("Exam Postponed Due To corona virous", "All Campus Remain close from 16 march to 31 march","15\nMAR"));
        notices.add(new com.tirtho.pojo.Notice("Exam Schedule", "Exma Schedule is here.","11\nMAR"));
        notices.add(new com.tirtho.pojo.Notice("Improvment Exam", "Give your tution fee in ","10\nMAR"));
        notices.add(new com.tirtho.pojo.Notice("Olnine Pament System", "Give your tution fee in ","01\nMAR"));
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","31\nFEB"));
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","21\nFEB"));
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","12\nFEB"));
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","08\nFEB"));
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","01\nFEB"));
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","24\nJAN"));
        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","21\nJAN"));




        NoticeAdepter adepter = new NoticeAdepter(Notice.this, R.layout.model_notice, notices);
        noticeList.setAdapter(adepter);

    }
}
