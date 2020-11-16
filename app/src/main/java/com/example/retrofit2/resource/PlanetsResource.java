package com.example.retrofit2.resource;

import com.example.retrofit2.model.DefaultModel;
import com.example.retrofit2.model.Planet;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PlanetsResource<T, E> {
    @POST("planets")
    Call<Planet> post(@Body Planet planets);

    @GET("planets/{id}")
    Call<Planet> get(@Path("id") Integer id);

    @GET("planets")
    Call<DefaultModel> get();

    @PUT("planets/{id}")
    Call<Void> put(@Path("id") Integer id, @Body Planet planets);

    @PATCH("planets/{id}")
    Call<Void> patch(@Path("id") Integer id, @Body Planet planets);

    @DELETE("planets/{id}")
    Call<Void> delete(@Path("id") Integer id);
}
