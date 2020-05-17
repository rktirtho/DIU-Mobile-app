package com.tirtho.com.tirtho.account;

import com.tirtho.diu.com.tirtho.others.ServiceHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface TutionFeeService {
    @GET("/student_account_info/{id}")
    Call<List<TuitionFee>> getAll(
            @Path("id") int id,
            @Query("token")String token);


}
