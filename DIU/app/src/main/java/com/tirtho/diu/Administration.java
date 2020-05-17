package com.tirtho.diu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.tirtho.com.tirtho.diu.custome.list.CustomFaculityList;
import com.tirtho.pojo.Faculaty;

import java.util.ArrayList;
import java.util.List;

public class Administration extends AppCompatActivity implements View.OnClickListener {

    Button btnAccademic, btnBot,btnSindicate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);
        btnAccademic = findViewById(R.id.btn_academic);
        btnSindicate = findViewById(R.id.btn_syndicate);
        btnBot = findViewById(R.id.btn_bot);

        btnSindicate.setOnClickListener(this);
        btnBot.setOnClickListener(this);
        btnAccademic.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Administration.this, FaculityMenber.class);
        switch (v.getId()){
            case R.id.btn_academic:
                intent.putExtra("selected", "Academic Council");
                startActivity(intent);
                break;
            case R.id.btn_bot:
                intent.putExtra("selected","Board of Trustees");
                startActivity(intent);
                break;
            case R.id.btn_syndicate:
                intent.putExtra("selected","Syndicate");
                startActivity(intent);
                break;
            case R.id.btn_vc:
                Intent intent1 = new Intent(Administration.this, ViceChancelor.class);
                startActivity(intent1);
                break;

        }
    }
}
