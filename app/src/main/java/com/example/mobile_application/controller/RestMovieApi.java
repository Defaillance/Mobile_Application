package com.example.mobile_application.controller;

import com.example.mobile_application.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestMovieApi {

    @GET("films")
    Call<List<Movie>> getListMovie();

    @GET("films/{id}")
    Call<Movie> getMovie(@Path("id") String id);
}
