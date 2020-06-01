package com.tirtho.diu;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tirtho.com.tirtho.diu.custome.list.ResultCardAdepter;
import com.tirtho.com.tirtho.result.GradePointSystemDetail;
import com.tirtho.com.tirtho.result.Result;
import com.tirtho.com.tirtho.result.Results;
import com.tirtho.com.tirtho.result.Semester;
import com.tirtho.com.tirtho.result.StudentInfo;
import com.tirtho.com.tirtho.result.TranscriptData;
import com.tirtho.com.tirtho.user.UserProfile;
import com.tirtho.diu.com.tirtho.others.RetrofitClient;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcademicResult extends AppCompatActivity {
    TextView studentName, roll, registrationNo, creditEarned, creditRequired, cgpa, laterGrade;
    ListView resultList;


    ProgressDialog progressDoalog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_result);

        studentName = findViewById(R.id.std_name);
        roll = findViewById(R.id.roll);
        registrationNo = findViewById(R.id.registration_no);
        creditEarned = findViewById(R.id.total_credit_earned);
        creditRequired = findViewById(R.id.extemped_credit);
        cgpa = findViewById(R.id.cgpa);
        laterGrade = findViewById(R.id.later_grade);

        resultList = findViewById(R.id.resultCart);


        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Fatching Data....");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();



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

                    StudentInfo studentInfo = response.body().getStudentInfo();
                    Results results = response.body().getTranscriptData().getResults();
                    List<GradePointSystemDetail> gradePointSystemDetail =  response.body().getGradePointSystemDetails();

                    studentName.setText(studentInfo.getName());
                    roll.setText("Class Roll : "+studentInfo.getRollNo());
                    registrationNo.setText("Registration No : "+studentInfo.getRegSlNo());
                    creditEarned.setText("Credit Earned"+results.getTotalCreditEarned());
                    creditRequired.setText("Credit Required"+results.getTotalCreditRequired());
                    cgpa.setText("CGPA : "+results.getCgpa().toString());
                    laterGrade.setText("Later Grade : "+results.getGradeLetter());


                    List<Semester> semesterList = new ArrayList<>();

                    TranscriptData transcriptData = response.body().getTranscriptData();


                    for (List<Semester> semesters : transcriptData.getSemesters()) {
                        for (Semester semester: semesters) {
                            semesterList.add(semester);
                        }
                    }

                    ResultCardAdepter resultCardAdepter = new ResultCardAdepter(AcademicResult.this
                            , R.layout.model_short_result,semesterList);

                    resultList.setAdapter(resultCardAdepter);

                    progressDoalog.dismiss();







                }
                else {
                    Toast.makeText(AcademicResult.this, "Success  Error: "+response.code(), Toast.LENGTH_SHORT).show();
                    progressDoalog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDoalog.dismiss();
                studentName.setText(t.getMessage());


            }
        });
    }
}
