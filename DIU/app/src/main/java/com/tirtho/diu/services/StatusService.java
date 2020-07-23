package com.tirtho.diu.services;

import com.tirtho.pojo.Status;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StatusService {

    @GET("/status")
    Call<Status> getStatus();
}
