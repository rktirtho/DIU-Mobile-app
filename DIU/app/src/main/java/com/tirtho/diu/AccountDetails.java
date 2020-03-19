package com.tirtho.diu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tirtho.com.tirtho.account.AccountServices;
import com.tirtho.com.tirtho.account.AccountSummry;
import com.tirtho.com.tirtho.account.Summary;
import com.tirtho.com.tirtho.account.TuitionFee;
import com.tirtho.com.tirtho.account.TutionFeeService;
import com.tirtho.com.tirtho.diu.custome.list.TransectionAdepter;

import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountDetails extends AppCompatActivity {
    Button viewTransection;
    AccountServices services;
    ProgressDialog progressDoalog;

    TextView actualFee, scholarship, perSemesterFeeWithoutSc, perSemFee, totalPaid, currentDue, totalDue, t,
            batch, session, shift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        viewTransection = findViewById(R.id.btn_view_transection);

        actualFee = findViewById(R.id.tv_actual_fee);
        scholarship = findViewById(R.id.tv_scholarship);
        perSemesterFeeWithoutSc = findViewById(R.id.tv_semFeeWithoutSc);
        perSemFee = findViewById(R.id.tv_perSemFee);
        totalPaid = findViewById(R.id.tv_total_paid);
        currentDue = findViewById(R.id.tv_currentDue);
        totalDue = findViewById(R.id.tv_total_due);
        batch = findViewById(R.id.tv_batch);
        session = findViewById(R.id.tv_session);
        shift = findViewById(R.id.tv_shift);

        t = findViewById(R.id.test);

        progressDoalog = new ProgressDialog(AccountDetails.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Fatching Data....");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TransectionDetails.BASE_URL)
                .client(getUnsafeOkHttpClient().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        services = retrofit.create(AccountServices.class);

        Call<AccountSummry> listCall = services.getSummery();
        listCall.enqueue(new Callback<AccountSummry>() {
            @Override
            public void onResponse(Call<AccountSummry> call, Response<AccountSummry> response) {


                if (response.isSuccessful()) {

                    AccountSummry summary = response.body();
                    actualFee.setText(summary.getSummary().getActualTotalFee() + "");
                    scholarship.setText(summary.getSummary().getSpecialScholarship() + "");
                    perSemesterFeeWithoutSc.setText(summary.getSummary().getPerSemesterFeeWithoutScholarship() + "");
                    perSemFee.setText(summary.getSummary().getPerSemesterFee() + "");
                    totalPaid.setText(summary.getSummary().getTotalPaid() + "");
                    totalDue.setText(summary.getSummary().getTotalDue() + "");
                    currentDue.setText(summary.getSummary().getTotalCurrentDue().intValue() + "");

                    batch.setText("Batch: " + summary.getSummary().getBatch().getBatchName());
                    session.setText("Session: " + summary.getSummary().getBatch().getSess());
                    if (summary.getSummary().getBatch().getShiftId().equals("2")) {
                        shift.setText("Shift: Evening" );
                    }else {
                        shift.setText("Shift: Day" );
                    }

                }
                t.setText(response.code()+"\n"+response.toString());
                progressDoalog.dismiss();
            }

            @Override
            public void onFailure(Call<AccountSummry> call, Throwable t) {
                progressDoalog.dismiss();

            }


        });
        viewTransection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountDetails.this, TransectionDetails.class));
            }
        });
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