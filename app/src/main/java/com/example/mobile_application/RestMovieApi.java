package com.example.mobile_application;

import com.example.mobile_application.model.Movie;
import com.example.mobile_application.model.RestMovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestMovieApi {

    @GET("films")
    Call<List<Movie>> getListMovie();

    @GET("films/{id}")
    Call<Movie> getMovie(@Path("id") String id);
}
