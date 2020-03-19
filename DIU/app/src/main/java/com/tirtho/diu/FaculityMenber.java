package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tirtho.com.tirtho.diu.custome.list.CustomFaculityList;
import com.tirtho.pojo.Faculaty;

import java.util.ArrayList;
import java.util.List;

public class FaculityMenber extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculity_menber);

        listView = findViewById(R.id.faculity_list);

        List<Faculaty> faculaties = new ArrayList<>();

        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));




        CustomFaculityList faculityList = new CustomFaculityList(this,R.layout.model_faculity,faculaties);
        listView.setAdapter(faculityList);

    }
}
