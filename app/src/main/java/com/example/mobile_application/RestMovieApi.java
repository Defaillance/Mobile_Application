package com.example.mobile_application;

import com.example.mobile_application.model.RestMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestMovieApi {

    @GET("films")
    Call<RestMovieResponse> getListMovie();
}
