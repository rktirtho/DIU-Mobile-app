package com.tirtho.diu;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tirtho.com.tirtho.com.tirtho.login.LoginResponse;
import com.tirtho.com.tirtho.com.tirtho.login.LoginService;
import com.tirtho.com.tirtho.com.tirtho.login.UserLogin;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static String mySharedPreference = "myPrep";
    public static String isLogin = "isLogin";
    public static String EMAIL = "email";
    public static String PASSWORD = "password";
    public static String TOKEN = "token";

    private LoginService loginService;

    private Button btnLogin, register;
    private TextView forgotpass, error;
    private EditText inputEmail, inputPassword;
    SharedPreferences preferences;


    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        preferences = getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);

        btnLogin = findViewById(R.id.btn_login);
        forgotpass = findViewById(R.id.link_forgotten);
        register = findViewById(R.id.btn_register);
        error = findViewById(R.id.tv_error);

        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);


        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, BrowserActivity.class));
            }
        });


        btnLogin.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                error.setVisibility(View.GONE);

                final String email = inputEmail.getText().toString().trim();
                final String password = inputPassword.getText().toString().trim();

//                if (email.equalsIgnoreCase("test@gmail.com") && password.equalsIgnoreCase("test123")) {
//
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putBoolean(isLogin, true);
//                    editor.commit();
//                    this.finish();
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                }

                if (email.equalsIgnoreCase("")) {
                    inputEmail.setError("Required");
                } else if (password.equalsIgnoreCase("")) {
                    inputPassword.setError("Required");
                } else {

                    progressDoalog = new ProgressDialog(LoginActivity.this);
                    progressDoalog.setMax(100);
                    progressDoalog.setMessage("Please Wait....");
                    progressDoalog.setTitle("Login");
                    progressDoalog.setIcon(R.drawable.ic_lock_open_black_24dp);
                    progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDoalog.show();


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://api.diu.ac")
                            .client(getUnsafeOkHttpClient().build())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    loginService = retrofit.create(LoginService.class);

                    UserLogin userLogin = new UserLogin(email,password);

                    Call<LoginResponse> loginResponseCall = loginService.login(userLogin);
                    loginResponseCall.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                            if (response.isSuccessful()) {
                                LoginResponse loginResponse = response.body();

                                if (loginResponse != null && loginResponse.getToken() != null) {
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putBoolean(ServiceHelper.isLogin, true);
                                    editor.putString(ServiceHelper.EMAIL, loginResponse.getUser().getEmail());
                                    editor.putString(ServiceHelper.PASSWORD, password);
                                    editor.putString(ServiceHelper.TOKEN, loginResponse.getToken());
                                    editor.putInt(ServiceHelper.ID, loginResponse.getUser().getId());
                                    editor.putString(ServiceHelper.ST_PROFILE_IMAGE, loginResponse.getUser().getProfile_photo());
                                    editor.putString(ServiceHelper.ST_NAME, loginResponse.getUser().getName());
                                    editor.apply();
                                    LoginActivity.this.finish();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                                }else {
                                    error.setVisibility(View.VISIBLE);

                                }


                            }else {
                                error.setVisibility(View.VISIBLE);
                            }
                            progressDoalog.dismiss();

                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                            Toast.makeText(LoginActivity.this, "Something went wrong. Try again", Toast.LENGTH_SHORT).show();

                            progressDoalog.dismiss();
                            Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();



                        }
                    });

                }
                break;
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this, Registration.class));
                this.finish();
                break;
        }
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
