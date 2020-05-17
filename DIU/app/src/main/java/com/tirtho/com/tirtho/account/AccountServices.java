package com.tirtho.com.tirtho.account;

import com.tirtho.diu.MainActivity;
import com.tirtho.diu.com.tirtho.others.ServiceHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AccountServices {

    @GET("student_account_info_summary/{id}")
    Call<AccountSummry> getSummery(
            @Path ("id")int id ,
            @Query("token") String token);
}
