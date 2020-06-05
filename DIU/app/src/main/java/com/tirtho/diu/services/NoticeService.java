package com.tirtho.diu.services;

import com.tirtho.pojo.Notice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NoticeService {

    @GET("/notice")
    Call<List<Notice>> getNotices();
}
