package com.example.mobile_application.controller;

import com.example.mobile_application.vue.Detail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.mobile_application.model.Movie;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailController {

    private final String id;
    private Detail activity;

    private RestMovieApi restMovieApi;

    public DetailController(Detail mainActivity, String id) {
        this.id = id;
        this.activity = mainActivity;
    }

    public void onStart(){


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restMovieApi = retrofit.create(RestMovieApi.class);
        makeApiCall();

    }

    private void makeApiCall() {
        Call<Movie> call = restMovieApi.getMovie(id);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call,
                                   Response<Movie> response) {
                Movie restMovieResponse = response.body();
                Log.d("TAGG", response.code()+"");

                //activity.showMovie(restMovieResponse.getTitle(),restMovieResponse.getDirector(),restMovieResponse.getRelease_date());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.d("ERROR", "Api Error");

            }
        });
    }

    private void storeData(List<Movie> listMovie) {
        //TODO

    }

    private List<Movie> getListFromDataBase() {
        //TODO Implement With real logic
        return new ArrayList<>();
    }

    private boolean hasDataInDataBase() {
        //TODO Implement With real logic
        return true;
    }
}
