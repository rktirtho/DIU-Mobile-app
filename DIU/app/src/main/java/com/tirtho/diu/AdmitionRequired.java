package com.tirtho.diu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdmitionRequired extends AppCompatActivity {

    TextView tvFact, tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admition_required);

        tvFact = findViewById(R.id.tv_fact);
        tvInfo = findViewById(R.id.info);

        String key = getIntent().getStringExtra("key");
        tvFact.setText(key);

        if (key.equals("Admission Eligibility")){
            tvInfo.setText(getResources().getString(R.string.admission_eligibility));
        }else if (key.equals("Required Documents")){
            tvInfo.setText(getResources().getString(R.string.text_admission_req));
        }




    }
}
