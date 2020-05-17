package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;

public class ViceChancelor extends AppCompatActivity {

    ImageView iv_vc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vice_chancelor);
        iv_vc = findViewById(R.id.iv_vc);

        Glide.with(this)
                .load("https://diu.ac/wp-content/themes/diu-theme-lite-v1/images/Professor%20Dr.K.M.Mohsin.jpg")
                .placeholder(R.drawable.prof_placeholder)
                .error(R.drawable.prof_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv_vc);


//

    }
}
