package com.tirtho.diu;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tirtho.com.tirtho.user.UserProfile;
import com.tirtho.diu.com.tirtho.others.RetrofitClient;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;
import com.tirtho.diu.sharedprefarance.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {
    ImageView profileImage;
    TextView name, roll, registration, year,regSl,blood,email,phoneNo,gender,dob,permanentAddress,
    nationality,maritalStatus, fatherName, fatherPhone,motherName, motherPhone, emPerson, emPersonPhone;

    ProgressDialog progressDoalog;
    View parentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = findViewById(R.id.iv_profile);
        name = findViewById(R.id.st_name);
        roll = findViewById(R.id.st_roll);
        registration = findViewById(R.id.st_reg);
        year = findViewById(R.id.st_reg_year);
        regSl = findViewById(R.id.st_reg_sl);
        blood = findViewById(R.id.st_blood);
        email = findViewById(R.id.st_email);
        phoneNo = findViewById(R.id.st_phone);
        gender = findViewById(R.id.st_gender);
        dob = findViewById(R.id.st_dob);
        permanentAddress = findViewById(R.id.st_p_address);
        nationality = findViewById(R.id.st_nationality);
        maritalStatus = findViewById(R.id.st_marital_status);

        fatherName= findViewById(R.id.st_f_name);
        fatherPhone= findViewById(R.id.st_f_ph);

        motherName= findViewById(R.id.st_m_name);
        motherPhone= findViewById(R.id.st_m_phone);

        emPerson= findViewById(R.id.st_em);
        emPersonPhone= findViewById(R.id.st_em_p);

        parentLayout = findViewById(android.R.id.content);

        progressDoalog = new ProgressDialog(Profile.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Fatching Data....");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();


        Glide.with(this)
                .load(ServiceHelper.getProfileImage(this))
                .placeholder(R.drawable.prof_placeholder)
                .error(R.drawable.prof_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(profileImage);


        Call<UserProfile> call = RetrofitClient.getInstance()
                .getProfileService()
                .getProfile(
                        ServiceHelper
                                .getToken(Profile.this)
                );
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful() && response.code()<300){
                    UserProfile profile = response.body();
                    name.setText(profile.getName());
                    roll.setText(": "+profile.getRollNo());
                    registration.setText(": "+profile.getRegCode());
                    year.setText(": "+profile.getYear());
                    regSl.setText(": "+profile.getRegSlNo());
                    blood.setText(": "+profile.getBloodGroup());
                    email.setText(": "+profile.getEmail());
                    phoneNo.setText(": "+profile.getPhoneNo());
                    if (profile.getGender().equalsIgnoreCase("M")){
                        gender.setText(": Male");
                    }else {
                        gender.setText(": Female");
                    }
                    dob.setText(": "+profile.getDob());
                    permanentAddress.setText(": "+profile.getParmanentAddress());
                    nationality.setText(": "+profile.getNationality());
                    if (profile.getMaritalStatus().equalsIgnoreCase("N")){
                        maritalStatus.setText(": Single");
                    }else {
                        maritalStatus.setText(": Married");
                    }

                    fatherName.setText(": "+profile.getFatherName());
                    fatherPhone.setText(": "+profile.getFatherCellno());

                    motherName.setText(": "+profile.getMotherName());
                    motherPhone.setText(": "+profile.getMotherCellno());

                    emPerson.setText(": "+profile.getEmergencyName());
                    emPersonPhone.setText(": "+profile.getEmergencyCellno());

                }
                progressDoalog.dismiss();
            }


            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                if (!Login.isOnline(Profile.this)){
                    Snackbar.make(parentLayout, "You are offline", Snackbar.LENGTH_LONG)
                            .setAction("Turn On", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).show();

                }else {
                    Toast.makeText(Profile.this, "Failur..", Toast.LENGTH_SHORT).show();
                }
                progressDoalog.dismiss();

            }

        });



    }
}
