package com.tirtho.diu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;

public class NoticeView extends AppCompatActivity {

    TextView tvTitle, tvDate;
    ImageView notieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_view);

        tvDate = findViewById(R.id.tv_date);
        tvTitle = findViewById(R.id.tv_title);
        notieView = findViewById(R.id.iv_notice);


        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String date = getIntent().getStringExtra("date");

        this.setTitle(title);


        tvTitle.setText(title);
        tvDate.setText(date);

        Glide.with(this)
                .load(image)
                .placeholder(R.drawable.ic_event_note_black_64dp)
                .error(R.drawable.prof_placeholder)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(notieView);

    }
}
