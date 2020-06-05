package com.tirtho.diu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tirtho.com.tirtho.diu.custome.list.CustomBatchSpinnerAdapter;
import com.tirtho.com.tirtho.diu.custome.list.CustomSpinner;
import com.tirtho.com.tirtho.registration.Batch;
import com.tirtho.com.tirtho.registration.Depertment;
import com.tirtho.diu.com.tirtho.others.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    Button register, login;
    Spinner department, batch;
    EditText etReg, etRoll, etPhoneNumber;


    List<Depertment> depertments;

    List<Batch> batches;


    int deptId, batchId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        register = findViewById(R.id.btn_register);
        login = findViewById(R.id.btn_login);

        department = findViewById(R.id.sp_dept);
        batch = findViewById(R.id.sp_batch);

        etPhoneNumber = findViewById(R.id.phone);
        etRoll = findViewById(R.id.roll);
        etReg = findViewById(R.id.regestration);


        depertments = new ArrayList<>();
        batches = new ArrayList<>();


        Call<List<Depertment>> call = RetrofitClient.getInstance()
                .getDepertmentService().getDepartments();

        call.enqueue(new Callback<List<Depertment>>() {
            @Override
            public void onResponse(Call<List<Depertment>> call, Response<List<Depertment>> response) {
                if (response.isSuccessful() && response.code() < 300) {
                    depertments = (ArrayList<Depertment>) response.body();

                    CustomSpinner deptSpriiner = new CustomSpinner(Registration.this, depertments);
                    department.setAdapter(deptSpriiner);


                    department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            deptId = depertments.get(position).getId();

                            Call<List<Batch>> batchCall = RetrofitClient.getInstance()
                                    .getBatchServices().getBatches(deptId+"");

                            batchCall.enqueue(new Callback<List<Batch>>() {
                                @Override
                                public void onResponse(Call<List<Batch>> call, Response<List<Batch>> response) {
                                    if (response.isSuccessful() && response.code() < 300) {

                                        batches = response.body();
                                        CustomBatchSpinnerAdapter batchAdepter
                                                = new CustomBatchSpinnerAdapter(Registration.this, batches);
                                        batch.setAdapter(batchAdepter);

                                       batch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                           @Override
                                           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                               batchId = batches.get(position).getId();
                                           }

                                           @Override
                                           public void onNothingSelected(AdapterView<?> parent) {

                                           }
                                       });
                                    }
                                }

                                @Override
                                public void onFailure(Call<List<Batch>> call, Throwable t) {

                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });






                }
            }

            @Override
            public void onFailure(Call<List<Depertment>> call, Throwable t) {

            }
        });





        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:

                String registration  = etReg.getText().toString().trim();
                String roll = etRoll.getText().toString().trim();
                String phone = etPhoneNumber.getText().toString().trim();


                Toast.makeText(this,
                        "Department "+deptId
                        +"\nBatch : "+batchId
                        +"\nReg : "+registration
                        +"\nRoll : "+roll
                        +"\nPhone : "+phone

                        , Toast.LENGTH_SHORT).show();




                break;
            case R.id.btn_login:
                startActivity(new Intent(Registration.this, LoginActivity.class));
                Registration.this.finish();
                break;
        }

    }
}
