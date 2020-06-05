package com.tirtho;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tirtho.com.tirtho.com.tirtho.login.LoginResponse;
import com.tirtho.com.tirtho.com.tirtho.login.LoginService;
import com.tirtho.com.tirtho.com.tirtho.login.UserLogin;
import com.tirtho.com.tirtho.result.Result;
import com.tirtho.diu.AcademicResult;
import com.tirtho.diu.LoginActivity;
import com.tirtho.diu.MainActivity;
import com.tirtho.diu.R;
import com.tirtho.diu.com.tirtho.others.RetrofitClient;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlashScreen extends AppCompatActivity {

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        preferences = getSharedPreferences(LoginActivity.mySharedPreference, Context.MODE_PRIVATE);

        boolean isLogin = preferences.getBoolean(LoginActivity.isLogin, false);



        if (!isLogin) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            this.finish();
        }else {
            String email = ServiceHelper.getEmail(this);
            String password = ServiceHelper.getPassword(this);

            View parentLayout = findViewById(android.R.id.content);
            if (!isOnline()){
                Snackbar.make(parentLayout, "You are offline", Snackbar.LENGTH_LONG)
                        .setAction("Turn On", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                            }
                        }).show();
            }else {
                Call<LoginResponse> call = RetrofitClient.getInstance()
                        .getLoginService()
                        .login(new UserLogin(email, password));

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();

                            if (loginResponse != null && loginResponse.getToken() != null) {
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putBoolean(ServiceHelper.isLogin, true);
                                editor.putString(ServiceHelper.TOKEN, loginResponse.getToken());
                                editor.putInt(ServiceHelper.ID, loginResponse.getUser().getId());
                                editor.putString(ServiceHelper.ST_PROFILE_IMAGE, loginResponse.getUser().getProfile_photo());
                                editor.putString(ServiceHelper.ST_NAME, loginResponse.getUser().getName());
                                editor.apply();
                                startActivity(new Intent(FlashScreen.this, MainActivity.class));
                                FlashScreen.this.finish();

                            }else {

                            }


                        }else {

                        }


                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                        Toast.makeText(FlashScreen.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();

                    }
                });

            }

        }

    }
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}
