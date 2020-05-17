package com.tirtho.com.tirtho.user;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProfileService {

    @GET("/student/profile")
    Call<UserProfile> getProfile(
            @Query("token")String token
    );
}
