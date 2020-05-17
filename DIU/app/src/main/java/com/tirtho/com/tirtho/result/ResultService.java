package com.tirtho.com.tirtho.result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ResultService {
    @GET("/provisional_result/{id}")
    Call<Result> getResult(
            @Path("id") int id,
            @Query("token")String token

    );
}
