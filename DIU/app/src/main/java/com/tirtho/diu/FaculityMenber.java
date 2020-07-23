package com.tirtho.diu;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.tirtho.com.tirtho.diu.custome.list.CustomFaculityList;
import com.tirtho.diu.services.AdministrationService;
import com.tirtho.pojo.Faculaty;

import org.jetbrains.annotations.NotNull;

import java.security.cert.CertificateException;
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

public class FaculityMenber extends AppCompatActivity {

    ListView listView;

    ProgressDialog progressDoalog;
   AdministrationService administrationService;

   TextView test ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculity_menber);

        listView = findViewById(R.id.faculity_list);
        test = findViewById(R.id.test);

        progressDoalog = new ProgressDialog(FaculityMenber.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Fatching Data....");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();



        String selected= getIntent().getStringExtra("selected");
        this.setTitle(selected);

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

        administrationService = retrofit.create(AdministrationService.class);


        Call<List<Faculaty>> response=null;


        switch (selected){
            case "Academic Council":
                response= administrationService.getAcademic();
                break;
            case "Board of Trustees":
                response= administrationService.getBOT();
                break;
            case "Syndicate":
                response= administrationService.getSyndicate();
                break;

        }


        response.enqueue(new Callback<List<Faculaty>>() {
            @Override
            public void onResponse(@NotNull Call<List<Faculaty>> call, @NotNull Response<List<Faculaty>> response) {

                if (response.isSuccessful() && response.code()<300) {
                    List<Faculaty> administrationList = response.body();
                    CustomFaculityList faculityList = new CustomFaculityList
                            (FaculityMenber.this,R.layout.model_faculity,administrationList);
                    listView.setAdapter(faculityList);



                }
//                test.setText(response.body().get(0).getName());
                progressDoalog.dismiss();


            }

            @Override
            public void onFailure(Call<List<Faculaty>> call, Throwable t) {
                Log.e("Adapter error", t.getMessage());
                test.setText(t.getMessage());
                progressDoalog.dismiss();

            }
        });






//        listView = findViewById(R.id.faculity_list);
//
//
//
//
//        List<Faculaty> faculaties = new ArrayList<>();
//
//        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
//        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
//        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
//        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
//        faculaties.add(new Faculaty(R.drawable.key_p_prof_hasan_babu,"Professor Hafiz Md. Hasan Babu", "Member\nNominated By Syndicate"));
//
//
//
//


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
