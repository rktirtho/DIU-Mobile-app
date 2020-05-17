package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.tirtho.com.tirtho.result.Result;
import com.tirtho.com.tirtho.user.UserProfile;
import com.tirtho.diu.com.tirtho.others.RetrofitClient;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcademicResult extends AppCompatActivity {
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_result);

        test = findViewById(R.id.test);


        Call<Result> call = RetrofitClient.getInstance()
                .getResultService()
                .getResult(
                        ServiceHelper.getId(AcademicResult.this),
                        ServiceHelper.getToken(AcademicResult.this)
                );




        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                if (response.isSuccessful()){

                    Result result = response.body();

//                    test.setText(result.getTranscriptData().);

                }
                else {
                    Toast.makeText(AcademicResult.this, "Success  Error: "+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(AcademicResult.this, "Error "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                test.setText(t.getMessage());
                t.printStackTrace();


            }
        });
    }
}
