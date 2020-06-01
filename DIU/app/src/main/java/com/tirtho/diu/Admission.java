package com.tirtho.diu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admission extends AppCompatActivity {

    Button admissionAligibility, admissionRequerment, tiutionFee, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        admissionAligibility = findViewById(R.id.btn_add_aligibility);
        admissionRequerment = findViewById(R.id.btn_required_doc);
        contact = findViewById(R.id.btn_finantialAss);


        admissionRequerment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admission.this, AdmitionRequired.class);
                intent.putExtra("key", "Required Documents");
                startActivity(intent);
            }
        });

        admissionAligibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admission.this, AdmitionRequired.class);
                intent.putExtra("key", "Admission Eligibility");
                startActivity(intent);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admission.this, Contact.class));
            }
        });



    }
}
