package com.tirtho.diu.services;

import com.tirtho.diu.Administration;
import com.tirtho.pojo.Faculaty;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdministrationService {

    @GET("/bot")
    public Call<List<Faculaty>> getBOT();

    @GET("/academic")
    public Call<List<Faculaty>> getAcademic();

    @GET("/syndicate")
    public Call<List<Faculaty>> getSyndicate();


}
