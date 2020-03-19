package com.tirtho.diu;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class TransectionDetails extends AppCompatActivity {
    ListView transectonList;

    private TutionFeeService service;

    ProgressDialog progressDoalog;

    public static String BASE_URL="https://api.diu.ac/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transection_details);
        transectonList = findViewById(R.id.transectionList);


        progressDoalog = new ProgressDialog(TransectionDetails.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Fatching Data....");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getUnsafeOkHttpClient().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TutionFeeService.class);

        Call<List<TuitionFee>> listCall = service.getAll();
        listCall.enqueue(new Callback<List<TuitionFee>>() {
            @Override
            public void onResponse(Call<List<TuitionFee>> call, Response<List<TuitionFee>> response) {
                if (response.isSuccessful() && response.code()<300) {

                    List<TuitionFee> fees = response.body();
                    TransectionAdepter adepter = new TransectionAdepter(TransectionDetails.this, R.layout.model_transection, fees);
                    transectonList.setAdapter(adepter);

                }else {
                    Toast.makeText(TransectionDetails.this, "Error Code "+response.code(), Toast.LENGTH_LONG).show();

                }
                progressDoalog.dismiss();


            }

            @Override
            public void onFailure(Call<List<TuitionFee>> call, Throwable t) {
                t.printStackTrace();
                progressDoalog.dismiss();
                Toast.makeText(TransectionDetails.this, "Error Code "+t.getStackTrace(), Toast.LENGTH_SHORT).show();

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
