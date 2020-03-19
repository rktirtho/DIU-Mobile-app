package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tirtho.com.tirtho.diu.custome.list.CustomFaculityList;
import com.tirtho.pojo.Faculaty;

import java.util.ArrayList;
import java.util.List;

public class Administration extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);
        listView = findViewById(R.id.lv_administration);

        List<Faculaty> administrativeMembers = new ArrayList<>();

        administrativeMembers.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
        administrativeMembers.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
        administrativeMembers.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));


        CustomFaculityList faculityList = new CustomFaculityList(this,R.layout.model_faculity,administrativeMembers);
        listView.setAdapter(faculityList);
    }
}
