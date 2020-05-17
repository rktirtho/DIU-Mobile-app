package com.tirtho.com.tirtho.com.tirtho.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/student/login")
    Call<LoginResponse> login(
            @Body()UserLogin userLogin);
}
