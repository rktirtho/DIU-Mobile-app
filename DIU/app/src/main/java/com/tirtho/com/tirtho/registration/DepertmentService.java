package com.tirtho.com.tirtho.registration;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DepertmentService {
    @GET("/public/get_departments")
    Call<List<Depertment>> getDepartments();
}
