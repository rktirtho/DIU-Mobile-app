package com.tirtho.diu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tirtho.com.tirtho.diu.custome.list.NoticeAdepter;
import com.tirtho.diu.services.NoticeService;

import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Notice extends AppCompatActivity {

    ListView noticeList;
    NoticeService noticeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        noticeList = findViewById(R.id.noticeList);

//        List<com.tirtho.pojo.Notice> notices = new ArrayList<>();
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","21\nMAR"));
//        notices.add(new com.tirtho.pojo.Notice("Exam Postponed Due To corona virous", "All Campus Remain close from 16 march to 31 march","15\nMAR"));
//        notices.add(new com.tirtho.pojo.Notice("Exam Schedule", "Exma Schedule is here.","11\nMAR"));
//        notices.add(new com.tirtho.pojo.Notice("Improvment Exam", "Give your tution fee in ","10\nMAR"));
//        notices.add(new com.tirtho.pojo.Notice("Olnine Pament System", "Give your tution fee in ","01\nMAR"));
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","31\nFEB"));
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","21\nFEB"));
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","12\nFEB"));
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","08\nFEB"));
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","01\nFEB"));
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","24\nJAN"));
//        notices.add(new com.tirtho.pojo.Notice("Tuition Fee", "Give your tution fee in ","21\nJAN"));

        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(getCacheDir(), cacheSize);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://admindiu.000webhostapp.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        noticeService = retrofit.create(NoticeService.class);

        Call<List<com.tirtho.pojo.Notice>> call = noticeService.getNotices();

        call.enqueue(new Callback<List<com.tirtho.pojo.Notice>>() {
            @Override
            public void onResponse(Call<List<com.tirtho.pojo.Notice>> call, final Response<List<com.tirtho.pojo.Notice>> response) {
                if (response.isSuccessful() && response.code()<300){
                    NoticeAdepter adepter = new NoticeAdepter(Notice.this, R.layout.model_notice, response.body());
                    noticeList.setAdapter(adepter);

                    noticeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(Notice.this, NoticeView.class);
                            intent.putExtra("title", response.body().get(position).getTitle());
                            intent.putExtra("date", response.body().get(position).getDate());
                            intent.putExtra("image", response.body().get(position).getText());
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<com.tirtho.pojo.Notice>> call, Throwable t) {


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
