package com.tirtho.com.tirtho.registration;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BatchServices {

    @GET("/public/get_batch_id_name/{id}")
    Call<List<Batch>> getBatches(
            @Path("id") String id
    );
}
