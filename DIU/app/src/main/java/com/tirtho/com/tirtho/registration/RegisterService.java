package com.tirtho.com.tirtho.registration;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RegisterService {

    @GET("checkout/{dept}/{batch}/{reg}/{roll}/{phone}")
    Call<String> checkout(
            @Path("dept")String dept,
            @Path("batch") String batch,
            @Path("reg") String reg,
            @Path("roll") String roll,
            @Path("phone") String phone
    );
}
